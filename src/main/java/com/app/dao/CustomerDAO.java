package com.app.dao;

import com.app.exception.BusinessException;
import com.app.model.Customer;

public interface CustomerDAO {
	
	public int createCustomer(Customer customer) throws BusinessException;
	public Customer isValidUser(String s) throws BusinessException;
}
