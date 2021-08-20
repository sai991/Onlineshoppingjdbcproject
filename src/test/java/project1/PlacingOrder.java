package project1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.app.dao.PlaceOrderDAO;
import com.app.dao.impl.PlaceOrderImpl;
import com.app.exception.BusinessException;
import com.app.model.PlaceOrder;

class PlacingOrder {

	@Test
	void test() {
	PlaceOrderDAO pd=new PlaceOrderImpl();
	try {
		assertNotNull(pd.getOrdersById(103));
	} catch (BusinessException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}

}
