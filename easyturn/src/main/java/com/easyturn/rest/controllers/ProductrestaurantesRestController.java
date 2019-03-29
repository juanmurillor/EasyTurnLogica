package com.easyturn.rest.controllers;

import com.easyturn.dto.mapper.IProductrestaurantesMapper;

import com.easyturn.modelo.*;
import com.easyturn.modelo.dto.ProductrestaurantesDTO;

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
@RequestMapping("/productrestaurantes")
public class ProductrestaurantesRestController {
    private static final Logger log = LoggerFactory.getLogger(ProductrestaurantesRestController.class);
    @Autowired
    private IBusinessDelegatorView businessDelegatorView;
    @Autowired
    private IProductrestaurantesMapper productrestaurantesMapper;

    @PostMapping(value = "/saveProductrestaurantes")
    public void saveProductrestaurantes(
        @RequestBody
    ProductrestaurantesDTO productrestaurantesDTO) throws Exception {
        try {
            Productrestaurantes productrestaurantes = productrestaurantesMapper.productrestaurantesDTOToProductrestaurantes(productrestaurantesDTO);

            businessDelegatorView.saveProductrestaurantes(productrestaurantes);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @DeleteMapping(value = "/deleteProductrestaurantes/{idproductos}")
    public void deleteProductrestaurantes(
        @PathVariable("idproductos")
    Integer idproductos) throws Exception {
        try {
            Productrestaurantes productrestaurantes = businessDelegatorView.getProductrestaurantes(idproductos);

            businessDelegatorView.deleteProductrestaurantes(productrestaurantes);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @PutMapping(value = "/updateProductrestaurantes/")
    public void updateProductrestaurantes(
        @RequestBody
    ProductrestaurantesDTO productrestaurantesDTO) throws Exception {
        try {
            Productrestaurantes productrestaurantes = productrestaurantesMapper.productrestaurantesDTOToProductrestaurantes(productrestaurantesDTO);

            businessDelegatorView.updateProductrestaurantes(productrestaurantes);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getDataProductrestaurantes")
    public List<ProductrestaurantesDTO> getDataProductrestaurantes()
        throws Exception {
        try {
            return businessDelegatorView.getDataProductrestaurantes();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getProductrestaurantes/{idproductos}")
    public ProductrestaurantesDTO getProductrestaurantes(
        @PathVariable("idproductos")
    Integer idproductos) throws Exception {
        try {
            Productrestaurantes productrestaurantes = businessDelegatorView.getProductrestaurantes(idproductos);

            return productrestaurantesMapper.productrestaurantesToProductrestaurantesDTO(productrestaurantes);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        return null;
    }
}
