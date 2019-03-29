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
@Table(name = "tipousuadmin", schema = "public")
public class Tipousuadmin implements java.io.Serializable {
    @NotNull
    private Integer idtipousuadmin;
    private String nombretipousuadmin;
    private Set<Administrativos> administrativoses = new HashSet<Administrativos>(0);

    public Tipousuadmin() {
    }

    public Tipousuadmin(Integer idtipousuadmin,
        Set<Administrativos> administrativoses, String nombretipousuadmin) {
        this.idtipousuadmin = idtipousuadmin;
        this.nombretipousuadmin = nombretipousuadmin;
        this.administrativoses = administrativoses;
    }

    @Id
    @Column(name = "idtipousuadmin", unique = true, nullable = false)
    public Integer getIdtipousuadmin() {
        return this.idtipousuadmin;
    }

    public void setIdtipousuadmin(Integer idtipousuadmin) {
        this.idtipousuadmin = idtipousuadmin;
    }

    @Column(name = "nombretipousuadmin")
    public String getNombretipousuadmin() {
        return this.nombretipousuadmin;
    }

    public void setNombretipousuadmin(String nombretipousuadmin) {
        this.nombretipousuadmin = nombretipousuadmin;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tipousuadmin")
    public Set<Administrativos> getAdministrativoses() {
        return this.administrativoses;
    }

    public void setAdministrativoses(Set<Administrativos> administrativoses) {
        this.administrativoses = administrativoses;
    }
}
