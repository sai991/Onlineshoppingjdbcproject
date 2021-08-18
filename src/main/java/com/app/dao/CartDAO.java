package com.app.dao;



import java.util.List;

import com.app.exception.BusinessException;
import com.app.model.Cart;
import com.app.model.Products;
import com.app.model.Temp;

public interface CartDAO  {
	public int addToCart(int cid, int pid,int quantity)throws BusinessException;
	public List<Temp> getAllItemsInCart(int id)throws BusinessException; 
	public void deleteCartById(int cid)throws BusinessException; 

}
