package com.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.app.Main;
import com.app.dao.ProductsDAO;
import com.app.dao.dbutil.MySqlDbConnection;
import com.app.exception.BusinessException;
import com.app.model.Products;

public class ProductsDAOImpl implements ProductsDAO {
	private static Logger log = Logger.getLogger(ProductsDAOImpl.class);


	@Override
	public List<Products> getAllProducts() throws BusinessException {
		List<Products> productList = new ArrayList<>();
		try (Connection connection = MySqlDbConnection.getConnection()) {
			String sql = "select pid,pname,cost from products";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

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
	public Products getProductById(int id) throws BusinessException {
		Products product =null;
	
		try (Connection connection = MySqlDbConnection.getConnection()) {
			String sql = "select pid,pname,cost from products where pid=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1,id);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
			    product = new Products();
				product.setPid(id);
				product.setPname(resultSet.getString("pname"));
				product.setCost(resultSet.getDouble("cost"));
			    
			} else {
				throw new BusinessException("Entered player id " + id + " doesnt exist");
			}
		} catch (ClassNotFoundException | SQLException e) {
			log.error(e);
			throw new BusinessException("Internal error occured contact sysadmin");
		}
		return product;
		
	}


	@Override
	public int insertIntoProducts(Products product) throws BusinessException {
		int c=0;
		try (Connection connection = MySqlDbConnection.getConnection()) {
			String sql = "insert into products(pid,pname,cost) values(?,?,?)"; 
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1,product.getPid());
			preparedStatement.setString(2,product.getPname());
			preparedStatement.setDouble(3,product.getCost());
			c = preparedStatement.executeUpdate();
		 }catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);// this will be replaced by logger
			throw new BusinessException("Internal error occured, please contact support");
		}
		return c;
	}
		
	

}
