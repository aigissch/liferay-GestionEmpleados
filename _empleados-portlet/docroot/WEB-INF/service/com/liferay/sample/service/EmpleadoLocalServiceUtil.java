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

package com.liferay.sample.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * The utility for the empleado local service. This utility wraps {@link com.liferay.sample.service.impl.EmpleadoLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author anadlca
 * @see EmpleadoLocalService
 * @see com.liferay.sample.service.base.EmpleadoLocalServiceBaseImpl
 * @see com.liferay.sample.service.impl.EmpleadoLocalServiceImpl
 * @generated
 */
public class EmpleadoLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.sample.service.impl.EmpleadoLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the empleado to the database. Also notifies the appropriate model listeners.
	*
	* @param empleado the empleado
	* @return the empleado that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.sample.model.Empleado addEmpleado(
		com.liferay.sample.model.Empleado empleado)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addEmpleado(empleado);
	}

	/**
	* Creates a new empleado with the primary key. Does not add the empleado to the database.
	*
	* @param idEmpleado the primary key for the new empleado
	* @return the new empleado
	*/
	public static com.liferay.sample.model.Empleado createEmpleado(
		int idEmpleado) {
		return getService().createEmpleado(idEmpleado);
	}

	/**
	* Deletes the empleado with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param idEmpleado the primary key of the empleado
	* @return the empleado that was removed
	* @throws PortalException if a empleado with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.sample.model.Empleado deleteEmpleado(
		int idEmpleado)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteEmpleado(idEmpleado);
	}

	/**
	* Deletes the empleado from the database. Also notifies the appropriate model listeners.
	*
	* @param empleado the empleado
	* @return the empleado that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.sample.model.Empleado deleteEmpleado(
		com.liferay.sample.model.Empleado empleado)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteEmpleado(empleado);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	public static com.liferay.sample.model.Empleado fetchEmpleado(
		int idEmpleado)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchEmpleado(idEmpleado);
	}

	/**
	* Returns the empleado with the primary key.
	*
	* @param idEmpleado the primary key of the empleado
	* @return the empleado
	* @throws PortalException if a empleado with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.sample.model.Empleado getEmpleado(int idEmpleado)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getEmpleado(idEmpleado);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the empleados.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of empleados
	* @param end the upper bound of the range of empleados (not inclusive)
	* @return the range of empleados
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.sample.model.Empleado> getEmpleados(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getEmpleados(start, end);
	}

	/**
	* Returns the number of empleados.
	*
	* @return the number of empleados
	* @throws SystemException if a system exception occurred
	*/
	public static int getEmpleadosCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getEmpleadosCount();
	}

	/**
	* Updates the empleado in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param empleado the empleado
	* @return the empleado that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.sample.model.Empleado updateEmpleado(
		com.liferay.sample.model.Empleado empleado)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateEmpleado(empleado);
	}

	/**
	* Updates the empleado in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param empleado the empleado
	* @param merge whether to merge the empleado with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the empleado that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.sample.model.Empleado updateEmpleado(
		com.liferay.sample.model.Empleado empleado, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateEmpleado(empleado, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static com.liferay.sample.model.Empleado addEmpleado(
		java.lang.String nombre, java.lang.String telefono, int idDepartamento,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addEmpleado(nombre, telefono, idDepartamento, serviceContext);
	}

	public static java.util.List<com.liferay.sample.model.Empleado> getEmpleadosByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getEmpleadosByGroupId(groupId);
	}

	public static java.util.List<com.liferay.sample.model.Empleado> getEmpleadosByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getEmpleadosByGroupId(groupId, start, end);
	}

	public static int getEmpleadosCountByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getEmpleadosCountByGroupId(groupId);
	}

	public static com.liferay.sample.model.Empleado updateEmpleado(
		int idEmpleado, java.lang.String nombre, java.lang.String telefono,
		int idDepartamento,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateEmpleado(idEmpleado, nombre, telefono,
			idDepartamento, serviceContext);
	}

	public static void clearService() {
		_service = null;
	}

	public static EmpleadoLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					EmpleadoLocalService.class.getName());

			if (invokableLocalService instanceof EmpleadoLocalService) {
				_service = (EmpleadoLocalService)invokableLocalService;
			}
			else {
				_service = new EmpleadoLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(EmpleadoLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated
	 */
	public void setService(EmpleadoLocalService service) {
	}

	private static EmpleadoLocalService _service;
}