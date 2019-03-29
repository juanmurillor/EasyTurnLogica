package com.easyturn.dto.mapper;

import com.easyturn.modelo.*;
import com.easyturn.modelo.Administrativos;
import com.easyturn.modelo.control.*;
import com.easyturn.modelo.dto.AdministrativosDTO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Component;

import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
@Component
@Scope("singleton")
public class AdministrativosMapper implements IAdministrativosMapper {
    private static final Logger log = LoggerFactory.getLogger(AdministrativosMapper.class);

    /**
    * Logic injected by Spring that manages Tipousuadmin entities
    *
    */
    @Autowired
    ITipousuadminLogic logicTipousuadmin1;

    /**
    * Logic injected by Spring that manages Usuarios entities
    *
    */
    @Autowired
    IUsuariosLogic logicUsuarios2;

    @Transactional(readOnly = true)
    public AdministrativosDTO administrativosToAdministrativosDTO(
        Administrativos administrativos) throws Exception {
        try {
            AdministrativosDTO administrativosDTO = new AdministrativosDTO();

            administrativosDTO.setIdusuadministrativo(administrativos.getIdusuadministrativo());
            administrativosDTO.setIdtipousuadmin_Tipousuadmin((administrativos.getTipousuadmin()
                                                                              .getIdtipousuadmin() != null)
                ? administrativos.getTipousuadmin().getIdtipousuadmin() : null);
            administrativosDTO.setEmail_Usuarios((administrativos.getUsuarios()
                                                                 .getEmail() != null)
                ? administrativos.getUsuarios().getEmail() : null);

            return administrativosDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public Administrativos administrativosDTOToAdministrativos(
        AdministrativosDTO administrativosDTO) throws Exception {
        try {
            Administrativos administrativos = new Administrativos();

            administrativos.setIdusuadministrativo(administrativosDTO.getIdusuadministrativo());

            Tipousuadmin tipousuadmin = new Tipousuadmin();

            if (administrativosDTO.getIdtipousuadmin_Tipousuadmin() != null) {
                tipousuadmin = logicTipousuadmin1.getTipousuadmin(administrativosDTO.getIdtipousuadmin_Tipousuadmin());
            }

            if (tipousuadmin != null) {
                administrativos.setTipousuadmin(tipousuadmin);
            }

            Usuarios usuarios = new Usuarios();

            if (administrativosDTO.getEmail_Usuarios() != null) {
                usuarios = logicUsuarios2.getUsuarios(administrativosDTO.getEmail_Usuarios());
            }

            if (usuarios != null) {
                administrativos.setUsuarios(usuarios);
            }

            return administrativos;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<AdministrativosDTO> listAdministrativosToListAdministrativosDTO(
        List<Administrativos> listAdministrativos) throws Exception {
        try {
            List<AdministrativosDTO> administrativosDTOs = new ArrayList<AdministrativosDTO>();

            for (Administrativos administrativos : listAdministrativos) {
                AdministrativosDTO administrativosDTO = administrativosToAdministrativosDTO(administrativos);

                administrativosDTOs.add(administrativosDTO);
            }

            return administrativosDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<Administrativos> listAdministrativosDTOToListAdministrativos(
        List<AdministrativosDTO> listAdministrativosDTO)
        throws Exception {
        try {
            List<Administrativos> listAdministrativos = new ArrayList<Administrativos>();

            for (AdministrativosDTO administrativosDTO : listAdministrativosDTO) {
                Administrativos administrativos = administrativosDTOToAdministrativos(administrativosDTO);

                listAdministrativos.add(administrativos);
            }

            return listAdministrativos;
        } catch (Exception e) {
            throw e;
        }
    }
}
