package com.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.app.dao.CustomerDAO;
import com.app.dao.dbutil.MySqlDbConnection;
import com.app.exception.BusinessException;
import com.app.model.Customer;

public class CustomerDAOImpl implements CustomerDAO {

	@Override
	public int createCustomer(Customer customer) throws BusinessException {
		int c = 0;
		try (Connection connection = MySqlDbConnection.getConnection()) {
			String sql = "insert into customer(cid,cname,emailid,password,contact,address) values(?,?,?,?,?,?)";

			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, customer.getCid());
			preparedStatement.setString(2, customer.getCname());
			preparedStatement.setString(3, customer.getEmailid());
			preparedStatement.setString(4, customer.getPassword());
			preparedStatement.setLong(5, customer.getContact());
			preparedStatement.setString(6, customer.getAddress());
			
			c = preparedStatement.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);// this will be replaced by logger
			throw new BusinessException("Internal error occured, please contact support");
		}
		return c;
	
	}

	@Override
	public Customer isValidUser(String s) throws BusinessException {
		Customer customer = null;
		try (Connection connection = MySqlDbConnection.getConnection()) {
			String sql = "select cid,cname,emailid,password,contact,address from customer where emailid=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1,s);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				customer = new Customer();
				customer.setCid(resultSet.getInt("cid"));
				customer.setCname(resultSet.getString("cname"));
				customer.setEmailid(resultSet.getString("emailid"));
				customer.setPassword(resultSet.getString("password"));
				customer.setContact(resultSet.getLong("contact"));
				customer.setAddress(resultSet.getString("address"));			
			} else {
				throw new BusinessException("Entered email id  " + s + " doesnt exist");
			}
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);
			throw new BusinessException("Internal error occured contact sysadmin");
		}
		return customer;

	
	}

}
