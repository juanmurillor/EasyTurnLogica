package com.easyturn.modelo.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

import java.sql.*;

import java.util.Date;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
public class TipousuadminDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(TipousuadminDTO.class);
    private Integer idtipousuadmin;
    private String nombretipousuadmin;

    public Integer getIdtipousuadmin() {
        return idtipousuadmin;
    }

    public void setIdtipousuadmin(Integer idtipousuadmin) {
        this.idtipousuadmin = idtipousuadmin;
    }

    public String getNombretipousuadmin() {
        return nombretipousuadmin;
    }

    public void setNombretipousuadmin(String nombretipousuadmin) {
        this.nombretipousuadmin = nombretipousuadmin;
    }
}
