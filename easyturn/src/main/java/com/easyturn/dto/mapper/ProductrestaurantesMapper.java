package com.easyturn.dto.mapper;

import com.easyturn.modelo.*;
import com.easyturn.modelo.Productrestaurantes;
import com.easyturn.modelo.control.*;
import com.easyturn.modelo.dto.ProductrestaurantesDTO;

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
public class ProductrestaurantesMapper implements IProductrestaurantesMapper {
    private static final Logger log = LoggerFactory.getLogger(ProductrestaurantesMapper.class);

    /**
    * Logic injected by Spring that manages Restaurante entities
    *
    */
    @Autowired
    IRestauranteLogic logicRestaurante1;

    @Transactional(readOnly = true)
    public ProductrestaurantesDTO productrestaurantesToProductrestaurantesDTO(
        Productrestaurantes productrestaurantes) throws Exception {
        try {
            ProductrestaurantesDTO productrestaurantesDTO = new ProductrestaurantesDTO();

            productrestaurantesDTO.setIdproductos(productrestaurantes.getIdproductos());
            productrestaurantesDTO.setCantidadproducto((productrestaurantes.getCantidadproducto() != null)
                ? productrestaurantes.getCantidadproducto() : null);
            productrestaurantesDTO.setDescripcionproducto((productrestaurantes.getDescripcionproducto() != null)
                ? productrestaurantes.getDescripcionproducto() : null);
            productrestaurantesDTO.setImagenproducto((productrestaurantes.getImagenproducto() != null)
                ? productrestaurantes.getImagenproducto() : null);
            productrestaurantesDTO.setNombreproducto((productrestaurantes.getNombreproducto() != null)
                ? productrestaurantes.getNombreproducto() : null);
            productrestaurantesDTO.setPrecioproducto((productrestaurantes.getPrecioproducto() != null)
                ? productrestaurantes.getPrecioproducto() : null);
            productrestaurantesDTO.setIdrestaurante_Restaurante((productrestaurantes.getRestaurante()
                                                                                    .getIdrestaurante() != null)
                ? productrestaurantes.getRestaurante().getIdrestaurante() : null);

            return productrestaurantesDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public Productrestaurantes productrestaurantesDTOToProductrestaurantes(
        ProductrestaurantesDTO productrestaurantesDTO)
        throws Exception {
        try {
            Productrestaurantes productrestaurantes = new Productrestaurantes();

            productrestaurantes.setIdproductos(productrestaurantesDTO.getIdproductos());
            productrestaurantes.setCantidadproducto((productrestaurantesDTO.getCantidadproducto() != null)
                ? productrestaurantesDTO.getCantidadproducto() : null);
            productrestaurantes.setDescripcionproducto((productrestaurantesDTO.getDescripcionproducto() != null)
                ? productrestaurantesDTO.getDescripcionproducto() : null);
            productrestaurantes.setImagenproducto((productrestaurantesDTO.getImagenproducto() != null)
                ? productrestaurantesDTO.getImagenproducto() : null);
            productrestaurantes.setNombreproducto((productrestaurantesDTO.getNombreproducto() != null)
                ? productrestaurantesDTO.getNombreproducto() : null);
            productrestaurantes.setPrecioproducto((productrestaurantesDTO.getPrecioproducto() != null)
                ? productrestaurantesDTO.getPrecioproducto() : null);

            Restaurante restaurante = new Restaurante();

            if (productrestaurantesDTO.getIdrestaurante_Restaurante() != null) {
                restaurante = logicRestaurante1.getRestaurante(productrestaurantesDTO.getIdrestaurante_Restaurante());
            }

            if (restaurante != null) {
                productrestaurantes.setRestaurante(restaurante);
            }

            return productrestaurantes;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<ProductrestaurantesDTO> listProductrestaurantesToListProductrestaurantesDTO(
        List<Productrestaurantes> listProductrestaurantes)
        throws Exception {
        try {
            List<ProductrestaurantesDTO> productrestaurantesDTOs = new ArrayList<ProductrestaurantesDTO>();

            for (Productrestaurantes productrestaurantes : listProductrestaurantes) {
                ProductrestaurantesDTO productrestaurantesDTO = productrestaurantesToProductrestaurantesDTO(productrestaurantes);

                productrestaurantesDTOs.add(productrestaurantesDTO);
            }

            return productrestaurantesDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<Productrestaurantes> listProductrestaurantesDTOToListProductrestaurantes(
        List<ProductrestaurantesDTO> listProductrestaurantesDTO)
        throws Exception {
        try {
            List<Productrestaurantes> listProductrestaurantes = new ArrayList<Productrestaurantes>();

            for (ProductrestaurantesDTO productrestaurantesDTO : listProductrestaurantesDTO) {
                Productrestaurantes productrestaurantes = productrestaurantesDTOToProductrestaurantes(productrestaurantesDTO);

                listProductrestaurantes.add(productrestaurantes);
            }

            return listProductrestaurantes;
        } catch (Exception e) {
            throw e;
        }
    }
}
