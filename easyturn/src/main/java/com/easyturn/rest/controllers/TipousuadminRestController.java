package com.easyturn.rest.controllers;

import com.easyturn.dto.mapper.ITipousuadminMapper;

import com.easyturn.modelo.*;
import com.easyturn.modelo.dto.TipousuadminDTO;

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
@RequestMapping("/tipousuadmin")
public class TipousuadminRestController {
    private static final Logger log = LoggerFactory.getLogger(TipousuadminRestController.class);
    @Autowired
    private IBusinessDelegatorView businessDelegatorView;
    @Autowired
    private ITipousuadminMapper tipousuadminMapper;

    @PostMapping(value = "/saveTipousuadmin")
    public void saveTipousuadmin(@RequestBody
    TipousuadminDTO tipousuadminDTO) throws Exception {
        try {
            Tipousuadmin tipousuadmin = tipousuadminMapper.tipousuadminDTOToTipousuadmin(tipousuadminDTO);

            businessDelegatorView.saveTipousuadmin(tipousuadmin);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @DeleteMapping(value = "/deleteTipousuadmin/{idtipousuadmin}")
    public void deleteTipousuadmin(
        @PathVariable("idtipousuadmin")
    Integer idtipousuadmin) throws Exception {
        try {
            Tipousuadmin tipousuadmin = businessDelegatorView.getTipousuadmin(idtipousuadmin);

            businessDelegatorView.deleteTipousuadmin(tipousuadmin);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @PutMapping(value = "/updateTipousuadmin/")
    public void updateTipousuadmin(@RequestBody
    TipousuadminDTO tipousuadminDTO) throws Exception {
        try {
            Tipousuadmin tipousuadmin = tipousuadminMapper.tipousuadminDTOToTipousuadmin(tipousuadminDTO);

            businessDelegatorView.updateTipousuadmin(tipousuadmin);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getDataTipousuadmin")
    public List<TipousuadminDTO> getDataTipousuadmin()
        throws Exception {
        try {
            return businessDelegatorView.getDataTipousuadmin();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getTipousuadmin/{idtipousuadmin}")
    public TipousuadminDTO getTipousuadmin(
        @PathVariable("idtipousuadmin")
    Integer idtipousuadmin) throws Exception {
        try {
            Tipousuadmin tipousuadmin = businessDelegatorView.getTipousuadmin(idtipousuadmin);

            return tipousuadminMapper.tipousuadminToTipousuadminDTO(tipousuadmin);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        return null;
    }
}
