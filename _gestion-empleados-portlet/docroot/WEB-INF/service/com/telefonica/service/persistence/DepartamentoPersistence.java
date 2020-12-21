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

import com.telefonica.model.Departamento;

/**
 * The persistence interface for the departamento service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author anadlca
 * @see DepartamentoPersistenceImpl
 * @see DepartamentoUtil
 * @generated
 */
public interface DepartamentoPersistence extends BasePersistence<Departamento> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DepartamentoUtil} to access the departamento persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the departamento in the entity cache if it is enabled.
	*
	* @param departamento the departamento
	*/
	public void cacheResult(com.telefonica.model.Departamento departamento);

	/**
	* Caches the departamentos in the entity cache if it is enabled.
	*
	* @param departamentos the departamentos
	*/
	public void cacheResult(
		java.util.List<com.telefonica.model.Departamento> departamentos);

	/**
	* Creates a new departamento with the primary key. Does not add the departamento to the database.
	*
	* @param idDepartamento the primary key for the new departamento
	* @return the new departamento
	*/
	public com.telefonica.model.Departamento create(int idDepartamento);

	/**
	* Removes the departamento with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param idDepartamento the primary key of the departamento
	* @return the departamento that was removed
	* @throws com.telefonica.NoSuchDepartamentoException if a departamento with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.telefonica.model.Departamento remove(int idDepartamento)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.telefonica.NoSuchDepartamentoException;

	public com.telefonica.model.Departamento updateImpl(
		com.telefonica.model.Departamento departamento, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the departamento with the primary key or throws a {@link com.telefonica.NoSuchDepartamentoException} if it could not be found.
	*
	* @param idDepartamento the primary key of the departamento
	* @return the departamento
	* @throws com.telefonica.NoSuchDepartamentoException if a departamento with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.telefonica.model.Departamento findByPrimaryKey(
		int idDepartamento)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.telefonica.NoSuchDepartamentoException;

	/**
	* Returns the departamento with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param idDepartamento the primary key of the departamento
	* @return the departamento, or <code>null</code> if a departamento with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.telefonica.model.Departamento fetchByPrimaryKey(
		int idDepartamento)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the departamentos where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching departamentos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.telefonica.model.Departamento> findBygroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the departamentos where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of departamentos
	* @param end the upper bound of the range of departamentos (not inclusive)
	* @return the range of matching departamentos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.telefonica.model.Departamento> findBygroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the departamentos where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of departamentos
	* @param end the upper bound of the range of departamentos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching departamentos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.telefonica.model.Departamento> findBygroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first departamento in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching departamento
	* @throws com.telefonica.NoSuchDepartamentoException if a matching departamento could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.telefonica.model.Departamento findBygroupId_First(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.telefonica.NoSuchDepartamentoException;

	/**
	* Returns the first departamento in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching departamento, or <code>null</code> if a matching departamento could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.telefonica.model.Departamento fetchBygroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last departamento in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching departamento
	* @throws com.telefonica.NoSuchDepartamentoException if a matching departamento could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.telefonica.model.Departamento findBygroupId_Last(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.telefonica.NoSuchDepartamentoException;

	/**
	* Returns the last departamento in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching departamento, or <code>null</code> if a matching departamento could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.telefonica.model.Departamento fetchBygroupId_Last(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the departamentos before and after the current departamento in the ordered set where groupId = &#63;.
	*
	* @param idDepartamento the primary key of the current departamento
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next departamento
	* @throws com.telefonica.NoSuchDepartamentoException if a departamento with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.telefonica.model.Departamento[] findBygroupId_PrevAndNext(
		int idDepartamento, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.telefonica.NoSuchDepartamentoException;

	/**
	* Returns all the departamentos.
	*
	* @return the departamentos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.telefonica.model.Departamento> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the departamentos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of departamentos
	* @param end the upper bound of the range of departamentos (not inclusive)
	* @return the range of departamentos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.telefonica.model.Departamento> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the departamentos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of departamentos
	* @param end the upper bound of the range of departamentos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of departamentos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.telefonica.model.Departamento> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the departamentos where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeBygroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the departamentos from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of departamentos where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching departamentos
	* @throws SystemException if a system exception occurred
	*/
	public int countBygroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of departamentos.
	*
	* @return the number of departamentos
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}