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

import com.liferay.sample.model.Departamento;

import java.io.Serializable;

/**
 * The cache model class for representing Departamento in entity cache.
 *
 * @author anadlca
 * @see Departamento
 * @generated
 */
public class DepartamentoCacheModel implements CacheModel<Departamento>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{idDepartamento=");
		sb.append(idDepartamento);
		sb.append(", nombre=");
		sb.append(nombre);
		sb.append(", descripcion=");
		sb.append(descripcion);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append("}");

		return sb.toString();
	}

	public Departamento toEntityModel() {
		DepartamentoImpl departamentoImpl = new DepartamentoImpl();

		departamentoImpl.setIdDepartamento(idDepartamento);

		if (nombre == null) {
			departamentoImpl.setNombre(StringPool.BLANK);
		}
		else {
			departamentoImpl.setNombre(nombre);
		}

		if (descripcion == null) {
			departamentoImpl.setDescripcion(StringPool.BLANK);
		}
		else {
			departamentoImpl.setDescripcion(descripcion);
		}

		departamentoImpl.setCompanyId(companyId);
		departamentoImpl.setGroupId(groupId);

		departamentoImpl.resetOriginalValues();

		return departamentoImpl;
	}

	public int idDepartamento;
	public String nombre;
	public String descripcion;
	public long companyId;
	public long groupId;
}