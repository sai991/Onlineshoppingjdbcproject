package com.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.app.Main;
import com.app.dao.EmployeDAO;
import com.app.dao.dbutil.MySqlDbConnection;
import com.app.exception.BusinessException;
import com.app.model.PlaceOrder;
import com.app.model.Products;

public class EmployeDAOImpl implements EmployeDAO {
	private static Logger log = Logger.getLogger(Main.class);
	@Override
	public int markOrderShipped(int oid) throws BusinessException {
		String mark = "true";
		int c = 0;
		try (Connection connection = MySqlDbConnection.getConnection()) {
			String sql = "update orders set orderShipped=? where oid=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, mark);
			preparedStatement.setInt(2, oid);

			c = preparedStatement.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);// this will be replaced by logger
			throw new BusinessException("Internal error occured, please contact support");
		}

		return c;
	}

	@Override
	public List<PlaceOrder> ordersReceivedByCustomer() throws BusinessException {
		String mark="true";
		PlaceOrder product=new PlaceOrder();
		List<PlaceOrder> lpo=new ArrayList();
		
		try (Connection connection = MySqlDbConnection.getConnection()) {
			String sql = "select oid,customer.cid,Cname,address,pid,pname,cost from orders join customer on orders.cid=customer.cid and orderREceived=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, mark);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
			
				product.setOid(resultSet.getInt("oid"));
				product.setPid(resultSet.getInt("pid"));
				product.setPname(resultSet.getString("pname"));
				product.setOrderReceived(resultSet.getString("address"));
				product.setCost(resultSet.getDouble("cost"));
				product.setCid(resultSet.getInt("cid"));
				
				
				lpo.add(product);
				
			}

		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);// this will be replaced by logger
			throw new BusinessException("Internal error occured, please contact support");
		}

		return lpo;
		
	}

	@Override
	public List<Products> getProductByName(String name) throws BusinessException {
		List<Products> productList = new ArrayList<>();
		try (Connection connection = MySqlDbConnection.getConnection()) {
			String sql = "select pid,pname,cost from products where pname=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1,name);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Products product = new Products();
				product.setPid(resultSet.getInt("pid"));
				product.setPname(resultSet.getString("pname"));
				product.setCost(resultSet.getDouble("cost"));
				productList.add(product);
				
			}
		} catch (ClassNotFoundException | SQLException e) {
			log.warn(e);// this will be replaced by logger
			throw new BusinessException("Internal error occured, please contact support");
		}

		return productList;
	}

	@Override
	public List<Products> getProductById(int id) throws BusinessException {
		List<Products> productList = new ArrayList<>();
		try (Connection connection = MySqlDbConnection.getConnection()) {
			String sql = "select pid,pname,cost from products where pid=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1,id);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Products product = new Products();
				product.setPid(resultSet.getInt("pid"));
				product.setPname(resultSet.getString("pname"));
				product.setCost(resultSet.getDouble("cost"));
				productList.add(product);
				
			}
		} catch (ClassNotFoundException | SQLException e) {
			log.warn(e);// this will be replaced by logger
			throw new BusinessException("Internal error occured, please contact support");
		}

		return productList;
	
	}

}
