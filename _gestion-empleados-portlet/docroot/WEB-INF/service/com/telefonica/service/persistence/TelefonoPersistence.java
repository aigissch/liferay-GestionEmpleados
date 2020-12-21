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

import com.liferay.portal.service.persistence.BasePersistence;

import com.telefonica.model.Telefono;

/**
 * The persistence interface for the telefono service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author anadlca
 * @see TelefonoPersistenceImpl
 * @see TelefonoUtil
 * @generated
 */
public interface TelefonoPersistence extends BasePersistence<Telefono> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TelefonoUtil} to access the telefono persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the telefono in the entity cache if it is enabled.
	*
	* @param telefono the telefono
	*/
	public void cacheResult(com.telefonica.model.Telefono telefono);

	/**
	* Caches the telefonos in the entity cache if it is enabled.
	*
	* @param telefonos the telefonos
	*/
	public void cacheResult(
		java.util.List<com.telefonica.model.Telefono> telefonos);

	/**
	* Creates a new telefono with the primary key. Does not add the telefono to the database.
	*
	* @param idTelefono the primary key for the new telefono
	* @return the new telefono
	*/
	public com.telefonica.model.Telefono create(int idTelefono);

	/**
	* Removes the telefono with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param idTelefono the primary key of the telefono
	* @return the telefono that was removed
	* @throws com.telefonica.NoSuchTelefonoException if a telefono with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.telefonica.model.Telefono remove(int idTelefono)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.telefonica.NoSuchTelefonoException;

	public com.telefonica.model.Telefono updateImpl(
		com.telefonica.model.Telefono telefono, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the telefono with the primary key or throws a {@link com.telefonica.NoSuchTelefonoException} if it could not be found.
	*
	* @param idTelefono the primary key of the telefono
	* @return the telefono
	* @throws com.telefonica.NoSuchTelefonoException if a telefono with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.telefonica.model.Telefono findByPrimaryKey(int idTelefono)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.telefonica.NoSuchTelefonoException;

	/**
	* Returns the telefono with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param idTelefono the primary key of the telefono
	* @return the telefono, or <code>null</code> if a telefono with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.telefonica.model.Telefono fetchByPrimaryKey(int idTelefono)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the telefonos where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching telefonos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.telefonica.model.Telefono> findBygroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.telefonica.model.Telefono> findBygroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.telefonica.model.Telefono> findBygroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first telefono in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching telefono
	* @throws com.telefonica.NoSuchTelefonoException if a matching telefono could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.telefonica.model.Telefono findBygroupId_First(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.telefonica.NoSuchTelefonoException;

	/**
	* Returns the first telefono in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching telefono, or <code>null</code> if a matching telefono could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.telefonica.model.Telefono fetchBygroupId_First(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last telefono in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching telefono
	* @throws com.telefonica.NoSuchTelefonoException if a matching telefono could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.telefonica.model.Telefono findBygroupId_Last(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.telefonica.NoSuchTelefonoException;

	/**
	* Returns the last telefono in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching telefono, or <code>null</code> if a matching telefono could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.telefonica.model.Telefono fetchBygroupId_Last(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.telefonica.model.Telefono[] findBygroupId_PrevAndNext(
		int idTelefono, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.telefonica.NoSuchTelefonoException;

	/**
	* Returns all the telefonos.
	*
	* @return the telefonos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.telefonica.model.Telefono> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.telefonica.model.Telefono> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.telefonica.model.Telefono> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the telefonos where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeBygroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the telefonos from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of telefonos where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching telefonos
	* @throws SystemException if a system exception occurred
	*/
	public int countBygroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of telefonos.
	*
	* @return the number of telefonos
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}