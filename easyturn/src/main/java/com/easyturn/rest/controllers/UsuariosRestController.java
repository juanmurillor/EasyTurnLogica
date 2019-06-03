package com.easyturn.rest.controllers;

import com.easyturn.dto.mapper.IUsuariosMapper;

import com.easyturn.modelo.*;
import com.easyturn.modelo.dto.UsuariosDTO;

import com.easyturn.presentation.businessDelegate.IBusinessDelegatorView;

import org.hibernate.validator.constraints.Email;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/usuarios")
public class UsuariosRestController {
    private static final Logger log = LoggerFactory.getLogger(UsuariosRestController.class);
    @Autowired
    private IBusinessDelegatorView businessDelegatorView;
    @Autowired
    private IUsuariosMapper usuariosMapper;

    @PostMapping(value = "/saveUsuarios")
    public void saveUsuarios(@RequestBody
    UsuariosDTO usuariosDTO) throws Exception {
        try {
            Usuarios usuarios = usuariosMapper.usuariosDTOToUsuarios(usuariosDTO);

            businessDelegatorView.saveUsuarios(usuarios);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @DeleteMapping(value = "/deleteUsuarios/{email}")
    public void deleteUsuarios(@PathVariable("email")
    String email) throws Exception {
        try {
            Usuarios usuarios = businessDelegatorView.getUsuarios(email);

            businessDelegatorView.deleteUsuarios(usuarios);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @PutMapping(value = "/updateUsuarios/")
    public void updateUsuarios(@RequestBody
    UsuariosDTO usuariosDTO) throws Exception {
        try {
            Usuarios usuarios = usuariosMapper.usuariosDTOToUsuarios(usuariosDTO);

            businessDelegatorView.updateUsuarios(usuarios);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getDataUsuarios")
    public List<UsuariosDTO> getDataUsuarios() throws Exception {
        try {
            return businessDelegatorView.getDataUsuarios();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getUsuarios")
    public UsuariosDTO getUsuarios(@RequestParam("email")
    String email) throws Exception {
        try {
            Usuarios usuarios = businessDelegatorView.getUsuarios(email);

            return usuariosMapper.usuariosToUsuariosDTO(usuarios);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        return null;
    }
}
