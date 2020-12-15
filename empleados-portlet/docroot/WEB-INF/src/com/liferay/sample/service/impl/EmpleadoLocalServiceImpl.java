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

package com.liferay.sample.service.impl;

import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.ServiceContext;
import com.liferay.sample.model.Empleado;
import com.liferay.sample.service.EmpleadoLocalServiceUtil;
import com.liferay.sample.service.base.EmpleadoLocalServiceBaseImpl;

/**
 * The implementation of the empleado local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.sample.service.EmpleadoLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author anadlca
 * @see com.liferay.sample.service.base.EmpleadoLocalServiceBaseImpl
 * @see com.liferay.sample.service.EmpleadoLocalServiceUtil
 */
public class EmpleadoLocalServiceImpl extends EmpleadoLocalServiceBaseImpl {

	public Empleado addEmpleado(String nombre, String telefono, int idDepartamento,
			ServiceContext serviceContext)
	    throws PortalException, SystemException {

		int idEmpleado = (int) counterLocalService.increment(Empleado.class.getName());

	    Empleado empleado = empleadoPersistence.create(idEmpleado);

	    empleado.setNombre(nombre);
	    empleado.setTelefono(telefono);
	    empleado.setIdDepartamento(idDepartamento);
 
	    super.addEmpleado(empleado);
	    return empleado;
	}

	public Empleado deleteEmpleado(Empleado empleado) throws SystemException {
	    return empleadoPersistence.remove(empleado);
	}

	public Empleado deleteEmpleado(int idEmpleado)
	    throws PortalException, SystemException {
	    Empleado empleado = empleadoPersistence.findByPrimaryKey(idEmpleado);
	    return deleteEmpleado(empleado);
	}

	public Empleado getEmpleado(int idEmpleado)
	    throws SystemException, PortalException {

	    return empleadoPersistence.findByPrimaryKey(idEmpleado);
	}
	

	public List<Empleado> getEmpleadosByGroupId(long groupId) throws SystemException {

	    //return empleadoPersistence.findByGroupId(groupId);
		return empleadoPersistence.findAll();
	}

	public List<Empleado> getEmpleadosByGroupId(long groupId, int start, int end)
	    throws SystemException {

	    //return empleadoPersistence.findByGroupId(groupId, start, end);
		return empleadoPersistence.findAll();
	}

	public int getEmpleadosCountByGroupId(long groupId) throws SystemException {

	    //return empleadoPersistence.countByGroupId(groupId);
		return empleadoPersistence.countAll();
	}

	public Empleado updateEmpleado(int idEmpleado, String nombre, String telefono, 
			int idDepartamento, ServiceContext serviceContext)
	    throws PortalException, SystemException {

	    Empleado empleado = EmpleadoLocalServiceUtil.fetchEmpleado(idEmpleado);

	    empleado.setNombre(nombre);
	    empleado.setTelefono(telefono);
	    empleado.setIdDepartamento(idDepartamento);

	    super.updateEmpleado(empleado);

	    return empleado;
	}

 
}