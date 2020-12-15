/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.sample.model;

import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Departamento}.
 * </p>
 *
 * @author    anadlca
 * @see       Departamento
 * @generated
 */
public class DepartamentoWrapper implements Departamento,
	ModelWrapper<Departamento> {
	public DepartamentoWrapper(Departamento departamento) {
		_departamento = departamento;
	}

	public Class<?> getModelClass() {
		return Departamento.class;
	}

	public String getModelClassName() {
		return Departamento.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("idDepartamento", getIdDepartamento());
		attributes.put("nombre", getNombre());
		attributes.put("descripcion", getDescripcion());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		Integer idDepartamento = (Integer)attributes.get("idDepartamento");

		if (idDepartamento != null) {
			setIdDepartamento(idDepartamento);
		}

		String nombre = (String)attributes.get("nombre");

		if (nombre != null) {
			setNombre(nombre);
		}

		String descripcion = (String)attributes.get("descripcion");

		if (descripcion != null) {
			setDescripcion(descripcion);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}
	}

	/**
	* Returns the primary key of this departamento.
	*
	* @return the primary key of this departamento
	*/
	public int getPrimaryKey() {
		return _departamento.getPrimaryKey();
	}

	/**
	* Sets the primary key of this departamento.
	*
	* @param primaryKey the primary key of this departamento
	*/
	public void setPrimaryKey(int primaryKey) {
		_departamento.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the id departamento of this departamento.
	*
	* @return the id departamento of this departamento
	*/
	public int getIdDepartamento() {
		return _departamento.getIdDepartamento();
	}

	/**
	* Sets the id departamento of this departamento.
	*
	* @param idDepartamento the id departamento of this departamento
	*/
	public void setIdDepartamento(int idDepartamento) {
		_departamento.setIdDepartamento(idDepartamento);
	}

	/**
	* Returns the nombre of this departamento.
	*
	* @return the nombre of this departamento
	*/
	public java.lang.String getNombre() {
		return _departamento.getNombre();
	}

	/**
	* Sets the nombre of this departamento.
	*
	* @param nombre the nombre of this departamento
	*/
	public void setNombre(java.lang.String nombre) {
		_departamento.setNombre(nombre);
	}

	/**
	* Returns the descripcion of this departamento.
	*
	* @return the descripcion of this departamento
	*/
	public java.lang.String getDescripcion() {
		return _departamento.getDescripcion();
	}

	/**
	* Sets the descripcion of this departamento.
	*
	* @param descripcion the descripcion of this departamento
	*/
	public void setDescripcion(java.lang.String descripcion) {
		_departamento.setDescripcion(descripcion);
	}

	/**
	* Returns the company ID of this departamento.
	*
	* @return the company ID of this departamento
	*/
	public long getCompanyId() {
		return _departamento.getCompanyId();
	}

	/**
	* Sets the company ID of this departamento.
	*
	* @param companyId the company ID of this departamento
	*/
	public void setCompanyId(long companyId) {
		_departamento.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this departamento.
	*
	* @return the group ID of this departamento
	*/
	public long getGroupId() {
		return _departamento.getGroupId();
	}

	/**
	* Sets the group ID of this departamento.
	*
	* @param groupId the group ID of this departamento
	*/
	public void setGroupId(long groupId) {
		_departamento.setGroupId(groupId);
	}

	public boolean isNew() {
		return _departamento.isNew();
	}

	public void setNew(boolean n) {
		_departamento.setNew(n);
	}

	public boolean isCachedModel() {
		return _departamento.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_departamento.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _departamento.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _departamento.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_departamento.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _departamento.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_departamento.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new DepartamentoWrapper((Departamento)_departamento.clone());
	}

	public int compareTo(com.liferay.sample.model.Departamento departamento) {
		return _departamento.compareTo(departamento);
	}

	@Override
	public int hashCode() {
		return _departamento.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.liferay.sample.model.Departamento> toCacheModel() {
		return _departamento.toCacheModel();
	}

	public com.liferay.sample.model.Departamento toEscapedModel() {
		return new DepartamentoWrapper(_departamento.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _departamento.toString();
	}

	public java.lang.String toXmlString() {
		return _departamento.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_departamento.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public Departamento getWrappedDepartamento() {
		return _departamento;
	}

	public Departamento getWrappedModel() {
		return _departamento;
	}

	public void resetOriginalValues() {
		_departamento.resetOriginalValues();
	}

	private Departamento _departamento;
}