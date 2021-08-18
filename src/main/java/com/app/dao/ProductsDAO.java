package com.app.dao;


import java.util.List;
import com.app.model.*;

import com.app.exception.BusinessException;

public interface ProductsDAO {
public List<Products> getAllProducts()throws BusinessException;
public Products getProductById(int id) throws BusinessException;
public int insertIntoProducts(Products product)throws BusinessException;

}
