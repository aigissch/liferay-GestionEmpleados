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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * The utility for the telefono local service. This utility wraps {@link com.telefonica.service.impl.TelefonoLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author anadlca
 * @see TelefonoLocalService
 * @see com.telefonica.service.base.TelefonoLocalServiceBaseImpl
 * @see com.telefonica.service.impl.TelefonoLocalServiceImpl
 * @generated
 */
public class TelefonoLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.telefonica.service.impl.TelefonoLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the telefono to the database. Also notifies the appropriate model listeners.
	*
	* @param telefono the telefono
	* @return the telefono that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.telefonica.model.Telefono addTelefono(
		com.telefonica.model.Telefono telefono)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addTelefono(telefono);
	}

	/**
	* Creates a new telefono with the primary key. Does not add the telefono to the database.
	*
	* @param idTelefono the primary key for the new telefono
	* @return the new telefono
	*/
	public static com.telefonica.model.Telefono createTelefono(int idTelefono) {
		return getService().createTelefono(idTelefono);
	}

	/**
	* Deletes the telefono with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param idTelefono the primary key of the telefono
	* @return the telefono that was removed
	* @throws PortalException if a telefono with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.telefonica.model.Telefono deleteTelefono(int idTelefono)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteTelefono(idTelefono);
	}

	/**
	* Deletes the telefono from the database. Also notifies the appropriate model listeners.
	*
	* @param telefono the telefono
	* @return the telefono that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.telefonica.model.Telefono deleteTelefono(
		com.telefonica.model.Telefono telefono)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteTelefono(telefono);
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

	public static com.telefonica.model.Telefono fetchTelefono(int idTelefono)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchTelefono(idTelefono);
	}

	/**
	* Returns the telefono with the primary key.
	*
	* @param idTelefono the primary key of the telefono
	* @return the telefono
	* @throws PortalException if a telefono with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.telefonica.model.Telefono getTelefono(int idTelefono)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getTelefono(idTelefono);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the telefonos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of telefonos
	* @param end the upper bound of the range of telefonos (not inclusive)
	* @return the range of telefonos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.telefonica.model.Telefono> getTelefonos(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getTelefonos(start, end);
	}

	/**
	* Returns the number of telefonos.
	*
	* @return the number of telefonos
	* @throws SystemException if a system exception occurred
	*/
	public static int getTelefonosCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getTelefonosCount();
	}

	/**
	* Updates the telefono in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param telefono the telefono
	* @return the telefono that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.telefonica.model.Telefono updateTelefono(
		com.telefonica.model.Telefono telefono)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateTelefono(telefono);
	}

	/**
	* Updates the telefono in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param telefono the telefono
	* @param merge whether to merge the telefono with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the telefono that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.telefonica.model.Telefono updateTelefono(
		com.telefonica.model.Telefono telefono, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateTelefono(telefono, merge);
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

	public static com.telefonica.model.Telefono addTelefono(long groupId,
		java.lang.String numero,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().addTelefono(groupId, numero, serviceContext);
	}

	public static java.util.List<com.telefonica.model.Telefono> getTelefonosByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getTelefonosByGroupId(groupId);
	}

	public static java.util.List<com.telefonica.model.Telefono> getLocationsByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getLocationsByGroupId(groupId, start, end);
	}

	public static int getTelefonosCountByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getTelefonosCountByGroupId(groupId);
	}

	public static com.telefonica.model.Telefono updateTelefono(int idTelefono,
		java.lang.String numero,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().updateTelefono(idTelefono, numero, serviceContext);
	}

	public static void clearService() {
		_service = null;
	}

	public static TelefonoLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					TelefonoLocalService.class.getName());

			if (invokableLocalService instanceof TelefonoLocalService) {
				_service = (TelefonoLocalService)invokableLocalService;
			}
			else {
				_service = new TelefonoLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(TelefonoLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated
	 */
	public void setService(TelefonoLocalService service) {
	}

	private static TelefonoLocalService _service;
}