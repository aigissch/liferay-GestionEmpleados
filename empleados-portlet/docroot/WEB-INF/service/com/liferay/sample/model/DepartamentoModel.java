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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the Departamento service. Represents a row in the &quot;ge_Departamento&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.liferay.sample.model.impl.DepartamentoModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.liferay.sample.model.impl.DepartamentoImpl}.
 * </p>
 *
 * @author anadlca
 * @see Departamento
 * @see com.liferay.sample.model.impl.DepartamentoImpl
 * @see com.liferay.sample.model.impl.DepartamentoModelImpl
 * @generated
 */
public interface DepartamentoModel extends BaseModel<Departamento> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a departamento model instance should use the {@link Departamento} interface instead.
	 */

	/**
	 * Returns the primary key of this departamento.
	 *
	 * @return the primary key of this departamento
	 */
	public int getPrimaryKey();

	/**
	 * Sets the primary key of this departamento.
	 *
	 * @param primaryKey the primary key of this departamento
	 */
	public void setPrimaryKey(int primaryKey);

	/**
	 * Returns the id departamento of this departamento.
	 *
	 * @return the id departamento of this departamento
	 */
	public int getIdDepartamento();

	/**
	 * Sets the id departamento of this departamento.
	 *
	 * @param idDepartamento the id departamento of this departamento
	 */
	public void setIdDepartamento(int idDepartamento);

	/**
	 * Returns the nombre of this departamento.
	 *
	 * @return the nombre of this departamento
	 */
	@AutoEscape
	public String getNombre();

	/**
	 * Sets the nombre of this departamento.
	 *
	 * @param nombre the nombre of this departamento
	 */
	public void setNombre(String nombre);

	/**
	 * Returns the descripcion of this departamento.
	 *
	 * @return the descripcion of this departamento
	 */
	@AutoEscape
	public String getDescripcion();

	/**
	 * Sets the descripcion of this departamento.
	 *
	 * @param descripcion the descripcion of this departamento
	 */
	public void setDescripcion(String descripcion);

	/**
	 * Returns the company ID of this departamento.
	 *
	 * @return the company ID of this departamento
	 */
	public long getCompanyId();

	/**
	 * Sets the company ID of this departamento.
	 *
	 * @param companyId the company ID of this departamento
	 */
	public void setCompanyId(long companyId);

	/**
	 * Returns the group ID of this departamento.
	 *
	 * @return the group ID of this departamento
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this departamento.
	 *
	 * @param groupId the group ID of this departamento
	 */
	public void setGroupId(long groupId);

	public boolean isNew();

	public void setNew(boolean n);

	public boolean isCachedModel();

	public void setCachedModel(boolean cachedModel);

	public boolean isEscapedModel();

	public Serializable getPrimaryKeyObj();

	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	public ExpandoBridge getExpandoBridge();

	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	public Object clone();

	public int compareTo(Departamento departamento);

	public int hashCode();

	public CacheModel<Departamento> toCacheModel();

	public Departamento toEscapedModel();

	public String toString();

	public String toXmlString();
}