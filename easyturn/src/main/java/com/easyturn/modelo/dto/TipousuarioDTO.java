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
public class TipousuarioDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(TipousuarioDTO.class);
    private Integer idtipousuario;
    private String nombretipousuario;

    public Integer getIdtipousuario() {
        return idtipousuario;
    }

    public void setIdtipousuario(Integer idtipousuario) {
        this.idtipousuario = idtipousuario;
    }

    public String getNombretipousuario() {
        return nombretipousuario;
    }

    public void setNombretipousuario(String nombretipousuario) {
        this.nombretipousuario = nombretipousuario;
    }
}
