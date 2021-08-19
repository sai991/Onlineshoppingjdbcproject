package com.app.dao;

import java.util.List;

import com.app.exception.BusinessException;
import com.app.model.*;

public interface PlaceOrderDAO {
	public double placingOrder(List<Temp> products,int cid)throws BusinessException;
	public List<PlaceOrder> displayOrders() throws BusinessException;
	public List<PlaceOrder> getOrdersById(int cid) throws BusinessException;
	public int markOrderReceive(int oid)throws BusinessException;
	public String isOrderShipped(int oid)throws BusinessException;
	
}
	
