package com.easyturn.dto.mapper;
import com.easyturn.modelo.Usuarios;
import com.easyturn.modelo.dto.UsuariosDTO;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import 	com.easyturn.modelo.control.*;
import com.easyturn.modelo.*;

/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
* 
*/
@Component
@Scope("singleton")
public class UsuariosMapper implements IUsuariosMapper {
	
	private static final Logger log = LoggerFactory.getLogger(UsuariosMapper.class);

    		            /**
		 	* Logic injected by Spring that manages Tipousuario entities
		 	* 
		 	*/
			@Autowired
			ITipousuarioLogic logicTipousuario1;
		    	
	@Transactional(readOnly = true)
	public UsuariosDTO usuariosToUsuariosDTO(Usuarios usuarios)throws Exception{
		try{
			
			UsuariosDTO usuariosDTO = new UsuariosDTO();
			
			                usuariosDTO.setEmail(usuarios.getEmail());
            			                usuariosDTO.setApellido(usuarios.getApellido()!=null ?usuarios.getApellido() : null);
                            usuariosDTO.setContraseña(usuarios.getContraseña()!=null ?usuarios.getContraseña() : null);
                            usuariosDTO.setNombre(usuarios.getNombre()!=null ?usuarios.getNombre() : null);
                            usuariosDTO.setTelefono(usuarios.getTelefono()!=null ?usuarios.getTelefono() : null);
                            usuariosDTO.setIdtipousuario_Tipousuario(usuarios.getTipousuario().getIdtipousuario()!=null ? usuarios.getTipousuario().getIdtipousuario() : null);
            					
			return usuariosDTO ;
					
		}catch(Exception e){
			throw e;	
		}
	}
	
	@Transactional(readOnly = true)
	public Usuarios usuariosDTOToUsuarios(UsuariosDTO usuariosDTO)throws Exception{
		try{
			
			Usuarios usuarios = new Usuarios();
			
			                usuarios.setEmail(usuariosDTO.getEmail());
            			                usuarios.setApellido(usuariosDTO.getApellido()!=null ?usuariosDTO.getApellido() : null);
                            usuarios.setContraseña(usuariosDTO.getContraseña()!=null ?usuariosDTO.getContraseña() : null);
                            usuarios.setNombre(usuariosDTO.getNombre()!=null ?usuariosDTO.getNombre() : null);
                            usuarios.setTelefono(usuariosDTO.getTelefono()!=null ?usuariosDTO.getTelefono() : null);
                            Tipousuario tipousuario = new Tipousuario(); 

if (usuariosDTO.getIdtipousuario_Tipousuario() != null) {tipousuario = logicTipousuario1.getTipousuario(usuariosDTO.getIdtipousuario_Tipousuario()); 
 } 

if (tipousuario!= null) { 
usuarios.setTipousuario(tipousuario); 
	}
            				
			return usuarios;
			
		}catch(Exception e){
			throw e;	
		}
			
	}
	
	@Transactional(readOnly = true)
	public List<UsuariosDTO> listUsuariosToListUsuariosDTO(List<Usuarios> listUsuarios) throws Exception{
		try{
			List<UsuariosDTO> usuariosDTOs = new ArrayList<UsuariosDTO>();
			
			for (Usuarios usuarios : listUsuarios) {
				
				UsuariosDTO usuariosDTO = usuariosToUsuariosDTO(usuarios);
				
				usuariosDTOs.add(usuariosDTO);
			}
			
			return usuariosDTOs;
		}catch(Exception e){
			throw e;	
		}
		
			
	}
	
	@Transactional(readOnly = true)
	public List<Usuarios> listUsuariosDTOToListUsuarios(List<UsuariosDTO> listUsuariosDTO) throws Exception{
		try{
			List<Usuarios> listUsuarios = new ArrayList<Usuarios>();
			
			for (UsuariosDTO usuariosDTO : listUsuariosDTO) {
				
				Usuarios usuarios = usuariosDTOToUsuarios(usuariosDTO);
				
				listUsuarios.add(usuarios);
			}
			
			return listUsuarios;
		}catch(Exception e){
			throw e;	
		}
		
			
	}		
	
}
