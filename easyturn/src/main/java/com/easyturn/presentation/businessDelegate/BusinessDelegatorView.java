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

import com.easyturn.presentation.businessDelegate.IBusinessDelegatorView;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

import java.sql.*;

import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Use a Business Delegate to reduce coupling between presentation-tier clients
 * and business services. The Business Delegate hides the underlying
 * implementation details of the business service, such as lookup and access
 * details of the EJB architecture.
 *
 * The Business Delegate acts as a client-side business abstraction; it provides
 * an abstraction for, and thus hides, the implementation of the business
 * services. Using a Business Delegate reduces the coupling between
 * presentation-tier clients and the system's business services. Depending on
 * the implementation strategy, the Business Delegate may shield clients from
 * possible volatility in the implementation of the business service API.
 * Potentially, this reduces the number of changes that must be made to the
 * presentation-tier client code when the business service API or its underlying
 * implementation changes.
 *
 * However, interface methods in the Business Delegate may still require
 * modification if the underlying business service API changes. Admittedly,
 * though, it is more likely that changes will be made to the business service
 * rather than to the Business Delegate.
 *
 * Often, developers are skeptical when a design goal such as abstracting the
 * business layer causes additional upfront work in return for future gains.
 * However, using this pattern or its strategies results in only a small amount
 * of additional upfront work and provides considerable benefits. The main
 * benefit is hiding the details of the underlying service. For example, the
 * client can become transparent to naming and lookup services. The Business
 * Delegate also handles the exceptions from the business services, such as
 * java.rmi.Remote exceptions, Java Messages Service (JMS) exceptions and so on.
 * The Business Delegate may intercept such service level exceptions and
 * generate application level exceptions instead. Application level exceptions
 * are easier to handle by the clients, and may be user friendly. The Business
 * Delegate may also transparently perform any retry or recovery operations
 * necessary in the event of a service failure without exposing the client to
 * the problem until it is determined that the problem is not resolvable. These
 * gains present a compelling reason to use the pattern.
 *
 * Another benefit is that the delegate may cache results and references to
 * remote business services. Caching can significantly improve performance,
 * because it limits unnecessary and potentially costly round trips over the
 * network.
 *
 * A Business Delegate uses a component called the Lookup Service. The Lookup
 * Service is responsible for hiding the underlying implementation details of
 * the business service lookup code. The Lookup Service may be written as part
 * of the Delegate, but we recommend that it be implemented as a separate
 * component, as outlined in the Service Locator pattern (See "Service Locator"
 * on page 368.)
 *
 * When the Business Delegate is used with a Session Facade, typically there is
 * a one-to-one relationship between the two. This one-to-one relationship
 * exists because logic that might have been encapsulated in a Business Delegate
 * relating to its interaction with multiple business services (creating a
 * one-to-many relationship) will often be factored back into a Session Facade.
 *
 * Finally, it should be noted that this pattern could be used to reduce
 * coupling between other tiers, not simply the presentation and the business
 * tiers.
 *
 * @author Zathura Code Generator http://zathuracode.org/ www.zathuracode.org
 *
 */
@Scope("singleton")
@Service("BusinessDelegatorView")
public class BusinessDelegatorView implements IBusinessDelegatorView {
	private static final Logger log = LoggerFactory.getLogger(BusinessDelegatorView.class);
	@Autowired
	private IUsuariosLogic usuariosLogic;
	@Autowired
	private ITipousuadminLogic tipousuadminLogic;
	@Autowired
	private IProductrestaurantesLogic productrestaurantesLogic;
	@Autowired
	private IRestauranteLogic restauranteLogic;
	@Autowired
	private ITipousuarioLogic tipousuarioLogic;
	@Autowired
	private IAdministrativosLogic administrativosLogic;

	public List<Usuarios> getUsuarios() throws Exception {
		return usuariosLogic.getUsuarios();
	}

	public void saveUsuarios(Usuarios entity) throws Exception {
		usuariosLogic.saveUsuarios(entity);
	}

	public void deleteUsuarios(Usuarios entity) throws Exception {
		usuariosLogic.deleteUsuarios(entity);
	}

	public void updateUsuarios(Usuarios entity) throws Exception {
		usuariosLogic.updateUsuarios(entity);
	}

	public Usuarios getUsuarios(String email) throws Exception {
		Usuarios usuarios = null;

		try {
			usuarios = usuariosLogic.getUsuarios(email);
		} catch (Exception e) {
			throw e;
		}

		return usuarios;
	}

