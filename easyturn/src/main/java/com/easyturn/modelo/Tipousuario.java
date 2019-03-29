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
@Table(name = "tipousuario", schema = "public")
public class Tipousuario implements java.io.Serializable {
    @NotNull
    private Integer idtipousuario;
    private String nombretipousuario;
    private Set<Usuarios> usuarioses = new HashSet<Usuarios>(0);

    public Tipousuario() {
    }

    public Tipousuario(Integer idtipousuario, String nombretipousuario,
        Set<Usuarios> usuarioses) {
        this.idtipousuario = idtipousuario;
        this.nombretipousuario = nombretipousuario;
        this.usuarioses = usuarioses;
    }

    @Id
    @Column(name = "idtipousuario", unique = true, nullable = false)
    public Integer getIdtipousuario() {
        return this.idtipousuario;
    }

    public void setIdtipousuario(Integer idtipousuario) {
        this.idtipousuario = idtipousuario;
    }

    @Column(name = "nombretipousuario")
    public String getNombretipousuario() {
        return this.nombretipousuario;
    }

    public void setNombretipousuario(String nombretipousuario) {
        this.nombretipousuario = nombretipousuario;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tipousuario")
    public Set<Usuarios> getUsuarioses() {
        return this.usuarioses;
    }

    public void setUsuarioses(Set<Usuarios> usuarioses) {
        this.usuarioses = usuarioses;
    }
}
