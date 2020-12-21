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

package com.telefonica.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.telefonica.model.Empleado;

import java.util.List;

/**
 * The persistence utility for the empleado service. This utility wraps {@link EmpleadoPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author anadlca
 * @see EmpleadoPersistence
 * @see EmpleadoPersistenceImpl
 * @generated
 */
public class EmpleadoUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(Empleado empleado) {
		getPersistence().clearCache(empleado);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Empleado> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Empleado> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Empleado> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static Empleado update(Empleado empleado, boolean merge)
		throws SystemException {
		return getPersistence().update(empleado, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static Empleado update(Empleado empleado, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(empleado, merge, serviceContext);
	}

	/**
	* Caches the empleado in the entity cache if it is enabled.
	*
	* @param empleado the empleado
	*/
	public static void cacheResult(com.telefonica.model.Empleado empleado) {
		getPersistence().cacheResult(empleado);
	}

	/**
	* Caches the empleados in the entity cache if it is enabled.
	*
	* @param empleados the empleados
	*/
	public static void cacheResult(
		java.util.List<com.telefonica.model.Empleado> empleados) {
		getPersistence().cacheResult(empleados);
	}

	/**
	* Creates a new empleado with the primary key. Does not add the empleado to the database.
	*
	* @param idEmpleado the primary key for the new empleado
	* @return the new empleado
	*/
	public static com.telefonica.model.Empleado create(int idEmpleado) {
		return getPersistence().create(idEmpleado);
	}

	/**
	* Removes the empleado with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param idEmpleado the primary key of the empleado
	* @return the empleado that was removed
	* @throws com.telefonica.NoSuchEmpleadoException if a empleado with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.telefonica.model.Empleado remove(int idEmpleado)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.telefonica.NoSuchEmpleadoException {
		return getPersistence().remove(idEmpleado);
	}

	public static com.telefonica.model.Empleado updateImpl(
		com.telefonica.model.Empleado empleado, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(empleado, merge);
	}

	/**
	* Returns the empleado with the primary key or throws a {@link com.telefonica.NoSuchEmpleadoException} if it could not be found.
	*
	* @param idEmpleado the primary key of the empleado
	* @return the empleado
	* @throws com.telefonica.NoSuchEmpleadoException if a empleado with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.telefonica.model.Empleado findByPrimaryKey(int idEmpleado)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.telefonica.NoSuchEmpleadoException {
		return getPersistence().findByPrimaryKey(idEmpleado);
	}

	/**
	* Returns the empleado with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param idEmpleado the primary key of the empleado
	* @return the empleado, or <code>null</code> if a empleado with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.telefonica.model.Empleado fetchByPrimaryKey(
		int idEmpleado)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(idEmpleado);
	}

	/**
	* Returns all the empleados where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching empleados
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.telefonica.model.Empleado> findBygroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBygroupId(groupId);
	}

	/**
	* Returns a range of all the empleados where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of empleados
	* @param end the upper bound of the range of empleados (not inclusive)
	* @return the range of matching empleados
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.telefonica.model.Empleado> findBygroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBygroupId(groupId, start, end);
	}

	/**
	* Returns an ordered range of all the empleados where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of empleados
	* @param end the upper bound of the range of empleados (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching empleados
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.telefonica.model.Empleado> findBygroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBygroupId(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the first empleado in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching empleado
	* @throws com.telefonica.NoSuchEmpleadoException if a matching empleado could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.telefonica.model.Empleado findBygroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.telefonica.NoSuchEmpleadoException {
		return getPersistence().findBygroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the first empleado in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching empleado, or <code>null</code> if a matching empleado could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.telefonica.model.Empleado fetchBygroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchBygroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the last empleado in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching empleado
	* @throws com.telefonica.NoSuchEmpleadoException if a matching empleado could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.telefonica.model.Empleado findBygroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.telefonica.NoSuchEmpleadoException {
		return getPersistence().findBygroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the last empleado in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching empleado, or <code>null</code> if a matching empleado could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.telefonica.model.Empleado fetchBygroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchBygroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the empleados before and after the current empleado in the ordered set where groupId = &#63;.
	*
	* @param idEmpleado the primary key of the current empleado
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next empleado
	* @throws com.telefonica.NoSuchEmpleadoException if a empleado with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.telefonica.model.Empleado[] findBygroupId_PrevAndNext(
		int idEmpleado, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.telefonica.NoSuchEmpleadoException {
		return getPersistence()
				   .findBygroupId_PrevAndNext(idEmpleado, groupId,
			orderByComparator);
	}

	/**
	* Returns all the empleados.
	*
	* @return the empleados
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.telefonica.model.Empleado> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<com.telefonica.model.Empleado> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the empleados.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of empleados
	* @param end the upper bound of the range of empleados (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of empleados
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.telefonica.model.Empleado> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the empleados where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBygroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeBygroupId(groupId);
	}

	/**
	* Removes all the empleados from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of empleados where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching empleados
	* @throws SystemException if a system exception occurred
	*/
	public static int countBygroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBygroupId(groupId);
	}

	/**
	* Returns the number of empleados.
	*
	* @return the number of empleados
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static EmpleadoPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (EmpleadoPersistence)PortletBeanLocatorUtil.locate(com.telefonica.service.ClpSerializer.getServletContextName(),
					EmpleadoPersistence.class.getName());

			ReferenceRegistry.registerReference(EmpleadoUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(EmpleadoPersistence persistence) {
	}

	private static EmpleadoPersistence _persistence;
}