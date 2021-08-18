package com.app.dao;

import com.app.exception.BusinessException;

public interface EmployeDAO {
	public int markOrderShipped(int oid)throws BusinessException;

}
