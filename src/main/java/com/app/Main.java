package com.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.app.dao.CartDAO;
import com.app.dao.CustomerDAO;
import com.app.dao.PlaceOrderDAO;
import com.app.dao.ProductsDAO;
import com.app.dao.impl.CartDAOImpl;
import com.app.dao.impl.CustomerDAOImpl;
import com.app.dao.impl.PlaceOrderImpl;
import com.app.dao.impl.ProductsDAOImpl;
import com.app.exception.BusinessException;
import com.app.model.Customer;
import com.app.model.Products;
import com.app.model.Temp;
import com.app.service.valid.LoginValidation;
import com.app.service.valid.impl.LoginValidationImpl;



public class Main {
	private static Logger log = Logger.getLogger(Main.class);
	public static void main(String[] args) throws BusinessException {
		
		Scanner sc = new Scanner(System.in);
		int ch=0;
		do
		{ 
		log.info("Welcome to Mithra Online Shopping portal");
		log.info("==========================================");
		log.info("***********PLEASE LOGIN ******************");
		log.info("____________________________");
		log.info("|1.Employee login           |");
		log.info("|2.Customer login           |");
		log.info("|3.NewUser? signup!         |");
		log.info("|4.Exit                     |");
		log.info("|___________________________|");
		log.info("Enter Ur Choice");
		try {
			ch = Integer.parseInt(sc.nextLine());
		} catch (NumberFormatException e) {
			log.warn(e);
		}
		switch (ch) {
		case 1:
			
			
			break;
		case 2:log.info("Enter email id:");
		       String email=sc.nextLine();
		       LoginValidation a=new LoginValidationImpl();
		       Customer customer1=new Customer();
		       customer1= a.isValidUser(email);
		       final int cid=customer1.getCid();
		       log.info("Enter password:");
		       String pass=sc.nextLine();
		       String d=customer1.getPassword();
		       if(customer1.getPassword().equals(pass)){
		    	 log.info("Successfully signed in");
		    	 log.info("Welcome "+customer1.getCname());
		    	 do
		    	 {
		    	log.info("____________________________");	 
		    	log.info("|                           |");	 
		 		log.info("|1.View Products            |");
				log.info("|2.View Orders              |");
				log.info("|3.Exit                     |");
				log.info("|___________________________|");
				log.info("Enter Ur Choice");
				try {
					ch = Integer.parseInt(sc.nextLine());
				} catch (NumberFormatException e) {
					log.warn(e);
				}
				
			 switch(ch) {
				case 1:log.info(" Displaying details of all products");
				       List<Products> product=new ArrayList();
				       ProductsDAO pd=new ProductsDAOImpl();
				       product=pd.getAllProducts();
				       for(Products i:product) {
				    	   log.info(i);
				       }
				       int z=0;
				       do {
				    	   log.info("____________________________");	 
					    	log.info("|                           |");	 
					 		log.info("|1.Add products to Cart     |");
							log.info("|2.view cart                |");
							log.info("|3.Place order              |");
							log.info("|4.Exit                     |");
							log.info("|___________________________|");
							log.info("Enter Ur Choice");
							try {
								z = Integer.parseInt(sc.nextLine());
							} catch (NumberFormatException e) {
								log.warn(e);
							}
							switch(z) {
							case 1:log.info("Adding products to cart:");
							       log.info("Enter id of product to be added in cart:");
							       int id=Integer.parseInt(sc.nextLine());
							       Products product2=new Products();
							       ProductsDAO pd1=new ProductsDAOImpl();
							       product2=pd1.getProductById(id);
							       log.info("Enter qunatity:");
							       int quantity=Integer.parseInt(sc.nextLine());
							       
							       CartDAO cd=new CartDAOImpl();
							      int g= cd.addToCart(cid, product2.getPid(), quantity);
							      if(g==1) {
							    	  log.info("product "+product2.getPname()+" is added is cart !!");
							      }
							      else
							      {
							    	  log.warn("Failed to add product,some internal error occured");
							      }
							    	   
								
								break;
							case 2:log.info("Items in the cart:");
							       CartDAO dd=new CartDAOImpl();
							        List<Temp> products=dd.getAllItemsInCart(cid);
							       for(Temp i:products) {
							    	   log.info(i);
							       }
							break;
							case 3:log.info("placing ur order");
							CartDAO ca=new CartDAOImpl();
					        List<Temp> products3=ca.getAllItemsInCart(cid);
							       PlaceOrderDAO placeorder=new PlaceOrderImpl();
							       double n=placeorder.placingOrder(products3);
							       
							
							
							       
								break;
							case 4:
								break;
							default:
								log.warn(
										"Invalid Search Option... Choice should be only number between 1-4only. Kindly Retry ");
								break;
							}
				    	   
				       }while(z!=4);
				       
					break;
				case 2:
					break;
				case 3:

					break;
				
				default:
					log.warn(
							"Invalid Search Option... Choice should be only number between 1-4only. Kindly Retry ");
					break;
				}

		    		 
		    	 }while(ch!=3);
		    	   
		       }
		       else
		       {
		    	   log.info("Entered password was wrong!Re-enter");
		       }
		       
		       
		       
			

			break;
		case 3:LoginValidation lv=new LoginValidationImpl();
			 log.info("Welocme new user,signup :");
		       Customer customer=new Customer();
		       log.info("enter customer id:");
		       customer.setCid(Integer.parseInt(sc.nextLine()));
		       log.info("enter customer Name:");
		       customer.setCname(sc.nextLine());
                log.info("enter EMail id:");
                customer.setEmailid(sc.nextLine());
		       log.info("enter correct password:");
		       customer.setPassword(sc.nextLine());
		       log.info("enter contact number:");
		       customer.setContact(Long.parseLong(sc.nextLine()));
		       log.info("enter customer address:");
		       customer.setAddress(sc.nextLine());
		       CustomerDAO customerdao=new CustomerDAOImpl();
		      int k= lv.isValidLogin(customer);
		      if(k==1) {
		       int c=customerdao.createPlayer(customer);
		       if(c==1) {
		    	   log.info("Signup successfull");
		    	   log.info("Re-Login to use the app");
		       }
		       else
		       {
		    	   log.info("singn up failed,Kindly retry");
		       }}
		      else
		      {
		    	  log.info("Invaled credentials Re-login again");
		      }
		       
		       
		       
		       
		       
		       

			break;
		case 4:

			break;
		
		default:
			log.warn(
					"Invalid Search Option... Choice should be only number between 1-4only. Kindly Retry ");
			break;

		}
		

	}while(ch!=4);

}
}


