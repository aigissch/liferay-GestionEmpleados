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
 * This class is a wrapper for {@link Empleado}.
 * </p>
 *
 * @author    anadlca
 * @see       Empleado
 * @generated
 */
public class EmpleadoWrapper implements Empleado, ModelWrapper<Empleado> {
	public EmpleadoWrapper(Empleado empleado) {
		_empleado = empleado;
	}

	public Class<?> getModelClass() {
		return Empleado.class;
	}

	public String getModelClassName() {
		return Empleado.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("idEmpleado", getIdEmpleado());
		attributes.put("nombre", getNombre());
		attributes.put("telefono", getTelefono());
		attributes.put("idDepartamento", getIdDepartamento());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		Integer idEmpleado = (Integer)attributes.get("idEmpleado");

		if (idEmpleado != null) {
			setIdEmpleado(idEmpleado);
		}

		String nombre = (String)attributes.get("nombre");

		if (nombre != null) {
			setNombre(nombre);
		}

		String telefono = (String)attributes.get("telefono");

		if (telefono != null) {
			setTelefono(telefono);
		}

		Integer idDepartamento = (Integer)attributes.get("idDepartamento");

		if (idDepartamento != null) {
			setIdDepartamento(idDepartamento);
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
	* Returns the primary key of this empleado.
	*
	* @return the primary key of this empleado
	*/
	public int getPrimaryKey() {
		return _empleado.getPrimaryKey();
	}

	/**
	* Sets the primary key of this empleado.
	*
	* @param primaryKey the primary key of this empleado
	*/
	public void setPrimaryKey(int primaryKey) {
		_empleado.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the id empleado of this empleado.
	*
	* @return the id empleado of this empleado
	*/
	public int getIdEmpleado() {
		return _empleado.getIdEmpleado();
	}

	/**
	* Sets the id empleado of this empleado.
	*
	* @param idEmpleado the id empleado of this empleado
	*/
	public void setIdEmpleado(int idEmpleado) {
		_empleado.setIdEmpleado(idEmpleado);
	}

	/**
	* Returns the nombre of this empleado.
	*
	* @return the nombre of this empleado
	*/
	public java.lang.String getNombre() {
		return _empleado.getNombre();
	}

	/**
	* Sets the nombre of this empleado.
	*
	* @param nombre the nombre of this empleado
	*/
	public void setNombre(java.lang.String nombre) {
		_empleado.setNombre(nombre);
	}

	/**
	* Returns the telefono of this empleado.
	*
	* @return the telefono of this empleado
	*/
	public java.lang.String getTelefono() {
		return _empleado.getTelefono();
	}

	/**
	* Sets the telefono of this empleado.
	*
	* @param telefono the telefono of this empleado
	*/
	public void setTelefono(java.lang.String telefono) {
		_empleado.setTelefono(telefono);
	}

	/**
	* Returns the id departamento of this empleado.
	*
	* @return the id departamento of this empleado
	*/
	public int getIdDepartamento() {
		return _empleado.getIdDepartamento();
	}

	/**
	* Sets the id departamento of this empleado.
	*
	* @param idDepartamento the id departamento of this empleado
	*/
	public void setIdDepartamento(int idDepartamento) {
		_empleado.setIdDepartamento(idDepartamento);
	}

	/**
	* Returns the company ID of this empleado.
	*
	* @return the company ID of this empleado
	*/
	public long getCompanyId() {
		return _empleado.getCompanyId();
	}

	/**
	* Sets the company ID of this empleado.
	*
	* @param companyId the company ID of this empleado
	*/
	public void setCompanyId(long companyId) {
		_empleado.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this empleado.
	*
	* @return the group ID of this empleado
	*/
	public long getGroupId() {
		return _empleado.getGroupId();
	}

	/**
	* Sets the group ID of this empleado.
	*
	* @param groupId the group ID of this empleado
	*/
	public void setGroupId(long groupId) {
		_empleado.setGroupId(groupId);
	}

	public boolean isNew() {
		return _empleado.isNew();
	}

	public void setNew(boolean n) {
		_empleado.setNew(n);
	}

	public boolean isCachedModel() {
		return _empleado.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_empleado.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _empleado.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _empleado.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_empleado.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _empleado.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_empleado.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new EmpleadoWrapper((Empleado)_empleado.clone());
	}

	public int compareTo(com.liferay.sample.model.Empleado empleado) {
		return _empleado.compareTo(empleado);
	}

	@Override
	public int hashCode() {
		return _empleado.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.liferay.sample.model.Empleado> toCacheModel() {
		return _empleado.toCacheModel();
	}

	public com.liferay.sample.model.Empleado toEscapedModel() {
		return new EmpleadoWrapper(_empleado.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _empleado.toString();
	}

	public java.lang.String toXmlString() {
		return _empleado.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_empleado.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public Empleado getWrappedEmpleado() {
		return _empleado;
	}

	public Empleado getWrappedModel() {
		return _empleado;
	}

	public void resetOriginalValues() {
		_empleado.resetOriginalValues();
	}

	private Empleado _empleado;
}