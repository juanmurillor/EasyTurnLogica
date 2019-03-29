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
public class AdministrativosDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(AdministrativosDTO.class);
    private Integer idusuadministrativo;
    private Integer idtipousuadmin_Tipousuadmin;
    private String email_Usuarios;

    public Integer getIdusuadministrativo() {
        return idusuadministrativo;
    }

    public void setIdusuadministrativo(Integer idusuadministrativo) {
        this.idusuadministrativo = idusuadministrativo;
    }

    public Integer getIdtipousuadmin_Tipousuadmin() {
        return idtipousuadmin_Tipousuadmin;
    }

    public void setIdtipousuadmin_Tipousuadmin(
        Integer idtipousuadmin_Tipousuadmin) {
        this.idtipousuadmin_Tipousuadmin = idtipousuadmin_Tipousuadmin;
    }

    public String getEmail_Usuarios() {
        return email_Usuarios;
    }

    public void setEmail_Usuarios(String email_Usuarios) {
        this.email_Usuarios = email_Usuarios;
    }
}
