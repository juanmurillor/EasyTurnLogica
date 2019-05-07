package com.easyturn.dataaccess.dao;

import com.easyturn.dataaccess.api.Dao;

import com.easyturn.modelo.Productrestaurantes;

import java.math.BigDecimal;

import java.util.Date;
import java.util.List;
import java.util.Set;


/**
* Interface for   ProductrestaurantesDAO.
*
*/
public interface IProductrestaurantesDAO extends Dao<Productrestaurantes, Integer> {

	public Integer getSecuencia();
}
