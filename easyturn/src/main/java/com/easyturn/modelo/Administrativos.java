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
@Table(name = "administrativos", schema = "public")
public class Administrativos implements java.io.Serializable {
    @NotNull
    private Integer idusuadministrativo;
    @NotNull
    private Tipousuadmin tipousuadmin;
    @NotNull
    private Usuarios usuarios;

    public Administrativos() {
    }

    public Administrativos(Integer idusuadministrativo,
        Tipousuadmin tipousuadmin, Usuarios usuarios) {
        this.idusuadministrativo = idusuadministrativo;
        this.tipousuadmin = tipousuadmin;
        this.usuarios = usuarios;
    }

    @Id
    @Column(name = "idusuadministrativo", unique = true, nullable = false)
    public Integer getIdusuadministrativo() {
        return this.idusuadministrativo;
    }

    public void setIdusuadministrativo(Integer idusuadministrativo) {
        this.idusuadministrativo = idusuadministrativo;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FKTipoUsuAdmin")
    public Tipousuadmin getTipousuadmin() {
        return this.tipousuadmin;
    }

    public void setTipousuadmin(Tipousuadmin tipousuadmin) {
        this.tipousuadmin = tipousuadmin;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Usuariosemail")
    public Usuarios getUsuarios() {
        return this.usuarios;
    }

    public void setUsuarios(Usuarios usuarios) {
        this.usuarios = usuarios;
    }
}
