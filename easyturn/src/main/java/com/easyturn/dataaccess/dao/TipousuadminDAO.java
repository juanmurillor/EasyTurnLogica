package com.easyturn.dataaccess.dao;

import com.easyturn.dataaccess.api.JpaDaoImpl;

import com.easyturn.modelo.Tipousuadmin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


/**
 * A data access object (DAO) providing persistence and search support for
 * Tipousuadmin entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 *
 * @see lidis.Tipousuadmin
 */
@Scope("singleton")
@Repository("TipousuadminDAO")
public class TipousuadminDAO extends JpaDaoImpl<Tipousuadmin, Integer>
    implements ITipousuadminDAO {
    private static final Logger log = LoggerFactory.getLogger(TipousuadminDAO.class);
    @PersistenceContext
    private EntityManager entityManager;

    public static ITipousuadminDAO getFromApplicationContext(
        ApplicationContext ctx) {
        return (ITipousuadminDAO) ctx.getBean("TipousuadminDAO");
    }
}
