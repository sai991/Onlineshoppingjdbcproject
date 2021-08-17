package com.app.dao;

import java.util.List;

import com.app.exception.BusinessException;
import com.app.model.*;

public interface PlaceOrderDAO {
	public double placingOrder(List<Temp> products)throws BusinessException;

}
