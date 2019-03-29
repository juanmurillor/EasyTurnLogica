package com.easyturn.dto.mapper;

import com.easyturn.modelo.*;
import com.easyturn.modelo.Tipousuadmin;
import com.easyturn.modelo.control.*;
import com.easyturn.modelo.dto.TipousuadminDTO;

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
public class TipousuadminMapper implements ITipousuadminMapper {
    private static final Logger log = LoggerFactory.getLogger(TipousuadminMapper.class);

    @Transactional(readOnly = true)
    public TipousuadminDTO tipousuadminToTipousuadminDTO(
        Tipousuadmin tipousuadmin) throws Exception {
        try {
            TipousuadminDTO tipousuadminDTO = new TipousuadminDTO();

            tipousuadminDTO.setIdtipousuadmin(tipousuadmin.getIdtipousuadmin());
            tipousuadminDTO.setNombretipousuadmin((tipousuadmin.getNombretipousuadmin() != null)
                ? tipousuadmin.getNombretipousuadmin() : null);

            return tipousuadminDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public Tipousuadmin tipousuadminDTOToTipousuadmin(
        TipousuadminDTO tipousuadminDTO) throws Exception {
        try {
            Tipousuadmin tipousuadmin = new Tipousuadmin();

            tipousuadmin.setIdtipousuadmin(tipousuadminDTO.getIdtipousuadmin());
            tipousuadmin.setNombretipousuadmin((tipousuadminDTO.getNombretipousuadmin() != null)
                ? tipousuadminDTO.getNombretipousuadmin() : null);

            return tipousuadmin;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<TipousuadminDTO> listTipousuadminToListTipousuadminDTO(
        List<Tipousuadmin> listTipousuadmin) throws Exception {
        try {
            List<TipousuadminDTO> tipousuadminDTOs = new ArrayList<TipousuadminDTO>();

            for (Tipousuadmin tipousuadmin : listTipousuadmin) {
                TipousuadminDTO tipousuadminDTO = tipousuadminToTipousuadminDTO(tipousuadmin);

                tipousuadminDTOs.add(tipousuadminDTO);
            }

            return tipousuadminDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<Tipousuadmin> listTipousuadminDTOToListTipousuadmin(
        List<TipousuadminDTO> listTipousuadminDTO) throws Exception {
        try {
            List<Tipousuadmin> listTipousuadmin = new ArrayList<Tipousuadmin>();

            for (TipousuadminDTO tipousuadminDTO : listTipousuadminDTO) {
                Tipousuadmin tipousuadmin = tipousuadminDTOToTipousuadmin(tipousuadminDTO);

                listTipousuadmin.add(tipousuadmin);
            }

            return listTipousuadmin;
        } catch (Exception e) {
            throw e;
        }
    }
}
