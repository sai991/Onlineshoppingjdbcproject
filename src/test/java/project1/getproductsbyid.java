package project1;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.app.dao.EmployeDAO;
import com.app.dao.impl.EmployeDAOImpl;
import com.app.exception.BusinessException;
import com.app.model.Products;

class getproductsbyid {
	EmployeDAO ed=new EmployeDAOImpl();
	@Test
	void test() {
		try {
			List<Products> pd =new ArrayList();
			pd= ed.getProductByName("a");
		
			assertNotNull(pd);
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

}
