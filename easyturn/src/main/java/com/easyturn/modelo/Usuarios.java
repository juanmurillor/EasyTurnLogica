package com.easyturn.modelo;

import java.util.HashSet;
import java.util.Set;

import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.*;
import org.hibernate.validator.constraints.*;

/**
 * @author Zathura Code Generator http://zathuracode.org/ www.zathuracode.org
 * 
 */
@Entity
@Table(name = "usuarios", schema = "public")
public class Usuarios implements java.io.Serializable {

	@NotNull
	private String email;
	@NotNull
	private Tipousuario tipousuario;
	private String apellido;
	private String contraseña;
	private String nombre;
	private Integer telefono;
	private Set<Administrativos> administrativoses = new HashSet<Administrativos>(0);
	private Set<Restaurante> restaurantes = new HashSet<Restaurante>(0);

	public Usuarios() {
	}

	public Usuarios(String email, Set<Administrativos> administrativoses, String apellido, String contraseña,
			String nombre, Set<Restaurante> restaurantes, Integer telefono, Tipousuario tipousuario) {
		this.email = email;
		this.tipousuario = tipousuario;
		this.apellido = apellido;
		this.contraseña = contraseña;
		this.nombre = nombre;
		this.telefono = telefono;
		this.administrativoses = administrativoses;
		this.restaurantes = restaurantes;
	}

	@Id
	@Column(name = "email", unique = true, nullable = false)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FkTipoUsuario")
	public Tipousuario getTipousuario() {
		return this.tipousuario;
	}

	public void setTipousuario(Tipousuario tipousuario) {
		this.tipousuario = tipousuario;
	}

	@Column(name = "apellido")
	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	@Column(name = "contraseña")
	public String getContraseña() {
		return this.contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	@Column(name = "nombre")
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "telefono")
	public Integer getTelefono() {
		return this.telefono;
	}

	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usuarios")
	public Set<Administrativos> getAdministrativoses() {
		return this.administrativoses;
	}

	public void setAdministrativoses(Set<Administrativos> administrativoses) {
		this.administrativoses = administrativoses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usuarios")
	public Set<Restaurante> getRestaurantes() {
		return this.restaurantes;
	}

	public void setRestaurantes(Set<Restaurante> restaurantes) {
		this.restaurantes = restaurantes;
	}

}