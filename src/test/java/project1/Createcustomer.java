package project1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.app.dao.CustomerDAO;
import com.app.dao.impl.CustomerDAOImpl;
import com.app.exception.BusinessException;
import com.app.model.Customer;
import project1.*;
class Createcustomer {
CustomerDAO cd=new CustomerDAOImpl();
Customer customer2=new Customer(875,"vyshu","vyshu@gmail.com","vyshu",99999998,"dno:98,hyderabad");

@Test
	void test() throws BusinessException {
			assertEquals(1,cd.createCustomer(customer2));
	}



 void test_whenInsertingRepeatedValue() {
	

	try
	{assertEquals(0,cd.createCustomer(customer2));}
	catch(Exception e) {
		fail("Duplicate entry");
	}


}
}