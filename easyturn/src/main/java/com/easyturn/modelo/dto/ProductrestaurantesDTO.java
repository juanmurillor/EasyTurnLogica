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
public class ProductrestaurantesDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(ProductrestaurantesDTO.class);
    private Integer cantidadproducto;
    private String descripcionproducto;
    private Integer idproductos;
    private String imagenproducto;
    private String nombreproducto;
    private Integer precioproducto;
    private Integer idrestaurante_Restaurante;

    public Integer getCantidadproducto() {
        return cantidadproducto;
    }

    public void setCantidadproducto(Integer cantidadproducto) {
        this.cantidadproducto = cantidadproducto;
    }

    public String getDescripcionproducto() {
        return descripcionproducto;
    }

    public void setDescripcionproducto(String descripcionproducto) {
        this.descripcionproducto = descripcionproducto;
    }

    public Integer getIdproductos() {
        return idproductos;
    }

    public void setIdproductos(Integer idproductos) {
        this.idproductos = idproductos;
    }

    public String getImagenproducto() {
        return imagenproducto;
    }

    public void setImagenproducto(String imagenproducto) {
        this.imagenproducto = imagenproducto;
    }

    public String getNombreproducto() {
        return nombreproducto;
    }

    public void setNombreproducto(String nombreproducto) {
        this.nombreproducto = nombreproducto;
    }

    public Integer getPrecioproducto() {
        return precioproducto;
    }

    public void setPrecioproducto(Integer precioproducto) {
        this.precioproducto = precioproducto;
    }

    public Integer getIdrestaurante_Restaurante() {
        return idrestaurante_Restaurante;
    }

    public void setIdrestaurante_Restaurante(Integer idrestaurante_Restaurante) {
        this.idrestaurante_Restaurante = idrestaurante_Restaurante;
    }
}
