package com.easyturn.dto.mapper;

import com.easyturn.modelo.Restaurante;
import com.easyturn.modelo.dto.RestauranteDTO;

import java.util.List;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
public interface IRestauranteMapper {
    public RestauranteDTO restauranteToRestauranteDTO(Restaurante restaurante)
        throws Exception;

    public Restaurante restauranteDTOToRestaurante(
        RestauranteDTO restauranteDTO) throws Exception;

    public List<RestauranteDTO> listRestauranteToListRestauranteDTO(
        List<Restaurante> restaurantes) throws Exception;

    public List<Restaurante> listRestauranteDTOToListRestaurante(
        List<RestauranteDTO> restauranteDTOs) throws Exception;
}
