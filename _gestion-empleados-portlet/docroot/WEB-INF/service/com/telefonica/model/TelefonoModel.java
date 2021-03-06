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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the Telefono service. Represents a row in the &quot;ge_Telefono&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.telefonica.model.impl.TelefonoModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.telefonica.model.impl.TelefonoImpl}.
 * </p>
 *
 * @author anadlca
 * @see Telefono
 * @see com.telefonica.model.impl.TelefonoImpl
 * @see com.telefonica.model.impl.TelefonoModelImpl
 * @generated
 */
public interface TelefonoModel extends BaseModel<Telefono> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a telefono model instance should use the {@link Telefono} interface instead.
	 */

	/**
	 * Returns the primary key of this telefono.
	 *
	 * @return the primary key of this telefono
	 */
	public int getPrimaryKey();

	/**
	 * Sets the primary key of this telefono.
	 *
	 * @param primaryKey the primary key of this telefono
	 */
	public void setPrimaryKey(int primaryKey);

	/**
	 * Returns the id telefono of this telefono.
	 *
	 * @return the id telefono of this telefono
	 */
	public int getIdTelefono();

	/**
	 * Sets the id telefono of this telefono.
	 *
	 * @param idTelefono the id telefono of this telefono
	 */
	public void setIdTelefono(int idTelefono);

	/**
	 * Returns the numero of this telefono.
	 *
	 * @return the numero of this telefono
	 */
	@AutoEscape
	public String getNumero();

	/**
	 * Sets the numero of this telefono.
	 *
	 * @param numero the numero of this telefono
	 */
	public void setNumero(String numero);

	/**
	 * Returns the id empleado of this telefono.
	 *
	 * @return the id empleado of this telefono
	 */
	public int getIdEmpleado();

	/**
	 * Sets the id empleado of this telefono.
	 *
	 * @param idEmpleado the id empleado of this telefono
	 */
	public void setIdEmpleado(int idEmpleado);

	/**
	 * Returns the company ID of this telefono.
	 *
	 * @return the company ID of this telefono
	 */
	public long getCompanyId();

	/**
	 * Sets the company ID of this telefono.
	 *
	 * @param companyId the company ID of this telefono
	 */
	public void setCompanyId(long companyId);

	/**
	 * Returns the group ID of this telefono.
	 *
	 * @return the group ID of this telefono
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this telefono.
	 *
	 * @param groupId the group ID of this telefono
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

	public int compareTo(Telefono telefono);

	public int hashCode();

	public CacheModel<Telefono> toCacheModel();

	public Telefono toEscapedModel();

	public String toString();

	public String toXmlString();
}