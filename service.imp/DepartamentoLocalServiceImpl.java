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

package com.telefonica.service.impl;

import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.ServiceContext;
import com.telefonica.model.Departamento;
import com.telefonica.service.base.DepartamentoLocalServiceBaseImpl;

/**
 * The implementation of the departamento local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.sample.service.DepartamentoLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author anadlca
 * @see com.liferay.sample.service.base.DepartamentoLocalServiceBaseImpl
 * @see com.liferay.sample.service.DepartamentoLocalServiceUtil
 */
public class DepartamentoLocalServiceImpl extends DepartamentoLocalServiceBaseImpl {

	public Departamento addDepartamento(
			long groupId, String nombre, String descripcion,ServiceContext serviceContext)
					throws PortalException, SystemException {

		int idDepartamento = (int) counterLocalService.increment(Departamento.class.getName());

		Departamento departamento = departamentoPersistence.create(idDepartamento);

		departamento.setNombre(nombre);
		departamento.setDescripcion(descripcion);
		departamento.setGroupId(groupId);

		super.addDepartamento(departamento);

		return departamento;
	}

	public Departamento deleteDepartamento(Departamento departamento)
		throws SystemException {

		return departamentoPersistence.remove(departamento);
	}

	public Departamento deleteDepartamento(int idDepartamento)
		throws PortalException, SystemException {

		Departamento departamento = departamentoPersistence.fetchByPrimaryKey(idDepartamento);
		return deleteDepartamento(departamento);
	}

	public List<Departamento> getDepartamentosByGroupId(long groupId)
		throws SystemException {

		return departamentoPersistence.findAll();
	}

	public List<Departamento> getLocationsByGroupId(
			long groupId, int start, int end)
		throws SystemException {

		return departamentoPersistence.findAll();
	}

	public int getDepartamentosCountByGroupId(long groupId) throws SystemException {

		return departamentoPersistence.countBygroupId(groupId);
	}

	public Departamento updateDepartamento(
			int idDepartamento, String nombre, String descripcion,
			ServiceContext serviceContext)
		throws PortalException, SystemException {

		Departamento departamento = departamentoPersistence.findByPrimaryKey(idDepartamento);
		departamento.setNombre(nombre);
		departamento.setDescripcion(descripcion);
		super.updateDepartamento(departamento);

		return departamento;
	}
}