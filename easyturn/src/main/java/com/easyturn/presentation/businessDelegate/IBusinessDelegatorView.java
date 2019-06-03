package com.easyturn.presentation.businessDelegate;

import com.easyturn.modelo.Administrativos;
import com.easyturn.modelo.Productrestaurantes;
import com.easyturn.modelo.Restaurante;
import com.easyturn.modelo.Tipousuadmin;
import com.easyturn.modelo.Tipousuario;
import com.easyturn.modelo.Usuarios;
import com.easyturn.modelo.control.AdministrativosLogic;
import com.easyturn.modelo.control.IAdministrativosLogic;
import com.easyturn.modelo.control.IProductrestaurantesLogic;
import com.easyturn.modelo.control.IRestauranteLogic;
import com.easyturn.modelo.control.ITipousuadminLogic;
import com.easyturn.modelo.control.ITipousuarioLogic;
import com.easyturn.modelo.control.IUsuariosLogic;
import com.easyturn.modelo.control.ProductrestaurantesLogic;
import com.easyturn.modelo.control.RestauranteLogic;
import com.easyturn.modelo.control.TipousuadminLogic;
import com.easyturn.modelo.control.TipousuarioLogic;
import com.easyturn.modelo.control.UsuariosLogic;
import com.easyturn.modelo.dto.AdministrativosDTO;
import com.easyturn.modelo.dto.ProductrestaurantesDTO;
import com.easyturn.modelo.dto.RestauranteDTO;
import com.easyturn.modelo.dto.TipousuadminDTO;
import com.easyturn.modelo.dto.TipousuarioDTO;
import com.easyturn.modelo.dto.UsuariosDTO;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

import java.util.Date;
import java.util.List;
import java.util.Set;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
public interface IBusinessDelegatorView {
    public List<Usuarios> getUsuarios() throws Exception;

    public void saveUsuarios(Usuarios entity) throws Exception;

    public void deleteUsuarios(Usuarios entity) throws Exception;

    public void updateUsuarios(Usuarios entity) throws Exception;

    public Usuarios getUsuarios(String email) throws Exception;

    public List<Usuarios> findByCriteriaInUsuarios(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Usuarios> findPageUsuarios(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberUsuarios() throws Exception;

    public List<UsuariosDTO> getDataUsuarios() throws Exception;

    public void validateUsuarios(Usuarios usuarios) throws Exception;

    public List<Tipousuadmin> getTipousuadmin() throws Exception;

    public void saveTipousuadmin(Tipousuadmin entity) throws Exception;

    public void deleteTipousuadmin(Tipousuadmin entity)
        throws Exception;

    public void updateTipousuadmin(Tipousuadmin entity)
        throws Exception;

    public Tipousuadmin getTipousuadmin(Integer idtipousuadmin)
        throws Exception;

    public List<Tipousuadmin> findByCriteriaInTipousuadmin(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Tipousuadmin> findPageTipousuadmin(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberTipousuadmin() throws Exception;

    public List<TipousuadminDTO> getDataTipousuadmin()
        throws Exception;

    public void validateTipousuadmin(Tipousuadmin tipousuadmin)
        throws Exception;

    public List<Productrestaurantes> getProductrestaurantes()
        throws Exception;

    public void saveProductrestaurantes(Productrestaurantes entity)
        throws Exception;

    public void deleteProductrestaurantes(Productrestaurantes entity)
        throws Exception;

    public void updateProductrestaurantes(Productrestaurantes entity)
        throws Exception;

    public Productrestaurantes getProductrestaurantes(Integer idproductos)
        throws Exception;

    public List<Productrestaurantes> findByCriteriaInProductrestaurantes(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception;

    public List<Productrestaurantes> findPageProductrestaurantes(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberProductrestaurantes() throws Exception;

    public List<ProductrestaurantesDTO> getDataProductrestaurantes()
        throws Exception;

    public void validateProductrestaurantes(
        Productrestaurantes productrestaurantes) throws Exception;

    public List<Restaurante> getRestaurante() throws Exception;

    public void saveRestaurante(Restaurante entity) throws Exception;

    public void deleteRestaurante(Restaurante entity) throws Exception;

    public void updateRestaurante(Restaurante entity) throws Exception;

    public Restaurante getRestaurante(Integer idrestaurante)
        throws Exception;

    public List<Restaurante> findByCriteriaInRestaurante(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Restaurante> findPageRestaurante(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberRestaurante() throws Exception;

    public List<RestauranteDTO> getDataRestaurante() throws Exception;

    public void validateRestaurante(Restaurante restaurante)
        throws Exception;

    public List<Tipousuario> getTipousuario() throws Exception;

    public void saveTipousuario(Tipousuario entity) throws Exception;

    public void deleteTipousuario(Tipousuario entity) throws Exception;

    public void updateTipousuario(Tipousuario entity) throws Exception;

    public Tipousuario getTipousuario(Integer idtipousuario)
        throws Exception;

    public List<Tipousuario> findByCriteriaInTipousuario(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Tipousuario> findPageTipousuario(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberTipousuario() throws Exception;

    public List<TipousuarioDTO> getDataTipousuario() throws Exception;

    public void validateTipousuario(Tipousuario tipousuario)
        throws Exception;

    public List<Administrativos> getAdministrativos() throws Exception;

    public void saveAdministrativos(Administrativos entity)
        throws Exception;

    public void deleteAdministrativos(Administrativos entity)
        throws Exception;

    public void updateAdministrativos(Administrativos entity)
        throws Exception;

    public Administrativos getAdministrativos(Integer idusuadministrativo)
        throws Exception;

    public List<Administrativos> findByCriteriaInAdministrativos(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception;

    public List<Administrativos> findPageAdministrativos(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberAdministrativos() throws Exception;

    public List<AdministrativosDTO> getDataAdministrativos()
        throws Exception;

    public void validateAdministrativos(Administrativos administrativos)
        throws Exception;
    
    public List<Productrestaurantes> findProductByRestaurant(Integer id)throws Exception;
    
    public List<Restaurante> findRestauranteByUsuario(String email)throws Exception;
}
