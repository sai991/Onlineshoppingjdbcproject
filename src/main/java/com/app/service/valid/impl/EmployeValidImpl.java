package com.app.service.valid.impl;

import com.app.dao.EmployeDAO;
import com.app.dao.impl.EmployeDAOImpl;
import com.app.exception.BusinessException;
import com.app.service.valid.EmployeValid;

public class EmployeValidImpl implements EmployeValid {

	@Override
	public void isValidOid(int shp) throws BusinessException {
		
		EmployeDAO ed=new EmployeDAOImpl();
		int os=ed.markOrderShipped(shp);
		if(os==1) {
			System.out.println("Order id"+ shp +"is marked as shiped:");
			
		}else
		{
			System.out.println("Failed to update order shipment!!try again");
		}
		
		
	}

}
