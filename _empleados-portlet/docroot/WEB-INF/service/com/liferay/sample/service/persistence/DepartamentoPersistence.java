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

package com.liferay.sample.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import com.liferay.sample.model.Departamento;

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
	public void cacheResult(com.liferay.sample.model.Departamento departamento);

	/**
	* Caches the departamentos in the entity cache if it is enabled.
	*
	* @param departamentos the departamentos
	*/
	public void cacheResult(
		java.util.List<com.liferay.sample.model.Departamento> departamentos);

	/**
	* Creates a new departamento with the primary key. Does not add the departamento to the database.
	*
	* @param idDepartamento the primary key for the new departamento
	* @return the new departamento
	*/
	public com.liferay.sample.model.Departamento create(int idDepartamento);

	/**
	* Removes the departamento with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param idDepartamento the primary key of the departamento
	* @return the departamento that was removed
	* @throws com.liferay.sample.NoSuchDepartamentoException if a departamento with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.sample.model.Departamento remove(int idDepartamento)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.sample.NoSuchDepartamentoException;

	public com.liferay.sample.model.Departamento updateImpl(
		com.liferay.sample.model.Departamento departamento, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the departamento with the primary key or throws a {@link com.liferay.sample.NoSuchDepartamentoException} if it could not be found.
	*
	* @param idDepartamento the primary key of the departamento
	* @return the departamento
	* @throws com.liferay.sample.NoSuchDepartamentoException if a departamento with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.sample.model.Departamento findByPrimaryKey(
		int idDepartamento)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.sample.NoSuchDepartamentoException;

	/**
	* Returns the departamento with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param idDepartamento the primary key of the departamento
	* @return the departamento, or <code>null</code> if a departamento with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.sample.model.Departamento fetchByPrimaryKey(
		int idDepartamento)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the departamento where groupId = &#63; or throws a {@link com.liferay.sample.NoSuchDepartamentoException} if it could not be found.
	*
	* @param groupId the group ID
	* @return the matching departamento
	* @throws com.liferay.sample.NoSuchDepartamentoException if a matching departamento could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.sample.model.Departamento findBygroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.sample.NoSuchDepartamentoException;

	/**
	* Returns the departamento where groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param groupId the group ID
	* @return the matching departamento, or <code>null</code> if a matching departamento could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.sample.model.Departamento fetchBygroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the departamento where groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching departamento, or <code>null</code> if a matching departamento could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.sample.model.Departamento fetchBygroupId(long groupId,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the departamentos.
	*
	* @return the departamentos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.sample.model.Departamento> findAll()
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
	public java.util.List<com.liferay.sample.model.Departamento> findAll(
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
	public java.util.List<com.liferay.sample.model.Departamento> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the departamento where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @return the departamento that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.sample.model.Departamento removeBygroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.sample.NoSuchDepartamentoException;

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