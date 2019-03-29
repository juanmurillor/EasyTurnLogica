package com.easyturn.modelo.control;

import com.easyturn.modelo.Administrativos;
import com.easyturn.modelo.dto.AdministrativosDTO;

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
public interface IAdministrativosLogic {
    public List<Administrativos> getAdministrativos() throws Exception;

    /**
         * Save an new Administrativos entity
         */
    public void saveAdministrativos(Administrativos entity)
        throws Exception;

    /**
         * Delete an existing Administrativos entity
         *
         */
    public void deleteAdministrativos(Administrativos entity)
        throws Exception;

    /**
        * Update an existing Administrativos entity
        *
        */
    public void updateAdministrativos(Administrativos entity)
        throws Exception;

    /**
         * Load an existing Administrativos entity
         *
         */
    public Administrativos getAdministrativos(Integer idusuadministrativo)
        throws Exception;

    public List<Administrativos> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Administrativos> findPageAdministrativos(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberAdministrativos() throws Exception;

    public List<AdministrativosDTO> getDataAdministrativos()
        throws Exception;

    public void validateAdministrativos(Administrativos administrativos)
        throws Exception;
}
