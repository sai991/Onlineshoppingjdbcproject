package project1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.app.dao.CartDAO;
import com.app.dao.impl.CartDAOImpl;
import com.app.exception.BusinessException;

class addToCart {
	CartDAO cart=new CartDAOImpl();
	int cid=8;
	int pid=7;
	int quantity=7;

	@Test
	void test() {
		//fail("Not yet implemented");
		try {
			assertEquals(1,cart.addToCart(cid,pid,quantity));
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
