package com.app.service.valid;

import com.app.exception.BusinessException;
import com.app.model.Customer;

public interface LoginValidation {
	
	public int isValidLogin(Customer customer)throws BusinessException;
	public Customer isValidUser(String s)throws BusinessException;
	
	
	
	

}
