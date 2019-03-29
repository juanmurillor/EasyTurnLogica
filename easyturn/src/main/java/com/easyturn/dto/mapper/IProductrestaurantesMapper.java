package com.easyturn.dto.mapper;

import com.easyturn.modelo.Productrestaurantes;
import com.easyturn.modelo.dto.ProductrestaurantesDTO;

import java.util.List;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
public interface IProductrestaurantesMapper {
    public ProductrestaurantesDTO productrestaurantesToProductrestaurantesDTO(
        Productrestaurantes productrestaurantes) throws Exception;

    public Productrestaurantes productrestaurantesDTOToProductrestaurantes(
        ProductrestaurantesDTO productrestaurantesDTO)
        throws Exception;

    public List<ProductrestaurantesDTO> listProductrestaurantesToListProductrestaurantesDTO(
        List<Productrestaurantes> productrestaurantess)
        throws Exception;

    public List<Productrestaurantes> listProductrestaurantesDTOToListProductrestaurantes(
        List<ProductrestaurantesDTO> productrestaurantesDTOs)
        throws Exception;
}
