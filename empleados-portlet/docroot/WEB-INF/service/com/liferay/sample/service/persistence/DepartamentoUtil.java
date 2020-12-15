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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.liferay.sample.model.Departamento;

import java.util.List;

/**
 * The persistence utility for the departamento service. This utility wraps {@link DepartamentoPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author anadlca
 * @see DepartamentoPersistence
 * @see DepartamentoPersistenceImpl
 * @generated
 */
public class DepartamentoUtil {
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
	public static void clearCache(Departamento departamento) {
		getPersistence().clearCache(departamento);
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
	public static List<Departamento> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Departamento> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Departamento> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static Departamento update(Departamento departamento, boolean merge)
		throws SystemException {
		return getPersistence().update(departamento, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static Departamento update(Departamento departamento, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(departamento, merge, serviceContext);
	}

	/**
	* Caches the departamento in the entity cache if it is enabled.
	*
	* @param departamento the departamento
	*/
	public static void cacheResult(
		com.liferay.sample.model.Departamento departamento) {
		getPersistence().cacheResult(departamento);
	}

	/**
	* Caches the departamentos in the entity cache if it is enabled.
	*
	* @param departamentos the departamentos
	*/
	public static void cacheResult(
		java.util.List<com.liferay.sample.model.Departamento> departamentos) {
		getPersistence().cacheResult(departamentos);
	}

	/**
	* Creates a new departamento with the primary key. Does not add the departamento to the database.
	*
	* @param idDepartamento the primary key for the new departamento
	* @return the new departamento
	*/
	public static com.liferay.sample.model.Departamento create(
		int idDepartamento) {
		return getPersistence().create(idDepartamento);
	}

	/**
	* Removes the departamento with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param idDepartamento the primary key of the departamento
	* @return the departamento that was removed
	* @throws com.liferay.sample.NoSuchDepartamentoException if a departamento with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.sample.model.Departamento remove(
		int idDepartamento)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.sample.NoSuchDepartamentoException {
		return getPersistence().remove(idDepartamento);
	}

	public static com.liferay.sample.model.Departamento updateImpl(
		com.liferay.sample.model.Departamento departamento, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(departamento, merge);
	}

	/**
	* Returns the departamento with the primary key or throws a {@link com.liferay.sample.NoSuchDepartamentoException} if it could not be found.
	*
	* @param idDepartamento the primary key of the departamento
	* @return the departamento
	* @throws com.liferay.sample.NoSuchDepartamentoException if a departamento with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.sample.model.Departamento findByPrimaryKey(
		int idDepartamento)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.sample.NoSuchDepartamentoException {
		return getPersistence().findByPrimaryKey(idDepartamento);
	}

	/**
	* Returns the departamento with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param idDepartamento the primary key of the departamento
	* @return the departamento, or <code>null</code> if a departamento with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.sample.model.Departamento fetchByPrimaryKey(
		int idDepartamento)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(idDepartamento);
	}

	/**
	* Returns the departamento where groupId = &#63; or throws a {@link com.liferay.sample.NoSuchDepartamentoException} if it could not be found.
	*
	* @param groupId the group ID
	* @return the matching departamento
	* @throws com.liferay.sample.NoSuchDepartamentoException if a matching departamento could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.sample.model.Departamento findBygroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.sample.NoSuchDepartamentoException {
		return getPersistence().findBygroupId(groupId);
	}

	/**
	* Returns the departamento where groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param groupId the group ID
	* @return the matching departamento, or <code>null</code> if a matching departamento could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.sample.model.Departamento fetchBygroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchBygroupId(groupId);
	}

	/**
	* Returns the departamento where groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching departamento, or <code>null</code> if a matching departamento could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.sample.model.Departamento fetchBygroupId(
		long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchBygroupId(groupId, retrieveFromCache);
	}

	/**
	* Returns all the departamentos.
	*
	* @return the departamentos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.sample.model.Departamento> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.liferay.sample.model.Departamento> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.liferay.sample.model.Departamento> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes the departamento where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @return the departamento that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.sample.model.Departamento removeBygroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.sample.NoSuchDepartamentoException {
		return getPersistence().removeBygroupId(groupId);
	}

	/**
	* Removes all the departamentos from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of departamentos where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching departamentos
	* @throws SystemException if a system exception occurred
	*/
	public static int countBygroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBygroupId(groupId);
	}

	/**
	* Returns the number of departamentos.
	*
	* @return the number of departamentos
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static DepartamentoPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (DepartamentoPersistence)PortletBeanLocatorUtil.locate(com.liferay.sample.service.ClpSerializer.getServletContextName(),
					DepartamentoPersistence.class.getName());

			ReferenceRegistry.registerReference(DepartamentoUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(DepartamentoPersistence persistence) {
	}

	private static DepartamentoPersistence _persistence;
}