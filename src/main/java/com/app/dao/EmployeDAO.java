package com.app.dao;

import java.util.List;

import com.app.exception.BusinessException;
import com.app.model.*;

public interface EmployeDAO {
	public int markOrderShipped(int oid)throws BusinessException;
	public List<PlaceOrder> ordersReceivedByCustomer()throws BusinessException;
	public List<Products> getProductByName(String name)throws BusinessException;
	public List<Products> getProductById(int id)throws BusinessException;
    public int updateCost(int pid,double cost)throws BusinessException;
}
