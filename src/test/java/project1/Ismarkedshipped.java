package project1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.app.dao.EmployeDAO;
import com.app.dao.impl.EmployeDAOImpl;
import com.app.exception.BusinessException;

class Ismarkedshipped {
EmployeDAO ed=new EmployeDAOImpl();

	@Test
	void test() {
		try {
			assertEquals(1,ed.markOrderShipped(4));
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
