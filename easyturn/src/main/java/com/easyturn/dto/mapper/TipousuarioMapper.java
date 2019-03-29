package com.easyturn.dto.mapper;

import com.easyturn.modelo.*;
import com.easyturn.modelo.Tipousuario;
import com.easyturn.modelo.control.*;
import com.easyturn.modelo.dto.TipousuarioDTO;

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
public class TipousuarioMapper implements ITipousuarioMapper {
    private static final Logger log = LoggerFactory.getLogger(TipousuarioMapper.class);

    @Transactional(readOnly = true)
    public TipousuarioDTO tipousuarioToTipousuarioDTO(Tipousuario tipousuario)
        throws Exception {
        try {
            TipousuarioDTO tipousuarioDTO = new TipousuarioDTO();

            tipousuarioDTO.setIdtipousuario(tipousuario.getIdtipousuario());
            tipousuarioDTO.setNombretipousuario((tipousuario.getNombretipousuario() != null)
                ? tipousuario.getNombretipousuario() : null);

            return tipousuarioDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public Tipousuario tipousuarioDTOToTipousuario(
        TipousuarioDTO tipousuarioDTO) throws Exception {
        try {
            Tipousuario tipousuario = new Tipousuario();

            tipousuario.setIdtipousuario(tipousuarioDTO.getIdtipousuario());
            tipousuario.setNombretipousuario((tipousuarioDTO.getNombretipousuario() != null)
                ? tipousuarioDTO.getNombretipousuario() : null);

            return tipousuario;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<TipousuarioDTO> listTipousuarioToListTipousuarioDTO(
        List<Tipousuario> listTipousuario) throws Exception {
        try {
            List<TipousuarioDTO> tipousuarioDTOs = new ArrayList<TipousuarioDTO>();

            for (Tipousuario tipousuario : listTipousuario) {
                TipousuarioDTO tipousuarioDTO = tipousuarioToTipousuarioDTO(tipousuario);

                tipousuarioDTOs.add(tipousuarioDTO);
            }

            return tipousuarioDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<Tipousuario> listTipousuarioDTOToListTipousuario(
        List<TipousuarioDTO> listTipousuarioDTO) throws Exception {
        try {
            List<Tipousuario> listTipousuario = new ArrayList<Tipousuario>();

            for (TipousuarioDTO tipousuarioDTO : listTipousuarioDTO) {
                Tipousuario tipousuario = tipousuarioDTOToTipousuario(tipousuarioDTO);

                listTipousuario.add(tipousuario);
            }

            return listTipousuario;
        } catch (Exception e) {
            throw e;
        }
    }
}
