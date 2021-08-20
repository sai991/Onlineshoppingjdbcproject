package com.app.service.valid.impl;

import java.util.ArrayList;
import java.util.List;

import com.app.dao.CartDAO;
import com.app.dao.PlaceOrderDAO;
import com.app.dao.impl.CartDAOImpl;
import com.app.dao.impl.PlaceOrderImpl;
import com.app.exception.BusinessException;
import com.app.model.PlaceOrder;
import com.app.model.Temp;
import com.app.service.valid.PlaceOrderService;

public class PlaceOrderServiceImpl implements PlaceOrderService {

	@Override
	public double placingOrder(List<Temp> products, int cid) throws BusinessException {
	    double n=0;
	    if(cid!=0) {
	    	 
				PlaceOrderDAO placeorder = new PlaceOrderImpl();
				 n = placeorder.placingOrder(products, cid);
	     }
	     else
	     {
	    	 System.out.println("Invalid cid");
	     }
		return n;
	}

	@Override
	public List<PlaceOrder> displayOrders() throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PlaceOrder> getOrdersById(int cid) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int markOrderReceive(int oid) throws BusinessException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String isOrderShipped(int oid) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

}
