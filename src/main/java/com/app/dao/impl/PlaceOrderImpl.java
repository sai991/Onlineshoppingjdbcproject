package com.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;

import com.app.Main;
import com.app.dao.PlaceOrderDAO;
import com.app.dao.dbutil.MySqlDbConnection;
import com.app.exception.BusinessException;
import com.app.model.Cart;
import com.app.model.PlaceOrder;
import com.app.model.Products;
import com.app.model.Temp;

public class PlaceOrderImpl implements PlaceOrderDAO {
	private static Logger log = Logger.getLogger(PlaceOrderImpl.class);
	@Override
	public double placingOrder(List<Temp> products,int cid) throws BusinessException {
		double totalcost = 0;
		int a=0;
		boolean orderShipped=false;
		boolean orderReceived=false;
		try (Connection connection = MySqlDbConnection.getConnection()) {
			String sql = "insert into orders(cid,pid,pname,cost,quantity,orderShipped,orderReceived) values(?,?,?,?,?,?,?)"; 
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			for(int i=0;i<products.size();i++) {
			preparedStatement.setInt(1,cid);
			preparedStatement.setInt(2,products.get(i).getPid());
			preparedStatement.setString(3,products.get(i).getPname());
			preparedStatement.setDouble(4,products.get(i).getCost());
			preparedStatement.setInt(5,products.get(i).getCart().getQuantity());
			preparedStatement.setBoolean(6,orderShipped);
			preparedStatement.setBoolean(7,orderReceived);
			totalcost=totalcost+(products.get(i).getCost())*(products.get(i).getCart().getQuantity());
			int c = preparedStatement.executeUpdate();
		     a=a+c;
			
		} }catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);// this will be replaced by logger
			throw new BusinessException("Internal error occured, please contact support");
		}
		if(a==products.size()) {
			log.info("order placed successfully");
		}
		else
		{
			throw new BusinessException("Failed to place orde,retry again");
		}
		
		
		
	return totalcost;
	}
	@Override
	public List<PlaceOrder> displayOrders() throws BusinessException {
		List<PlaceOrder> orderList = new ArrayList<>();
		try (Connection connection = MySqlDbConnection.getConnection()) {
			String sql = "select oid,cid,pid,pname,cost,quantity,orderShipped,orderReceived from orders";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				PlaceOrder product = new PlaceOrder();
				product.setOid(resultSet.getInt("oid"));
				product.setCid(resultSet.getInt("cid"));
				product.setPid(resultSet.getInt("pid"));
				product.setPname(resultSet.getString("pname"));
				product.setCost(resultSet.getDouble("cost"));
				product.setQuantity(resultSet.getInt("quantity"));
				product.setOrderShipped(resultSet.getString("orderShipped"));
				product.setOrderReceived(resultSet.getString("orderReceived"));
				orderList.add(product);
				
			}
		} catch (ClassNotFoundException | SQLException e) {
			log.warn(e);// this will be replaced by logger
			throw new BusinessException("Internal error occured, please contact support");
		}

		return orderList;
	}
	@Override
	public List<PlaceOrder> getOrdersById(int cid) throws BusinessException {
		List<PlaceOrder> orderList = new ArrayList<>();
		try (Connection connection = MySqlDbConnection.getConnection()) {
			String sql = "select oid,cid,pid,pname,cost,quantity,orderShipped,orderReceived from orders where cid=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1,cid);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				PlaceOrder product = new PlaceOrder();
				product.setOid(resultSet.getInt("oid"));
				product.setCid(resultSet.getInt("cid"));
				product.setPid(resultSet.getInt("pid"));
				product.setPname(resultSet.getString("pname"));
				product.setCost(resultSet.getDouble("cost"));
				product.setQuantity(resultSet.getInt("quantity"));
				product.setOrderShipped(resultSet.getString("orderShipped"));
				product.setOrderReceived(resultSet.getString("orderReceived"));
				orderList.add(product);
				
			}
		} catch (ClassNotFoundException | SQLException e) {
			log.warn(e);// this will be replaced by logger
			throw new BusinessException("Internal error occured, please contact support");
		}

		return orderList;

	}
	@Override
	public int markOrderReceive(int oid) throws BusinessException {
		String mark = "true";
		int c = 0;
		try (Connection connection = MySqlDbConnection.getConnection()) {
			String sql = "update orders set orderReceived=? where oid=?";
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
	
	}
