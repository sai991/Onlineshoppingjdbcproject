package com.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.app.dao.EmployeDAO;
import com.app.dao.dbutil.MySqlDbConnection;
import com.app.exception.BusinessException;

public class EmployeDAOImpl implements EmployeDAO {

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

}
