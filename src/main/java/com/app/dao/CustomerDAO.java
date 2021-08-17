package com.app.dao;

import com.app.exception.BusinessException;
import com.app.model.Customer;

public interface CustomerDAO {
	
	public int createPlayer(Customer customer) throws BusinessException;
}
