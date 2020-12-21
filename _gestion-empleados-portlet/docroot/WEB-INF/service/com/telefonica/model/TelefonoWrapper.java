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

package com.telefonica.model;

import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Telefono}.
 * </p>
 *
 * @author    anadlca
 * @see       Telefono
 * @generated
 */
public class TelefonoWrapper implements Telefono, ModelWrapper<Telefono> {
	public TelefonoWrapper(Telefono telefono) {
		_telefono = telefono;
	}

	public Class<?> getModelClass() {
		return Telefono.class;
	}

	public String getModelClassName() {
		return Telefono.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("idTelefono", getIdTelefono());
		attributes.put("numero", getNumero());
		attributes.put("idEmpleado", getIdEmpleado());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		Integer idTelefono = (Integer)attributes.get("idTelefono");

		if (idTelefono != null) {
			setIdTelefono(idTelefono);
		}

		String numero = (String)attributes.get("numero");

		if (numero != null) {
			setNumero(numero);
		}

		Integer idEmpleado = (Integer)attributes.get("idEmpleado");

		if (idEmpleado != null) {
			setIdEmpleado(idEmpleado);
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
	* Returns the primary key of this telefono.
	*
	* @return the primary key of this telefono
	*/
	public int getPrimaryKey() {
		return _telefono.getPrimaryKey();
	}

	/**
	* Sets the primary key of this telefono.
	*
	* @param primaryKey the primary key of this telefono
	*/
	public void setPrimaryKey(int primaryKey) {
		_telefono.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the id telefono of this telefono.
	*
	* @return the id telefono of this telefono
	*/
	public int getIdTelefono() {
		return _telefono.getIdTelefono();
	}

	/**
	* Sets the id telefono of this telefono.
	*
	* @param idTelefono the id telefono of this telefono
	*/
	public void setIdTelefono(int idTelefono) {
		_telefono.setIdTelefono(idTelefono);
	}

	/**
	* Returns the numero of this telefono.
	*
	* @return the numero of this telefono
	*/
	public java.lang.String getNumero() {
		return _telefono.getNumero();
	}

	/**
	* Sets the numero of this telefono.
	*
	* @param numero the numero of this telefono
	*/
	public void setNumero(java.lang.String numero) {
		_telefono.setNumero(numero);
	}

	/**
	* Returns the id empleado of this telefono.
	*
	* @return the id empleado of this telefono
	*/
	public int getIdEmpleado() {
		return _telefono.getIdEmpleado();
	}

	/**
	* Sets the id empleado of this telefono.
	*
	* @param idEmpleado the id empleado of this telefono
	*/
	public void setIdEmpleado(int idEmpleado) {
		_telefono.setIdEmpleado(idEmpleado);
	}

	/**
	* Returns the company ID of this telefono.
	*
	* @return the company ID of this telefono
	*/
	public long getCompanyId() {
		return _telefono.getCompanyId();
	}

	/**
	* Sets the company ID of this telefono.
	*
	* @param companyId the company ID of this telefono
	*/
	public void setCompanyId(long companyId) {
		_telefono.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this telefono.
	*
	* @return the group ID of this telefono
	*/
	public long getGroupId() {
		return _telefono.getGroupId();
	}

	/**
	* Sets the group ID of this telefono.
	*
	* @param groupId the group ID of this telefono
	*/
	public void setGroupId(long groupId) {
		_telefono.setGroupId(groupId);
	}

	public boolean isNew() {
		return _telefono.isNew();
	}

	public void setNew(boolean n) {
		_telefono.setNew(n);
	}

	public boolean isCachedModel() {
		return _telefono.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_telefono.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _telefono.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _telefono.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_telefono.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _telefono.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_telefono.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new TelefonoWrapper((Telefono)_telefono.clone());
	}

	public int compareTo(com.telefonica.model.Telefono telefono) {
		return _telefono.compareTo(telefono);
	}

	@Override
	public int hashCode() {
		return _telefono.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.telefonica.model.Telefono> toCacheModel() {
		return _telefono.toCacheModel();
	}

	public com.telefonica.model.Telefono toEscapedModel() {
		return new TelefonoWrapper(_telefono.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _telefono.toString();
	}

	public java.lang.String toXmlString() {
		return _telefono.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_telefono.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public Telefono getWrappedTelefono() {
		return _telefono;
	}

	public Telefono getWrappedModel() {
		return _telefono;
	}

	public void resetOriginalValues() {
		_telefono.resetOriginalValues();
	}

	private Telefono _telefono;
}