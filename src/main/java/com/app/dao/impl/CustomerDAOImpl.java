package com.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.app.dao.CustomerDAO;
import com.app.dao.dbutil.MySqlDbConnection;
import com.app.exception.BusinessException;
import com.app.model.Customer;

public class CustomerDAOImpl implements CustomerDAO {

	@Override
	public int createPlayer(Customer customer) throws BusinessException {
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

}
