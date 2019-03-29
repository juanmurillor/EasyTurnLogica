package com.easyturn.dto.mapper;

import com.easyturn.modelo.Administrativos;
import com.easyturn.modelo.dto.AdministrativosDTO;

import java.util.List;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
public interface IAdministrativosMapper {
    public AdministrativosDTO administrativosToAdministrativosDTO(
        Administrativos administrativos) throws Exception;

    public Administrativos administrativosDTOToAdministrativos(
        AdministrativosDTO administrativosDTO) throws Exception;

    public List<AdministrativosDTO> listAdministrativosToListAdministrativosDTO(
        List<Administrativos> administrativoss) throws Exception;

    public List<Administrativos> listAdministrativosDTOToListAdministrativos(
        List<AdministrativosDTO> administrativosDTOs) throws Exception;
}
