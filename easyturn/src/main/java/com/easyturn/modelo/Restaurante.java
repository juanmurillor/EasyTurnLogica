package com.easyturn.modelo;

import org.hibernate.validator.constraints.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import javax.validation.constraints.*;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
@Entity
@Table(name = "restaurante", schema = "public")
public class Restaurante implements java.io.Serializable {
    @NotNull
    private Integer idrestaurante;
    @NotNull
    private Usuarios usuarios;
    private String descripcionrestaurante;
    private String imagenrestaurante;
    private String nombrerestaurante;
    private Integer telefonorestaurante;
    private Set<Productrestaurantes> productrestauranteses = new HashSet<Productrestaurantes>(0);

    public Restaurante() {
    }

    public Restaurante(Integer idrestaurante, String descripcionrestaurante,
        String imagenrestaurante, String nombrerestaurante,
        Set<Productrestaurantes> productrestauranteses,
        Integer telefonorestaurante, Usuarios usuarios) {
        this.idrestaurante = idrestaurante;
        this.usuarios = usuarios;
        this.descripcionrestaurante = descripcionrestaurante;
        this.imagenrestaurante = imagenrestaurante;
        this.nombrerestaurante = nombrerestaurante;
        this.telefonorestaurante = telefonorestaurante;
        this.productrestauranteses = productrestauranteses;
    }

    @Id
    @Column(name = "idrestaurante", unique = true, nullable = false)
    public Integer getIdrestaurante() {
        return this.idrestaurante;
    }

    public void setIdrestaurante(Integer idrestaurante) {
        this.idrestaurante = idrestaurante;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FKUsuarios")
    public Usuarios getUsuarios() {
        return this.usuarios;
    }

    public void setUsuarios(Usuarios usuarios) {
        this.usuarios = usuarios;
    }

    @Column(name = "descripcionrestaurante")
    public String getDescripcionrestaurante() {
        return this.descripcionrestaurante;
    }

    public void setDescripcionrestaurante(String descripcionrestaurante) {
        this.descripcionrestaurante = descripcionrestaurante;
    }

    @Column(name = "imagenrestaurante")
    public String getImagenrestaurante() {
        return this.imagenrestaurante;
    }

    public void setImagenrestaurante(String imagenrestaurante) {
        this.imagenrestaurante = imagenrestaurante;
    }

    @Column(name = "nombrerestaurante")
    public String getNombrerestaurante() {
        return this.nombrerestaurante;
    }

    public void setNombrerestaurante(String nombrerestaurante) {
        this.nombrerestaurante = nombrerestaurante;
    }

    @Column(name = "telefonorestaurante")
    public Integer getTelefonorestaurante() {
        return this.telefonorestaurante;
    }

    public void setTelefonorestaurante(Integer telefonorestaurante) {
        this.telefonorestaurante = telefonorestaurante;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "restaurante")
    public Set<Productrestaurantes> getProductrestauranteses() {
        return this.productrestauranteses;
    }

    public void setProductrestauranteses(
        Set<Productrestaurantes> productrestauranteses) {
        this.productrestauranteses = productrestauranteses;
    }
}
