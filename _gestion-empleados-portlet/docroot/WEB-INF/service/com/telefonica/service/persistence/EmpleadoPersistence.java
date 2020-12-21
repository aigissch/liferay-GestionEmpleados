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

import com.telefonica.model.Empleado;

/**
 * The persistence interface for the empleado service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author anadlca
 * @see EmpleadoPersistenceImpl
 * @see EmpleadoUtil
 * @generated
 */
public interface EmpleadoPersistence extends BasePersistence<Empleado> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EmpleadoUtil} to access the empleado persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the empleado in the entity cache if it is enabled.
	*
	* @param empleado the empleado
	*/
	public void cacheResult(com.telefonica.model.Empleado empleado);

	/**
	* Caches the empleados in the entity cache if it is enabled.
	*
	* @param empleados the empleados
	*/
	public void cacheResult(
		java.util.List<com.telefonica.model.Empleado> empleados);

	/**
	* Creates a new empleado with the primary key. Does not add the empleado to the database.
	*
	* @param idEmpleado the primary key for the new empleado
	* @return the new empleado
	*/
	public com.telefonica.model.Empleado create(int idEmpleado);

	/**
	* Removes the empleado with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param idEmpleado the primary key of the empleado
	* @return the empleado that was removed
	* @throws com.telefonica.NoSuchEmpleadoException if a empleado with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.telefonica.model.Empleado remove(int idEmpleado)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.telefonica.NoSuchEmpleadoException;

	public com.telefonica.model.Empleado updateImpl(
		com.telefonica.model.Empleado empleado, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the empleado with the primary key or throws a {@link com.telefonica.NoSuchEmpleadoException} if it could not be found.
	*
	* @param idEmpleado the primary key of the empleado
	* @return the empleado
	* @throws com.telefonica.NoSuchEmpleadoException if a empleado with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.telefonica.model.Empleado findByPrimaryKey(int idEmpleado)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.telefonica.NoSuchEmpleadoException;

	/**
	* Returns the empleado with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param idEmpleado the primary key of the empleado
	* @return the empleado, or <code>null</code> if a empleado with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.telefonica.model.Empleado fetchByPrimaryKey(int idEmpleado)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the empleados where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching empleados
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.telefonica.model.Empleado> findBygroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.telefonica.model.Empleado> findBygroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.telefonica.model.Empleado> findBygroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first empleado in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching empleado
	* @throws com.telefonica.NoSuchEmpleadoException if a matching empleado could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.telefonica.model.Empleado findBygroupId_First(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.telefonica.NoSuchEmpleadoException;

	/**
	* Returns the first empleado in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching empleado, or <code>null</code> if a matching empleado could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.telefonica.model.Empleado fetchBygroupId_First(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last empleado in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching empleado
	* @throws com.telefonica.NoSuchEmpleadoException if a matching empleado could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.telefonica.model.Empleado findBygroupId_Last(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.telefonica.NoSuchEmpleadoException;

	/**
	* Returns the last empleado in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching empleado, or <code>null</code> if a matching empleado could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.telefonica.model.Empleado fetchBygroupId_Last(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.telefonica.model.Empleado[] findBygroupId_PrevAndNext(
		int idEmpleado, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.telefonica.NoSuchEmpleadoException;

	/**
	* Returns all the empleados.
	*
	* @return the empleados
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.telefonica.model.Empleado> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.telefonica.model.Empleado> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.telefonica.model.Empleado> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the empleados where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeBygroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the empleados from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of empleados where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching empleados
	* @throws SystemException if a system exception occurred
	*/
	public int countBygroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of empleados.
	*
	* @return the number of empleados
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}