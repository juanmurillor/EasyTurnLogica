package com.easyturn.dto.mapper;

import com.easyturn.modelo.Usuarios;
import com.easyturn.modelo.dto.UsuariosDTO;

import java.util.List;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
public interface IUsuariosMapper {
    public UsuariosDTO usuariosToUsuariosDTO(Usuarios usuarios)
        throws Exception;

    public Usuarios usuariosDTOToUsuarios(UsuariosDTO usuariosDTO)
        throws Exception;

    public List<UsuariosDTO> listUsuariosToListUsuariosDTO(
        List<Usuarios> usuarioss) throws Exception;

    public List<Usuarios> listUsuariosDTOToListUsuarios(
        List<UsuariosDTO> usuariosDTOs) throws Exception;
}
