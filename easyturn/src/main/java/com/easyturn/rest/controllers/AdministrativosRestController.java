package com.easyturn.rest.controllers;

import com.easyturn.dto.mapper.IAdministrativosMapper;

import com.easyturn.modelo.*;
import com.easyturn.modelo.dto.AdministrativosDTO;

import com.easyturn.presentation.businessDelegate.IBusinessDelegatorView;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/administrativos")
public class AdministrativosRestController {
    private static final Logger log = LoggerFactory.getLogger(AdministrativosRestController.class);
    @Autowired
    private IBusinessDelegatorView businessDelegatorView;
    @Autowired
    private IAdministrativosMapper administrativosMapper;

    @PostMapping(value = "/saveAdministrativos")
    public void saveAdministrativos(
        @RequestBody
    AdministrativosDTO administrativosDTO) throws Exception {
        try {
            Administrativos administrativos = administrativosMapper.administrativosDTOToAdministrativos(administrativosDTO);

            businessDelegatorView.saveAdministrativos(administrativos);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @DeleteMapping(value = "/deleteAdministrativos/{idusuadministrativo}")
    public void deleteAdministrativos(
        @PathVariable("idusuadministrativo")
    Integer idusuadministrativo) throws Exception {
        try {
            Administrativos administrativos = businessDelegatorView.getAdministrativos(idusuadministrativo);

            businessDelegatorView.deleteAdministrativos(administrativos);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @PutMapping(value = "/updateAdministrativos/")
    public void updateAdministrativos(
        @RequestBody
    AdministrativosDTO administrativosDTO) throws Exception {
        try {
            Administrativos administrativos = administrativosMapper.administrativosDTOToAdministrativos(administrativosDTO);

            businessDelegatorView.updateAdministrativos(administrativos);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getDataAdministrativos")
    public List<AdministrativosDTO> getDataAdministrativos()
        throws Exception {
        try {
            return businessDelegatorView.getDataAdministrativos();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getAdministrativos/{idusuadministrativo}")
    public AdministrativosDTO getAdministrativos(
        @PathVariable("idusuadministrativo")
    Integer idusuadministrativo) throws Exception {
        try {
            Administrativos administrativos = businessDelegatorView.getAdministrativos(idusuadministrativo);

            return administrativosMapper.administrativosToAdministrativosDTO(administrativos);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        return null;
    }
}