	public List<Usuarios> findByCriteriaInUsuarios(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return usuariosLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	public List<Usuarios> findPageUsuarios(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception {
		return usuariosLogic.findPageUsuarios(sortColumnName, sortAscending, startRow, maxResults);
	}

	public Long findTotalNumberUsuarios() throws Exception {
		return usuariosLogic.findTotalNumberUsuarios();
	}

	public List<UsuariosDTO> getDataUsuarios() throws Exception {
		return usuariosLogic.getDataUsuarios();
	}

	public void validateUsuarios(Usuarios usuarios) throws Exception {
		usuariosLogic.validateUsuarios(usuarios);
	}

	public List<Tipousuadmin> getTipousuadmin() throws Exception {
		return tipousuadminLogic.getTipousuadmin();
	}

	public void saveTipousuadmin(Tipousuadmin entity) throws Exception {
		tipousuadminLogic.saveTipousuadmin(entity);
	}

	public void deleteTipousuadmin(Tipousuadmin entity) throws Exception {
		tipousuadminLogic.deleteTipousuadmin(entity);
	}

	public void updateTipousuadmin(Tipousuadmin entity) throws Exception {
		tipousuadminLogic.updateTipousuadmin(entity);
	}

	public Tipousuadmin getTipousuadmin(Integer idtipousuadmin) throws Exception {
		Tipousuadmin tipousuadmin = null;

		try {
			tipousuadmin = tipousuadminLogic.getTipousuadmin(idtipousuadmin);
		} catch (Exception e) {
			throw e;
		}

		return tipousuadmin;
	}

	public List<Tipousuadmin> findByCriteriaInTipousuadmin(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return tipousuadminLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	public List<Tipousuadmin> findPageTipousuadmin(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		return tipousuadminLogic.findPageTipousuadmin(sortColumnName, sortAscending, startRow, maxResults);
	}

	public Long findTotalNumberTipousuadmin() throws Exception {
		return tipousuadminLogic.findTotalNumberTipousuadmin();
	}

	public List<TipousuadminDTO> getDataTipousuadmin() throws Exception {
		return tipousuadminLogic.getDataTipousuadmin();
	}

	public void validateTipousuadmin(Tipousuadmin tipousuadmin) throws Exception {
		tipousuadminLogic.validateTipousuadmin(tipousuadmin);
	}

	public List<Productrestaurantes> getProductrestaurantes() throws Exception {
		return productrestaurantesLogic.getProductrestaurantes();
	}

	public void saveProductrestaurantes(Productrestaurantes entity) throws Exception {
		productrestaurantesLogic.saveProductrestaurantes(entity);
	}

	public void deleteProductrestaurantes(Productrestaurantes entity) throws Exception {
		productrestaurantesLogic.deleteProductrestaurantes(entity);
	}

	public void updateProductrestaurantes(Productrestaurantes entity) throws Exception {
		productrestaurantesLogic.updateProductrestaurantes(entity);
	}

	public Productrestaurantes getProductrestaurantes(Integer idproductos) throws Exception {
		Productrestaurantes productrestaurantes = null;

		try {
			productrestaurantes = productrestaurantesLogic.getProductrestaurantes(idproductos);
		} catch (Exception e) {
			throw e;
		}

		return productrestaurantes;
	}

	public List<Productrestaurantes> findByCriteriaInProductrestaurantes(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return productrestaurantesLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	public List<Productrestaurantes> findPageProductrestaurantes(String sortColumnName, boolean sortAscending,
			int startRow, int maxResults) throws Exception {
		return productrestaurantesLogic.findPageProductrestaurantes(sortColumnName, sortAscending, startRow,
				maxResults);
	}

	public Long findTotalNumberProductrestaurantes() throws Exception {
		return productrestaurantesLogic.findTotalNumberProductrestaurantes();
	}

	public List<ProductrestaurantesDTO> getDataProductrestaurantes() throws Exception {
		return productrestaurantesLogic.getDataProductrestaurantes();
	}

	public void validateProductrestaurantes(Productrestaurantes productrestaurantes) throws Exception {
		productrestaurantesLogic.validateProductrestaurantes(productrestaurantes);
	}

	public List<Restaurante> getRestaurante() throws Exception {
		return restauranteLogic.getRestaurante();
	}

	public void saveRestaurante(Restaurante entity) throws Exception {
		restauranteLogic.saveRestaurante(entity);
	}

	public void deleteRestaurante(Restaurante entity) throws Exception {
		restauranteLogic.deleteRestaurante(entity);
	}

	public void updateRestaurante(Restaurante entity) throws Exception {
		restauranteLogic.updateRestaurante(entity);
	}

	public Restaurante getRestaurante(Integer idrestaurante) throws Exception {
		Restaurante restaurante = null;

		try {
			restaurante = restauranteLogic.getRestaurante(idrestaurante);
		} catch (Exception e) {
			throw e;
		}

		return restaurante;
	}

	public List<Restaurante> findByCriteriaInRestaurante(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return restauranteLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	public List<Restaurante> findPageRestaurante(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		return restauranteLogic.findPageRestaurante(sortColumnName, sortAscending, startRow, maxResults);
	}

	public Long findTotalNumberRestaurante() throws Exception {
		return restauranteLogic.findTotalNumberRestaurante();
	}

	public List<RestauranteDTO> getDataRestaurante() throws Exception {
		return restauranteLogic.getDataRestaurante();
	}

	public void validateRestaurante(Restaurante restaurante) throws Exception {
		restauranteLogic.validateRestaurante(restaurante);
	}

	public List<Tipousuario> getTipousuario() throws Exception {
		return tipousuarioLogic.getTipousuario();
	}

	public void saveTipousuario(Tipousuario entity) throws Exception {
		tipousuarioLogic.saveTipousuario(entity);
	}

	public void deleteTipousuario(Tipousuario entity) throws Exception {
		tipousuarioLogic.deleteTipousuario(entity);
	}

	public void updateTipousuario(Tipousuario entity) throws Exception {
		tipousuarioLogic.updateTipousuario(entity);
	}

	public Tipousuario getTipousuario(Integer idtipousuario) throws Exception {
		Tipousuario tipousuario = null;

		try {
			tipousuario = tipousuarioLogic.getTipousuario(idtipousuario);
		} catch (Exception e) {
			throw e;
		}

		return tipousuario;
	}

	public List<Tipousuario> findByCriteriaInTipousuario(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return tipousuarioLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	public List<Tipousuario> findPageTipousuario(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		return tipousuarioLogic.findPageTipousuario(sortColumnName, sortAscending, startRow, maxResults);
	}

	public Long findTotalNumberTipousuario() throws Exception {
		return tipousuarioLogic.findTotalNumberTipousuario();
	}

	public List<TipousuarioDTO> getDataTipousuario() throws Exception {
		return tipousuarioLogic.getDataTipousuario();
	}

	public void validateTipousuario(Tipousuario tipousuario) throws Exception {
		tipousuarioLogic.validateTipousuario(tipousuario);
	}

	public List<Administrativos> getAdministrativos() throws Exception {
		return administrativosLogic.getAdministrativos();
	}

	public void saveAdministrativos(Administrativos entity) throws Exception {
		administrativosLogic.saveAdministrativos(entity);
	}

	public void deleteAdministrativos(Administrativos entity) throws Exception {
		administrativosLogic.deleteAdministrativos(entity);
	}

	public void updateAdministrativos(Administrativos entity) throws Exception {
		administrativosLogic.updateAdministrativos(entity);
	}

	public Administrativos getAdministrativos(Integer idusuadministrativo) throws Exception {
		Administrativos administrativos = null;

		try {
			administrativos = administrativosLogic.getAdministrativos(idusuadministrativo);
		} catch (Exception e) {
			throw e;
		}

		return administrativos;
	}

	public List<Administrativos> findByCriteriaInAdministrativos(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return administrativosLogic.findByCriteria(variables, variablesBetween, variablesBetweenDates);
	}

	public List<Administrativos> findPageAdministrativos(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		return administrativosLogic.findPageAdministrativos(sortColumnName, sortAscending, startRow, maxResults);
	}

	public Long findTotalNumberAdministrativos() throws Exception {
		return administrativosLogic.findTotalNumberAdministrativos();
	}

	public List<AdministrativosDTO> getDataAdministrativos() throws Exception {
		return administrativosLogic.getDataAdministrativos();
	}

	public void validateAdministrativos(Administrativos administrativos) throws Exception {
		administrativosLogic.validateAdministrativos(administrativos);
	}

	@Override
	public List<Productrestaurantes> findProductByRestaurant(Integer id) throws Exception {
		if (id == 0L)
			throw new Exception("el id no puede ser nulo");
		return productrestaurantesLogic.findProductByRestaurant(id);
	}

	@Override
	public List<Restaurante> findRestauranteByUsuario(String email) throws Exception {
		if ((email == null) || (email.equals(""))) {
			throw new Exception("El Email no puede ser nulo");
		} else {
			return restauranteLogic.findRestauranteByUsuario(email);
		}
	}

}
