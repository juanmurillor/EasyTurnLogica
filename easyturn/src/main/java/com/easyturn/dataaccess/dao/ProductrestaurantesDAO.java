package com.easyturn.dataaccess.dao;

import com.easyturn.dataaccess.api.JpaDaoImpl;

import com.easyturn.modelo.Productrestaurantes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


/**
 * A data access object (DAO) providing persistence and search support for
 * Productrestaurantes entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 *
 * @see lidis.Productrestaurantes
 */
@Scope("singleton")
@Repository("ProductrestaurantesDAO")
public class ProductrestaurantesDAO extends JpaDaoImpl<Productrestaurantes, Integer>
    implements IProductrestaurantesDAO {
    private static final Logger log = LoggerFactory.getLogger(ProductrestaurantesDAO.class);
    @PersistenceContext
    private EntityManager entityManager;

    public static IProductrestaurantesDAO getFromApplicationContext(
        ApplicationContext ctx) {
        return (IProductrestaurantesDAO) ctx.getBean("ProductrestaurantesDAO");
    }
    
    @Override
    public Integer getSecuencia() {
		javax.persistence.Query query = entityManager.createNativeQuery("select nextval('productrestaurantes_idproductos_seq')");
		return Integer.parseInt(query.getSingleResult().toString()) ;
	}
    
    @Override
    public List<Productrestaurantes> findProductByRestaurant(Integer id){
		String jpql=
		"select pro FROM Productrestaurantes pro where pro.restaurante.idrestaurante="+id;
		return entityManager.createQuery(jpql).getResultList();
    	
    }
}
