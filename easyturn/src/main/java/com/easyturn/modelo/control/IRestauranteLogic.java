package com.easyturn.modelo.control;

import com.easyturn.modelo.Restaurante;
import com.easyturn.modelo.dto.RestauranteDTO;

import java.math.BigDecimal;

import java.util.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * @author Zathura Code Generator http://zathuracode.org/ www.zathuracode.org
 *
 */
public interface IRestauranteLogic {
	public List<Restaurante> getRestaurante() throws Exception;

	/**
	 * Save an new Restaurante entity
	 */
	public void saveRestaurante(Restaurante entity) throws Exception;

	/**
	 * Delete an existing Restaurante entity
	 *
	 */
	public void deleteRestaurante(Restaurante entity) throws Exception;

	/**
	 * Update an existing Restaurante entity
	 *
	 */
	public void updateRestaurante(Restaurante entity) throws Exception;

	/**
	 * Load an existing Restaurante entity
	 *
	 */
	public Restaurante getRestaurante(Integer idrestaurante) throws Exception;

	public List<Restaurante> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<Restaurante> findPageRestaurante(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberRestaurante() throws Exception;

	public List<RestauranteDTO> getDataRestaurante() throws Exception;

	public void validateRestaurante(Restaurante restaurante) throws Exception;

	public List<Restaurante> findRestauranteByUsuario(String email) throws Exception;

}
