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

import com.telefonica.model.Telefono;

import java.util.List;

/**
 * The persistence utility for the telefono service. This utility wraps {@link TelefonoPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author anadlca
 * @see TelefonoPersistence
 * @see TelefonoPersistenceImpl
 * @generated
 */
public class TelefonoUtil {
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
	public static void clearCache(Telefono telefono) {
		getPersistence().clearCache(telefono);
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
	public static List<Telefono> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Telefono> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Telefono> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static Telefono update(Telefono telefono, boolean merge)
		throws SystemException {
		return getPersistence().update(telefono, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static Telefono update(Telefono telefono, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(telefono, merge, serviceContext);
	}

	/**
	* Caches the telefono in the entity cache if it is enabled.
	*
	* @param telefono the telefono
	*/
	public static void cacheResult(com.telefonica.model.Telefono telefono) {
		getPersistence().cacheResult(telefono);
	}

	/**
	* Caches the telefonos in the entity cache if it is enabled.
	*
	* @param telefonos the telefonos
	*/
	public static void cacheResult(
		java.util.List<com.telefonica.model.Telefono> telefonos) {
		getPersistence().cacheResult(telefonos);
	}

	/**
	* Creates a new telefono with the primary key. Does not add the telefono to the database.
	*
	* @param idTelefono the primary key for the new telefono
	* @return the new telefono
	*/
	public static com.telefonica.model.Telefono create(int idTelefono) {
		return getPersistence().create(idTelefono);
	}

	/**
	* Removes the telefono with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param idTelefono the primary key of the telefono
	* @return the telefono that was removed
	* @throws com.telefonica.NoSuchTelefonoException if a telefono with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.telefonica.model.Telefono remove(int idTelefono)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.telefonica.NoSuchTelefonoException {
		return getPersistence().remove(idTelefono);
	}

	public static com.telefonica.model.Telefono updateImpl(
		com.telefonica.model.Telefono telefono, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(telefono, merge);
	}

	/**
	* Returns the telefono with the primary key or throws a {@link com.telefonica.NoSuchTelefonoException} if it could not be found.
	*
	* @param idTelefono the primary key of the telefono
	* @return the telefono
	* @throws com.telefonica.NoSuchTelefonoException if a telefono with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.telefonica.model.Telefono findByPrimaryKey(int idTelefono)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.telefonica.NoSuchTelefonoException {
		return getPersistence().findByPrimaryKey(idTelefono);
	}

	/**
	* Returns the telefono with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param idTelefono the primary key of the telefono
	* @return the telefono, or <code>null</code> if a telefono with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.telefonica.model.Telefono fetchByPrimaryKey(
		int idTelefono)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(idTelefono);
	}

	/**
	* Returns all the telefonos where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching telefonos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.telefonica.model.Telefono> findBygroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBygroupId(groupId);
	}

	/**
	* Returns a range of all the telefonos where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of telefonos
	* @param end the upper bound of the range of telefonos (not inclusive)
	* @return the range of matching telefonos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.telefonica.model.Telefono> findBygroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBygroupId(groupId, start, end);
	}

	/**
	* Returns an ordered range of all the telefonos where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of telefonos
	* @param end the upper bound of the range of telefonos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching telefonos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.telefonica.model.Telefono> findBygroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBygroupId(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the first telefono in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching telefono
	* @throws com.telefonica.NoSuchTelefonoException if a matching telefono could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.telefonica.model.Telefono findBygroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.telefonica.NoSuchTelefonoException {
		return getPersistence().findBygroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the first telefono in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching telefono, or <code>null</code> if a matching telefono could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.telefonica.model.Telefono fetchBygroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchBygroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the last telefono in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching telefono
	* @throws com.telefonica.NoSuchTelefonoException if a matching telefono could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.telefonica.model.Telefono findBygroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.telefonica.NoSuchTelefonoException {
		return getPersistence().findBygroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the last telefono in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching telefono, or <code>null</code> if a matching telefono could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.telefonica.model.Telefono fetchBygroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchBygroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the telefonos before and after the current telefono in the ordered set where groupId = &#63;.
	*
	* @param idTelefono the primary key of the current telefono
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next telefono
	* @throws com.telefonica.NoSuchTelefonoException if a telefono with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.telefonica.model.Telefono[] findBygroupId_PrevAndNext(
		int idTelefono, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.telefonica.NoSuchTelefonoException {
		return getPersistence()
				   .findBygroupId_PrevAndNext(idTelefono, groupId,
			orderByComparator);
	}

	/**
	* Returns all the telefonos.
	*
	* @return the telefonos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.telefonica.model.Telefono> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<com.telefonica.model.Telefono> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the telefonos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of telefonos
	* @param end the upper bound of the range of telefonos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of telefonos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.telefonica.model.Telefono> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the telefonos where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBygroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeBygroupId(groupId);
	}

	/**
	* Removes all the telefonos from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of telefonos where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching telefonos
	* @throws SystemException if a system exception occurred
	*/
	public static int countBygroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBygroupId(groupId);
	}

	/**
	* Returns the number of telefonos.
	*
	* @return the number of telefonos
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static TelefonoPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (TelefonoPersistence)PortletBeanLocatorUtil.locate(com.telefonica.service.ClpSerializer.getServletContextName(),
					TelefonoPersistence.class.getName());

			ReferenceRegistry.registerReference(TelefonoUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(TelefonoPersistence persistence) {
	}

	private static TelefonoPersistence _persistence;
}