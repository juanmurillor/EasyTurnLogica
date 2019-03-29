package com.easyturn.dto.mapper;

import com.easyturn.modelo.*;
import com.easyturn.modelo.Restaurante;
import com.easyturn.modelo.control.*;
import com.easyturn.modelo.dto.RestauranteDTO;

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
public class RestauranteMapper implements IRestauranteMapper {
    private static final Logger log = LoggerFactory.getLogger(RestauranteMapper.class);

    /**
    * Logic injected by Spring that manages Usuarios entities
    *
    */
    @Autowired
    IUsuariosLogic logicUsuarios1;

    @Transactional(readOnly = true)
    public RestauranteDTO restauranteToRestauranteDTO(Restaurante restaurante)
        throws Exception {
        try {
            RestauranteDTO restauranteDTO = new RestauranteDTO();

            restauranteDTO.setIdrestaurante(restaurante.getIdrestaurante());
            restauranteDTO.setDescripcionrestaurante((restaurante.getDescripcionrestaurante() != null)
                ? restaurante.getDescripcionrestaurante() : null);
            restauranteDTO.setImagenrestaurante((restaurante.getImagenrestaurante() != null)
                ? restaurante.getImagenrestaurante() : null);
            restauranteDTO.setNombrerestaurante((restaurante.getNombrerestaurante() != null)
                ? restaurante.getNombrerestaurante() : null);
            restauranteDTO.setTelefonorestaurante((restaurante.getTelefonorestaurante() != null)
                ? restaurante.getTelefonorestaurante() : null);
            restauranteDTO.setEmail_Usuarios((restaurante.getUsuarios()
                                                         .getEmail() != null)
                ? restaurante.getUsuarios().getEmail() : null);

            return restauranteDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public Restaurante restauranteDTOToRestaurante(
        RestauranteDTO restauranteDTO) throws Exception {
        try {
            Restaurante restaurante = new Restaurante();

            restaurante.setIdrestaurante(restauranteDTO.getIdrestaurante());
            restaurante.setDescripcionrestaurante((restauranteDTO.getDescripcionrestaurante() != null)
                ? restauranteDTO.getDescripcionrestaurante() : null);
            restaurante.setImagenrestaurante((restauranteDTO.getImagenrestaurante() != null)
                ? restauranteDTO.getImagenrestaurante() : null);
            restaurante.setNombrerestaurante((restauranteDTO.getNombrerestaurante() != null)
                ? restauranteDTO.getNombrerestaurante() : null);
            restaurante.setTelefonorestaurante((restauranteDTO.getTelefonorestaurante() != null)
                ? restauranteDTO.getTelefonorestaurante() : null);

            Usuarios usuarios = new Usuarios();

            if (restauranteDTO.getEmail_Usuarios() != null) {
                usuarios = logicUsuarios1.getUsuarios(restauranteDTO.getEmail_Usuarios());
            }

            if (usuarios != null) {
                restaurante.setUsuarios(usuarios);
            }

            return restaurante;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<RestauranteDTO> listRestauranteToListRestauranteDTO(
        List<Restaurante> listRestaurante) throws Exception {
        try {
            List<RestauranteDTO> restauranteDTOs = new ArrayList<RestauranteDTO>();

            for (Restaurante restaurante : listRestaurante) {
                RestauranteDTO restauranteDTO = restauranteToRestauranteDTO(restaurante);

                restauranteDTOs.add(restauranteDTO);
            }

            return restauranteDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<Restaurante> listRestauranteDTOToListRestaurante(
        List<RestauranteDTO> listRestauranteDTO) throws Exception {
        try {
            List<Restaurante> listRestaurante = new ArrayList<Restaurante>();

            for (RestauranteDTO restauranteDTO : listRestauranteDTO) {
                Restaurante restaurante = restauranteDTOToRestaurante(restauranteDTO);

                listRestaurante.add(restaurante);
            }

            return listRestaurante;
        } catch (Exception e) {
            throw e;
        }
    }
}
