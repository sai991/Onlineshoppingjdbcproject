package com.app.service.valid.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.app.Main;
import com.app.dao.EmployeDAO;
import com.app.dao.impl.EmployeDAOImpl;
import com.app.exception.BusinessException;
import com.app.model.Products;
import com.app.service.valid.EmployeService;

public class EmployeServiceImpl implements EmployeService {
	private static Logger log = Logger.getLogger(EmployeServiceImpl.class);
	@Override
	public int updateCost(int pid, double cost) throws BusinessException {
		EmployeDAO g=new EmployeDAOImpl();
	int k=g.updateCost(pid, cost);
	if(k!=1) {
		throw new BusinessException("Updation failed.");
	}else
	{
		log.info("Cost updated successfully");
	}
		
		return pid;
		
	}
	@Override
	public List<Products> getProductByName(String name) throws BusinessException {
		EmployeDAO lkm = new EmployeDAOImpl();
		List<Products> playerList=null;
		if(name.matches("[a-zA-Z_-]{2,20}")) {
			//code here to DAO
			playerList=lkm.getProductByName(name);
		}else {
			throw new BusinessException("Invalid product name : "+name);
		}
		return playerList;
	}
	@Override
	public List<Products> getProductById(int id) throws BusinessException {
		List<Products> playerList=null;
		EmployeDAO lkm = new EmployeDAOImpl();

		if(id<0 ||id>1000) {
			throw new BusinessException("Invalid Product Id "+id);
		}else {
			//code here to DAO
			playerList=lkm.getProductById(id);
			
		}
		return playerList;
	
	}

}
