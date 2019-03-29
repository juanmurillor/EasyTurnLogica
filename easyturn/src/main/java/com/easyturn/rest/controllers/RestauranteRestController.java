package com.easyturn.rest.controllers;

import com.easyturn.dto.mapper.IRestauranteMapper;

import com.easyturn.modelo.*;
import com.easyturn.modelo.dto.RestauranteDTO;

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
@RequestMapping("/restaurante")
public class RestauranteRestController {
    private static final Logger log = LoggerFactory.getLogger(RestauranteRestController.class);
    @Autowired
    private IBusinessDelegatorView businessDelegatorView;
    @Autowired
    private IRestauranteMapper restauranteMapper;

    @PostMapping(value = "/saveRestaurante")
    public void saveRestaurante(@RequestBody
    RestauranteDTO restauranteDTO) throws Exception {
        try {
            Restaurante restaurante = restauranteMapper.restauranteDTOToRestaurante(restauranteDTO);

            businessDelegatorView.saveRestaurante(restaurante);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @DeleteMapping(value = "/deleteRestaurante/{idrestaurante}")
    public void deleteRestaurante(
        @PathVariable("idrestaurante")
    Integer idrestaurante) throws Exception {
        try {
            Restaurante restaurante = businessDelegatorView.getRestaurante(idrestaurante);

            businessDelegatorView.deleteRestaurante(restaurante);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @PutMapping(value = "/updateRestaurante/")
    public void updateRestaurante(@RequestBody
    RestauranteDTO restauranteDTO) throws Exception {
        try {
            Restaurante restaurante = restauranteMapper.restauranteDTOToRestaurante(restauranteDTO);

            businessDelegatorView.updateRestaurante(restaurante);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getDataRestaurante")
    public List<RestauranteDTO> getDataRestaurante() throws Exception {
        try {
            return businessDelegatorView.getDataRestaurante();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getRestaurante/{idrestaurante}")
    public RestauranteDTO getRestaurante(
        @PathVariable("idrestaurante")
    Integer idrestaurante) throws Exception {
        try {
            Restaurante restaurante = businessDelegatorView.getRestaurante(idrestaurante);

            return restauranteMapper.restauranteToRestauranteDTO(restaurante);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        return null;
    }
}
