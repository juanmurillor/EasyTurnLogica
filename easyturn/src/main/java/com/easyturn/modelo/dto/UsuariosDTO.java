package com.easyturn. modelo.dto;
import java.util.Date;
import java.io.Serializable;
import java.sql.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
* 
*/
public class UsuariosDTO implements Serializable {

private static final long serialVersionUID = 1L;

private static final Logger log = LoggerFactory.getLogger(UsuariosDTO.class);

	
		private  String apellido;	
		private  String contraseña;	
		private  String email;	
		private  String nombre;	
		private  Integer telefono;	
		private  Integer idtipousuario_Tipousuario;	
		    
		
		public String getApellido (){
		 return apellido;
		}
		
		public void setApellido (String apellido ){
		this.apellido = apellido;
		}
		
		
		public String getContraseña (){
		 return contraseña;
		}
		
		public void setContraseña (String contraseña ){
		this.contraseña = contraseña;
		}
		
		
		public String getEmail (){
		 return email;
		}
		
		public void setEmail (String email ){
		this.email = email;
		}
		
		
		public String getNombre (){
		 return nombre;
		}
		
		public void setNombre (String nombre ){
		this.nombre = nombre;
		}
		
		
		public Integer getTelefono (){
		 return telefono;
		}
		
		public void setTelefono (Integer telefono ){
		this.telefono = telefono;
		}
		
		
		public Integer getIdtipousuario_Tipousuario (){
		 return idtipousuario_Tipousuario;
		}
		
		public void setIdtipousuario_Tipousuario (Integer idtipousuario_Tipousuario ){
		this.idtipousuario_Tipousuario = idtipousuario_Tipousuario;
		}
		
		
	
    }
