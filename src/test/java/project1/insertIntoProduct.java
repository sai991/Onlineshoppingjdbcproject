package project1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.app.dao.ProductsDAO;
import com.app.dao.impl.ProductsDAOImpl;
import com.app.exception.BusinessException;
import com.app.model.Products;

class insertIntoProduct {

	


	@Test
	void test() {
		//fail("Not yet implemented");
		ProductsDAO product2=new ProductsDAOImpl();
		Products pro=new Products();
		pro.setPid(99);
		pro.setPname("cards");
		pro.setCost(900);

		try {
			assertEquals(1,product2.insertIntoProducts(pro));
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
