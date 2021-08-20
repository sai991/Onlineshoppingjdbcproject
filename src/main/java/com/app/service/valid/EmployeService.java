package com.app.service.valid;

import java.util.List;

import com.app.exception.BusinessException;
import com.app.model.Products;

public interface EmployeService {
	public int updateCost(int pid,double cost)throws BusinessException;
	public List<Products> getProductByName(String name)throws BusinessException;
	public List<Products> getProductById(int id)throws BusinessException;
	
}
