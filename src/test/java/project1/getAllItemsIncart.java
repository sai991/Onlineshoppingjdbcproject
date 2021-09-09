package project1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.app.dao.CartDAO;
import com.app.dao.impl.CartDAOImpl;
import com.app.exception.BusinessException;

class getAllItemsIncart {
	CartDAO cart=new CartDAOImpl();
	
	int cid=7;
	@Test
	void test() {
		//fail("Not yet implemented");
		try {
			assertNotNull(cart. getAllItemsInCart(cid));
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
