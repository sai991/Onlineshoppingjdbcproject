package project1;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import com.app.dao.CustomerDAO;
import com.app.dao.impl.CustomerDAOImpl;
import com.app.exception.BusinessException;
import com.app.model.Customer;

public class isValidUser {

	CustomerDAO cdao=new CustomerDAOImpl();
     Customer cd=new Customer();
   
@Test
void test() {
	try {
		cd=cdao.isValidUser("a@gmail.com");
	} catch (BusinessException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
 assertNotNull(cd);
}

}
