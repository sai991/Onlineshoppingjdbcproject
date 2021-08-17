package com.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.app.dao.CartDAO;
import com.app.dao.dbutil.MySqlDbConnection;
import com.app.exception.BusinessException;
import com.app.model.Cart;
import com.app.model.Products;
import com.app.model.Temp;

public class CartDAOImpl implements CartDAO {

	@Override
	public int addToCart(int cid, int pid, int quantity) throws BusinessException {
		int c = 0;
		try (Connection connection = MySqlDbConnection.getConnection()) {
			String sql = "insert into cart(cid,pid,quantity) values(?,?,?)";

			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1,cid);
			preparedStatement.setInt(2,pid);
			preparedStatement.setInt(3,quantity);
			c = preparedStatement.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);// this will be replaced by logger
			throw new BusinessException("Internal error occured, please contact support");
		}
		return c;
	}

	@Override
	public List<Temp> getAllItemsInCart(int id) throws BusinessException {
		List<Temp> playerList = new ArrayList<>();
		try (Connection connection = MySqlDbConnection.getConnection()) {
			String sql = "select p.pid,pname,cost,quantity from products p join cart on cart.cid=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1,id);	
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				Temp product = new Temp();
				product.setPid(resultSet.getInt("pid"));
				product.setPname(resultSet.getString("pname"));
				product.setCost(resultSet.getInt("cost"));
				Cart cart = new Cart();
				cart.setCid(id);
				cart.setPid(resultSet.getInt("pid"));
				cart.setQuantity(resultSet.getInt("quantity"));
				product.setCart(cart);
				playerList.add(product);
				
			} 

		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);// this will be replaced by logger
			throw new BusinessException("Internal error occured, please contact support");
		}
		
		return playerList;
	}

}
