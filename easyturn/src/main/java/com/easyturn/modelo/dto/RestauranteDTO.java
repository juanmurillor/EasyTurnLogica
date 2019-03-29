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
public class RestauranteDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(RestauranteDTO.class);
    private String descripcionrestaurante;
    private Integer idrestaurante;
    private String imagenrestaurante;
    private String nombrerestaurante;
    private Integer telefonorestaurante;
    private String email_Usuarios;

    public String getDescripcionrestaurante() {
        return descripcionrestaurante;
    }

    public void setDescripcionrestaurante(String descripcionrestaurante) {
        this.descripcionrestaurante = descripcionrestaurante;
    }

    public Integer getIdrestaurante() {
        return idrestaurante;
    }

    public void setIdrestaurante(Integer idrestaurante) {
        this.idrestaurante = idrestaurante;
    }

    public String getImagenrestaurante() {
        return imagenrestaurante;
    }

    public void setImagenrestaurante(String imagenrestaurante) {
        this.imagenrestaurante = imagenrestaurante;
    }

    public String getNombrerestaurante() {
        return nombrerestaurante;
    }

    public void setNombrerestaurante(String nombrerestaurante) {
        this.nombrerestaurante = nombrerestaurante;
    }

    public Integer getTelefonorestaurante() {
        return telefonorestaurante;
    }

    public void setTelefonorestaurante(Integer telefonorestaurante) {
        this.telefonorestaurante = telefonorestaurante;
    }

    public String getEmail_Usuarios() {
        return email_Usuarios;
    }

    public void setEmail_Usuarios(String email_Usuarios) {
        this.email_Usuarios = email_Usuarios;
    }
}
