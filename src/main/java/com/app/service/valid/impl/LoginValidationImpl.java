package com.app.service.valid.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.app.dao.dbutil.MySqlDbConnection;
import com.app.exception.BusinessException;
import com.app.model.Customer;
import com.app.service.valid.LoginValidation;

public class LoginValidationImpl implements LoginValidation {

	
	@Override
	public int isValidLogin(Customer customer) {
		//if(customer.getCid().matches("[0-9]*"));
		return 0;
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
