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

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.telefonica.NoSuchEmpleadoException;

import com.telefonica.model.Empleado;
import com.telefonica.model.impl.EmpleadoImpl;
import com.telefonica.model.impl.EmpleadoModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the empleado service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author anadlca
 * @see EmpleadoPersistence
 * @see EmpleadoUtil
 * @generated
 */
public class EmpleadoPersistenceImpl extends BasePersistenceImpl<Empleado>
	implements EmpleadoPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link EmpleadoUtil} to access the empleado persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = EmpleadoImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(EmpleadoModelImpl.ENTITY_CACHE_ENABLED,
			EmpleadoModelImpl.FINDER_CACHE_ENABLED, EmpleadoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBygroupId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(EmpleadoModelImpl.ENTITY_CACHE_ENABLED,
			EmpleadoModelImpl.FINDER_CACHE_ENABLED, EmpleadoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBygroupId",
			new String[] { Long.class.getName() },
			EmpleadoModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(EmpleadoModelImpl.ENTITY_CACHE_ENABLED,
			EmpleadoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBygroupId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(EmpleadoModelImpl.ENTITY_CACHE_ENABLED,
			EmpleadoModelImpl.FINDER_CACHE_ENABLED, EmpleadoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(EmpleadoModelImpl.ENTITY_CACHE_ENABLED,
			EmpleadoModelImpl.FINDER_CACHE_ENABLED, EmpleadoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(EmpleadoModelImpl.ENTITY_CACHE_ENABLED,
			EmpleadoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the empleado in the entity cache if it is enabled.
	 *
	 * @param empleado the empleado
	 */
	public void cacheResult(Empleado empleado) {
		EntityCacheUtil.putResult(EmpleadoModelImpl.ENTITY_CACHE_ENABLED,
			EmpleadoImpl.class, empleado.getPrimaryKey(), empleado);

		empleado.resetOriginalValues();
	}

	/**
	 * Caches the empleados in the entity cache if it is enabled.
	 *
	 * @param empleados the empleados
	 */
	public void cacheResult(List<Empleado> empleados) {
		for (Empleado empleado : empleados) {
			if (EntityCacheUtil.getResult(
						EmpleadoModelImpl.ENTITY_CACHE_ENABLED,
						EmpleadoImpl.class, empleado.getPrimaryKey()) == null) {
				cacheResult(empleado);
			}
			else {
				empleado.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all empleados.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(EmpleadoImpl.class.getName());
		}

		EntityCacheUtil.clearCache(EmpleadoImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the empleado.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Empleado empleado) {
		EntityCacheUtil.removeResult(EmpleadoModelImpl.ENTITY_CACHE_ENABLED,
			EmpleadoImpl.class, empleado.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Empleado> empleados) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Empleado empleado : empleados) {
			EntityCacheUtil.removeResult(EmpleadoModelImpl.ENTITY_CACHE_ENABLED,
				EmpleadoImpl.class, empleado.getPrimaryKey());
		}
	}

	/**
	 * Creates a new empleado with the primary key. Does not add the empleado to the database.
	 *
	 * @param idEmpleado the primary key for the new empleado
	 * @return the new empleado
	 */
	public Empleado create(int idEmpleado) {
		Empleado empleado = new EmpleadoImpl();

		empleado.setNew(true);
		empleado.setPrimaryKey(idEmpleado);

		return empleado;
	}

	/**
	 * Removes the empleado with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param idEmpleado the primary key of the empleado
	 * @return the empleado that was removed
	 * @throws com.telefonica.NoSuchEmpleadoException if a empleado with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Empleado remove(int idEmpleado)
		throws NoSuchEmpleadoException, SystemException {
		return remove(Integer.valueOf(idEmpleado));
	}

	/**
	 * Removes the empleado with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the empleado
	 * @return the empleado that was removed
	 * @throws com.telefonica.NoSuchEmpleadoException if a empleado with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Empleado remove(Serializable primaryKey)
		throws NoSuchEmpleadoException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Empleado empleado = (Empleado)session.get(EmpleadoImpl.class,
					primaryKey);

			if (empleado == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEmpleadoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(empleado);
		}
		catch (NoSuchEmpleadoException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Empleado removeImpl(Empleado empleado) throws SystemException {
		empleado = toUnwrappedModel(empleado);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, empleado);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(empleado);

		return empleado;
	}

	@Override
	public Empleado updateImpl(com.telefonica.model.Empleado empleado,
		boolean merge) throws SystemException {
		empleado = toUnwrappedModel(empleado);

		boolean isNew = empleado.isNew();

		EmpleadoModelImpl empleadoModelImpl = (EmpleadoModelImpl)empleado;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, empleado, merge);

			empleado.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !EmpleadoModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((empleadoModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(empleadoModelImpl.getOriginalGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] { Long.valueOf(empleadoModelImpl.getGroupId()) };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}
		}

		EntityCacheUtil.putResult(EmpleadoModelImpl.ENTITY_CACHE_ENABLED,
			EmpleadoImpl.class, empleado.getPrimaryKey(), empleado);

		return empleado;
	}

	protected Empleado toUnwrappedModel(Empleado empleado) {
		if (empleado instanceof EmpleadoImpl) {
			return empleado;
		}

		EmpleadoImpl empleadoImpl = new EmpleadoImpl();

		empleadoImpl.setNew(empleado.isNew());
		empleadoImpl.setPrimaryKey(empleado.getPrimaryKey());

		empleadoImpl.setIdEmpleado(empleado.getIdEmpleado());
		empleadoImpl.setNombre(empleado.getNombre());
		empleadoImpl.setTelefono(empleado.getTelefono());
		empleadoImpl.setIdDepartamento(empleado.getIdDepartamento());
		empleadoImpl.setUrlFoto(empleado.getUrlFoto());
		empleadoImpl.setCompanyId(empleado.getCompanyId());
		empleadoImpl.setGroupId(empleado.getGroupId());

		return empleadoImpl;
	}

	/**
	 * Returns the empleado with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the empleado
	 * @return the empleado
	 * @throws com.liferay.portal.NoSuchModelException if a empleado with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Empleado findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Integer)primaryKey).intValue());
	}

	/**
	 * Returns the empleado with the primary key or throws a {@link com.telefonica.NoSuchEmpleadoException} if it could not be found.
	 *
	 * @param idEmpleado the primary key of the empleado
	 * @return the empleado
	 * @throws com.telefonica.NoSuchEmpleadoException if a empleado with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Empleado findByPrimaryKey(int idEmpleado)
		throws NoSuchEmpleadoException, SystemException {
		Empleado empleado = fetchByPrimaryKey(idEmpleado);

		if (empleado == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + idEmpleado);
			}

			throw new NoSuchEmpleadoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				idEmpleado);
		}

		return empleado;
	}

	/**
	 * Returns the empleado with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the empleado
	 * @return the empleado, or <code>null</code> if a empleado with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Empleado fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Integer)primaryKey).intValue());
	}

	/**
	 * Returns the empleado with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param idEmpleado the primary key of the empleado
	 * @return the empleado, or <code>null</code> if a empleado with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Empleado fetchByPrimaryKey(int idEmpleado) throws SystemException {
		Empleado empleado = (Empleado)EntityCacheUtil.getResult(EmpleadoModelImpl.ENTITY_CACHE_ENABLED,
				EmpleadoImpl.class, idEmpleado);

		if (empleado == _nullEmpleado) {
			return null;
		}

		if (empleado == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				empleado = (Empleado)session.get(EmpleadoImpl.class,
						Integer.valueOf(idEmpleado));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (empleado != null) {
					cacheResult(empleado);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(EmpleadoModelImpl.ENTITY_CACHE_ENABLED,
						EmpleadoImpl.class, idEmpleado, _nullEmpleado);
				}

				closeSession(session);
			}
		}

		return empleado;
	}

	/**
	 * Returns all the empleados where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching empleados
	 * @throws SystemException if a system exception occurred
	 */
	public List<Empleado> findBygroupId(long groupId) throws SystemException {
		return findBygroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<Empleado> findBygroupId(long groupId, int start, int end)
		throws SystemException {
		return findBygroupId(groupId, start, end, null);
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
	public List<Empleado> findBygroupId(long groupId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID;
			finderArgs = new Object[] { groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID;
			finderArgs = new Object[] { groupId, start, end, orderByComparator };
		}

		List<Empleado> list = (List<Empleado>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Empleado empleado : list) {
				if ((groupId != empleado.getGroupId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(2);
			}

			query.append(_SQL_SELECT_EMPLEADO_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				list = (List<Empleado>)QueryUtil.list(q, getDialect(), start,
						end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
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
	public Empleado findBygroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchEmpleadoException, SystemException {
		Empleado empleado = fetchBygroupId_First(groupId, orderByComparator);

		if (empleado != null) {
			return empleado;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEmpleadoException(msg.toString());
	}

	/**
	 * Returns the first empleado in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching empleado, or <code>null</code> if a matching empleado could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Empleado fetchBygroupId_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Empleado> list = findBygroupId(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	public Empleado findBygroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchEmpleadoException, SystemException {
		Empleado empleado = fetchBygroupId_Last(groupId, orderByComparator);

		if (empleado != null) {
			return empleado;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEmpleadoException(msg.toString());
	}

	/**
	 * Returns the last empleado in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching empleado, or <code>null</code> if a matching empleado could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Empleado fetchBygroupId_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countBygroupId(groupId);

		List<Empleado> list = findBygroupId(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	public Empleado[] findBygroupId_PrevAndNext(int idEmpleado, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchEmpleadoException, SystemException {
		Empleado empleado = findByPrimaryKey(idEmpleado);

		Session session = null;

		try {
			session = openSession();

			Empleado[] array = new EmpleadoImpl[3];

			array[0] = getBygroupId_PrevAndNext(session, empleado, groupId,
					orderByComparator, true);

			array[1] = empleado;

			array[2] = getBygroupId_PrevAndNext(session, empleado, groupId,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Empleado getBygroupId_PrevAndNext(Session session,
		Empleado empleado, long groupId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_EMPLEADO_WHERE);

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(empleado);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Empleado> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the empleados.
	 *
	 * @return the empleados
	 * @throws SystemException if a system exception occurred
	 */
	public List<Empleado> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<Empleado> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
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
	public List<Empleado> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = new Object[] { start, end, orderByComparator };

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<Empleado> list = (List<Empleado>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_EMPLEADO);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_EMPLEADO;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<Empleado>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<Empleado>)QueryUtil.list(q, getDialect(),
							start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the empleados where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeBygroupId(long groupId) throws SystemException {
		for (Empleado empleado : findBygroupId(groupId)) {
			remove(empleado);
		}
	}

	/**
	 * Removes all the empleados from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (Empleado empleado : findAll()) {
			remove(empleado);
		}
	}

	/**
	 * Returns the number of empleados where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching empleados
	 * @throws SystemException if a system exception occurred
	 */
	public int countBygroupId(long groupId) throws SystemException {
		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_GROUPID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_EMPLEADO_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_GROUPID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of empleados.
	 *
	 * @return the number of empleados
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_EMPLEADO);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the empleado persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.telefonica.model.Empleado")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Empleado>> listenersList = new ArrayList<ModelListener<Empleado>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Empleado>)InstanceFactory.newInstance(
							listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(EmpleadoImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = DepartamentoPersistence.class)
	protected DepartamentoPersistence departamentoPersistence;
	@BeanReference(type = EmpleadoPersistence.class)
	protected EmpleadoPersistence empleadoPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_EMPLEADO = "SELECT empleado FROM Empleado empleado";
	private static final String _SQL_SELECT_EMPLEADO_WHERE = "SELECT empleado FROM Empleado empleado WHERE ";
	private static final String _SQL_COUNT_EMPLEADO = "SELECT COUNT(empleado) FROM Empleado empleado";
	private static final String _SQL_COUNT_EMPLEADO_WHERE = "SELECT COUNT(empleado) FROM Empleado empleado WHERE ";
	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "empleado.groupId = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "empleado.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Empleado exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Empleado exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(EmpleadoPersistenceImpl.class);
	private static Empleado _nullEmpleado = new EmpleadoImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Empleado> toCacheModel() {
				return _nullEmpleadoCacheModel;
			}
		};

	private static CacheModel<Empleado> _nullEmpleadoCacheModel = new CacheModel<Empleado>() {
			public Empleado toEntityModel() {
				return _nullEmpleado;
			}
		};
}