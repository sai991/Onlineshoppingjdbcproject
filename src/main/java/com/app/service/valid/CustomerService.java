package com.app.service.valid;

import com.app.exception.BusinessException;
import com.app.model.Customer;

public interface CustomerService {
	public int createCustomer(Customer customer) throws BusinessException;
}
