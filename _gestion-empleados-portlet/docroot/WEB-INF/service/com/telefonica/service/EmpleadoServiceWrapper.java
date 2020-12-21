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

package com.telefonica.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link EmpleadoService}.
 * </p>
 *
 * @author    anadlca
 * @see       EmpleadoService
 * @generated
 */
public class EmpleadoServiceWrapper implements EmpleadoService,
	ServiceWrapper<EmpleadoService> {
	public EmpleadoServiceWrapper(EmpleadoService empleadoService) {
		_empleadoService = empleadoService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _empleadoService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_empleadoService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _empleadoService.invokeMethod(name, parameterTypes, arguments);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public EmpleadoService getWrappedEmpleadoService() {
		return _empleadoService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedEmpleadoService(EmpleadoService empleadoService) {
		_empleadoService = empleadoService;
	}

	public EmpleadoService getWrappedService() {
		return _empleadoService;
	}

	public void setWrappedService(EmpleadoService empleadoService) {
		_empleadoService = empleadoService;
	}

	private EmpleadoService _empleadoService;
}