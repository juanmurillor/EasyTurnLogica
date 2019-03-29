package com.easyturn.modelo;

import org.hibernate.validator.constraints.*;

import java.util.Date;

import javax.persistence.*;

import javax.validation.constraints.*;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
@Entity
@Table(name = "productrestaurantes", schema = "public")
public class Productrestaurantes implements java.io.Serializable {
    @NotNull
    private Integer idproductos;
    @NotNull
    private Restaurante restaurante;
    private Integer cantidadproducto;
    private String descripcionproducto;
    private String imagenproducto;
    private String nombreproducto;
    private Integer precioproducto;

    public Productrestaurantes() {
    }

    public Productrestaurantes(Integer idproductos, Integer cantidadproducto,
        String descripcionproducto, String imagenproducto,
        String nombreproducto, Integer precioproducto, Restaurante restaurante) {
        this.idproductos = idproductos;
        this.restaurante = restaurante;
        this.cantidadproducto = cantidadproducto;
        this.descripcionproducto = descripcionproducto;
        this.imagenproducto = imagenproducto;
        this.nombreproducto = nombreproducto;
        this.precioproducto = precioproducto;
    }

    @Id
    @Column(name = "idproductos", unique = true, nullable = false)
    public Integer getIdproductos() {
        return this.idproductos;
    }

    public void setIdproductos(Integer idproductos) {
        this.idproductos = idproductos;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FKRestaurantes")
    public Restaurante getRestaurante() {
        return this.restaurante;
    }

    public void setRestaurante(Restaurante restaurante) {
        this.restaurante = restaurante;
    }

    @Column(name = "cantidadproducto")
    public Integer getCantidadproducto() {
        return this.cantidadproducto;
    }

    public void setCantidadproducto(Integer cantidadproducto) {
        this.cantidadproducto = cantidadproducto;
    }

    @Column(name = "descripcionproducto")
    public String getDescripcionproducto() {
        return this.descripcionproducto;
    }

    public void setDescripcionproducto(String descripcionproducto) {
        this.descripcionproducto = descripcionproducto;
    }

    @Column(name = "imagenproducto")
    public String getImagenproducto() {
        return this.imagenproducto;
    }

    public void setImagenproducto(String imagenproducto) {
        this.imagenproducto = imagenproducto;
    }

    @Column(name = "nombreproducto")
    public String getNombreproducto() {
        return this.nombreproducto;
    }

    public void setNombreproducto(String nombreproducto) {
        this.nombreproducto = nombreproducto;
    }

    @Column(name = "precioproducto")
    public Integer getPrecioproducto() {
        return this.precioproducto;
    }

    public void setPrecioproducto(Integer precioproducto) {
        this.precioproducto = precioproducto;
    }
}
