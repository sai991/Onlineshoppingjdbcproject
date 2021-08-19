package com.app.service.valid.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.app.Main;
import com.app.dao.CustomerDAO;
import com.app.dao.dbutil.MySqlDbConnection;
import com.app.dao.impl.CustomerDAOImpl;
import com.app.exception.BusinessException;
import com.app.model.Customer;
import com.app.service.valid.LoginValidation;

public class LoginValidationImpl implements LoginValidation {

	private static Logger log = Logger.getLogger(LoginValidationImpl.class);

	@Override
	public int isValidLogin(Customer customer) {
		int c=0,k=0;
	
		if (customer.getCid() != 0)  {

	    if (customer.getCname().matches("^[A-Za-z ]{3,30}$")) {

	      if (customer.getEmailid().matches("^[A-Za-z0-9]+[A-Za-z0-9-.]*[@][A-Za-z0-9]+[.][a-zA-Z]+$")) {

	         if (String.valueOf(customer.getContact()).matches("[1-9]{1}[0-9]{9}")) {c=1;}
	             else {  log.info("Invalid contact number");}}
	    else { log.info("Invalid emailid");}}
	    else { log.info("Invalid customername");}}
	  else { log.info("Invalid id for customer");}
		if(c==1) {
			CustomerDAO customerdao=new CustomerDAOImpl();
				 try {
					k = customerdao.createPlayer(customer);
				} catch (BusinessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (k == 1) {
					log.info("Signup successfull");
					log.info("Re-Login to use the app");
				} else {
					log.info("singn up failed,Kindly retry");
				}
		}
		else
		{
			log.info("Invalid login credentials"); 
		}
	               
	               
	               
		return 0;
	}

	@Override
	public Customer isValidUser(String s) throws BusinessException {
		Customer customer = new Customer();
		customer = null;

		if (s.matches("^[A-Za-z0-9]+[A-Za-z0-9-.]*[@][A-Za-z0-9]+[.][a-zA-Z]+$")) {
			CustomerDAO customerdao = new CustomerDAOImpl();
			customer = customerdao.isValidUser(s);

		} else

		{
			log.info("Invalid emailid try again");
		}

		return customer;
	}

}
