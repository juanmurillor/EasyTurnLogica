package com.easyturn.rest.controllers;

import com.easyturn.dto.mapper.ITipousuarioMapper;

import com.easyturn.modelo.*;
import com.easyturn.modelo.dto.TipousuarioDTO;

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
@RequestMapping("/tipousuario")
public class TipousuarioRestController {
    private static final Logger log = LoggerFactory.getLogger(TipousuarioRestController.class);
    @Autowired
    private IBusinessDelegatorView businessDelegatorView;
    @Autowired
    private ITipousuarioMapper tipousuarioMapper;

    @PostMapping(value = "/saveTipousuario")
    public void saveTipousuario(@RequestBody
    TipousuarioDTO tipousuarioDTO) throws Exception {
        try {
            Tipousuario tipousuario = tipousuarioMapper.tipousuarioDTOToTipousuario(tipousuarioDTO);

            businessDelegatorView.saveTipousuario(tipousuario);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @DeleteMapping(value = "/deleteTipousuario/{idtipousuario}")
    public void deleteTipousuario(
        @PathVariable("idtipousuario")
    Integer idtipousuario) throws Exception {
        try {
            Tipousuario tipousuario = businessDelegatorView.getTipousuario(idtipousuario);

            businessDelegatorView.deleteTipousuario(tipousuario);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @PutMapping(value = "/updateTipousuario/")
    public void updateTipousuario(@RequestBody
    TipousuarioDTO tipousuarioDTO) throws Exception {
        try {
            Tipousuario tipousuario = tipousuarioMapper.tipousuarioDTOToTipousuario(tipousuarioDTO);

            businessDelegatorView.updateTipousuario(tipousuario);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getDataTipousuario")
    public List<TipousuarioDTO> getDataTipousuario() throws Exception {
        try {
            return businessDelegatorView.getDataTipousuario();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getTipousuario/{idtipousuario}")
    public TipousuarioDTO getTipousuario(
        @PathVariable("idtipousuario")
    Integer idtipousuario) throws Exception {
        try {
            Tipousuario tipousuario = businessDelegatorView.getTipousuario(idtipousuario);

            return tipousuarioMapper.tipousuarioToTipousuarioDTO(tipousuario);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        return null;
    }
}
