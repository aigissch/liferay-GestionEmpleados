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

package com.liferay.sample.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.liferay.sample.model.Empleado;

import java.io.Serializable;

/**
 * The cache model class for representing Empleado in entity cache.
 *
 * @author anadlca
 * @see Empleado
 * @generated
 */
public class EmpleadoCacheModel implements CacheModel<Empleado>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{idEmpleado=");
		sb.append(idEmpleado);
		sb.append(", nombre=");
		sb.append(nombre);
		sb.append(", telefono=");
		sb.append(telefono);
		sb.append(", idDepartamento=");
		sb.append(idDepartamento);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append("}");

		return sb.toString();
	}

	public Empleado toEntityModel() {
		EmpleadoImpl empleadoImpl = new EmpleadoImpl();

		empleadoImpl.setIdEmpleado(idEmpleado);

		if (nombre == null) {
			empleadoImpl.setNombre(StringPool.BLANK);
		}
		else {
			empleadoImpl.setNombre(nombre);
		}

		if (telefono == null) {
			empleadoImpl.setTelefono(StringPool.BLANK);
		}
		else {
			empleadoImpl.setTelefono(telefono);
		}

		empleadoImpl.setIdDepartamento(idDepartamento);
		empleadoImpl.setCompanyId(companyId);
		empleadoImpl.setGroupId(groupId);

		empleadoImpl.resetOriginalValues();

		return empleadoImpl;
	}

	public int idEmpleado;
	public String nombre;
	public String telefono;
	public int idDepartamento;
	public long companyId;
	public long groupId;
}