package com.easyturn.modelo.control;

import com.easyturn.modelo.Productrestaurantes;
import com.easyturn.modelo.dto.ProductrestaurantesDTO;

import java.math.BigDecimal;

import java.util.*;
import java.util.Date;
import java.util.List;
import java.util.Set;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
public interface IProductrestaurantesLogic {
    public List<Productrestaurantes> getProductrestaurantes()
        throws Exception;

    /**
         * Save an new Productrestaurantes entity
         */
    public void saveProductrestaurantes(Productrestaurantes entity)
        throws Exception;

    /**
         * Delete an existing Productrestaurantes entity
         *
         */
    public void deleteProductrestaurantes(Productrestaurantes entity)
        throws Exception;

    /**
        * Update an existing Productrestaurantes entity
        *
        */
    public void updateProductrestaurantes(Productrestaurantes entity)
        throws Exception;

    /**
         * Load an existing Productrestaurantes entity
         *
         */
    public Productrestaurantes getProductrestaurantes(Integer idproductos)
        throws Exception;

    public List<Productrestaurantes> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Productrestaurantes> findPageProductrestaurantes(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberProductrestaurantes() throws Exception;

    public List<ProductrestaurantesDTO> getDataProductrestaurantes()
        throws Exception;

    public void validateProductrestaurantes(
        Productrestaurantes productrestaurantes) throws Exception;
    
    public List<Productrestaurantes> findProductByRestaurant(Integer id)throws Exception;
}
