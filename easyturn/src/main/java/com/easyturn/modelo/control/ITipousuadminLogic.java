package com.easyturn.modelo.control;

import com.easyturn.modelo.Tipousuadmin;
import com.easyturn.modelo.dto.TipousuadminDTO;

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
public interface ITipousuadminLogic {
    public List<Tipousuadmin> getTipousuadmin() throws Exception;

    /**
         * Save an new Tipousuadmin entity
         */
    public void saveTipousuadmin(Tipousuadmin entity) throws Exception;

    /**
         * Delete an existing Tipousuadmin entity
         *
         */
    public void deleteTipousuadmin(Tipousuadmin entity)
        throws Exception;

    /**
        * Update an existing Tipousuadmin entity
        *
        */
    public void updateTipousuadmin(Tipousuadmin entity)
        throws Exception;

    /**
         * Load an existing Tipousuadmin entity
         *
         */
    public Tipousuadmin getTipousuadmin(Integer idtipousuadmin)
        throws Exception;

    public List<Tipousuadmin> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Tipousuadmin> findPageTipousuadmin(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberTipousuadmin() throws Exception;

    public List<TipousuadminDTO> getDataTipousuadmin()
        throws Exception;

    public void validateTipousuadmin(Tipousuadmin tipousuadmin)
        throws Exception;
}
