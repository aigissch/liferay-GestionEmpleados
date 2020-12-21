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

import com.telefonica.NoSuchDepartamentoException;

import com.telefonica.model.Departamento;
import com.telefonica.model.impl.DepartamentoImpl;
import com.telefonica.model.impl.DepartamentoModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the departamento service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author anadlca
 * @see DepartamentoPersistence
 * @see DepartamentoUtil
 * @generated
 */
public class DepartamentoPersistenceImpl extends BasePersistenceImpl<Departamento>
	implements DepartamentoPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link DepartamentoUtil} to access the departamento persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = DepartamentoImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(DepartamentoModelImpl.ENTITY_CACHE_ENABLED,
			DepartamentoModelImpl.FINDER_CACHE_ENABLED, DepartamentoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBygroupId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(DepartamentoModelImpl.ENTITY_CACHE_ENABLED,
			DepartamentoModelImpl.FINDER_CACHE_ENABLED, DepartamentoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBygroupId",
			new String[] { Long.class.getName() },
			DepartamentoModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(DepartamentoModelImpl.ENTITY_CACHE_ENABLED,
			DepartamentoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBygroupId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(DepartamentoModelImpl.ENTITY_CACHE_ENABLED,
			DepartamentoModelImpl.FINDER_CACHE_ENABLED, DepartamentoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(DepartamentoModelImpl.ENTITY_CACHE_ENABLED,
			DepartamentoModelImpl.FINDER_CACHE_ENABLED, DepartamentoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(DepartamentoModelImpl.ENTITY_CACHE_ENABLED,
			DepartamentoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the departamento in the entity cache if it is enabled.
	 *
	 * @param departamento the departamento
	 */
	public void cacheResult(Departamento departamento) {
		EntityCacheUtil.putResult(DepartamentoModelImpl.ENTITY_CACHE_ENABLED,
			DepartamentoImpl.class, departamento.getPrimaryKey(), departamento);

		departamento.resetOriginalValues();
	}

	/**
	 * Caches the departamentos in the entity cache if it is enabled.
	 *
	 * @param departamentos the departamentos
	 */
	public void cacheResult(List<Departamento> departamentos) {
		for (Departamento departamento : departamentos) {
			if (EntityCacheUtil.getResult(
						DepartamentoModelImpl.ENTITY_CACHE_ENABLED,
						DepartamentoImpl.class, departamento.getPrimaryKey()) == null) {
				cacheResult(departamento);
			}
			else {
				departamento.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all departamentos.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(DepartamentoImpl.class.getName());
		}

		EntityCacheUtil.clearCache(DepartamentoImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the departamento.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Departamento departamento) {
		EntityCacheUtil.removeResult(DepartamentoModelImpl.ENTITY_CACHE_ENABLED,
			DepartamentoImpl.class, departamento.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Departamento> departamentos) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Departamento departamento : departamentos) {
			EntityCacheUtil.removeResult(DepartamentoModelImpl.ENTITY_CACHE_ENABLED,
				DepartamentoImpl.class, departamento.getPrimaryKey());
		}
	}

	/**
	 * Creates a new departamento with the primary key. Does not add the departamento to the database.
	 *
	 * @param idDepartamento the primary key for the new departamento
	 * @return the new departamento
	 */
	public Departamento create(int idDepartamento) {
		Departamento departamento = new DepartamentoImpl();

		departamento.setNew(true);
		departamento.setPrimaryKey(idDepartamento);

		return departamento;
	}

	/**
	 * Removes the departamento with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param idDepartamento the primary key of the departamento
	 * @return the departamento that was removed
	 * @throws com.telefonica.NoSuchDepartamentoException if a departamento with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Departamento remove(int idDepartamento)
		throws NoSuchDepartamentoException, SystemException {
		return remove(Integer.valueOf(idDepartamento));
	}

	/**
	 * Removes the departamento with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the departamento
	 * @return the departamento that was removed
	 * @throws com.telefonica.NoSuchDepartamentoException if a departamento with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Departamento remove(Serializable primaryKey)
		throws NoSuchDepartamentoException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Departamento departamento = (Departamento)session.get(DepartamentoImpl.class,
					primaryKey);

			if (departamento == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDepartamentoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(departamento);
		}
		catch (NoSuchDepartamentoException nsee) {
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
	protected Departamento removeImpl(Departamento departamento)
		throws SystemException {
		departamento = toUnwrappedModel(departamento);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, departamento);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(departamento);

		return departamento;
	}

	@Override
	public Departamento updateImpl(
		com.telefonica.model.Departamento departamento, boolean merge)
		throws SystemException {
		departamento = toUnwrappedModel(departamento);

		boolean isNew = departamento.isNew();

		DepartamentoModelImpl departamentoModelImpl = (DepartamentoModelImpl)departamento;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, departamento, merge);

			departamento.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !DepartamentoModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((departamentoModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(departamentoModelImpl.getOriginalGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] {
						Long.valueOf(departamentoModelImpl.getGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}
		}

		EntityCacheUtil.putResult(DepartamentoModelImpl.ENTITY_CACHE_ENABLED,
			DepartamentoImpl.class, departamento.getPrimaryKey(), departamento);

		return departamento;
	}

	protected Departamento toUnwrappedModel(Departamento departamento) {
		if (departamento instanceof DepartamentoImpl) {
			return departamento;
		}

		DepartamentoImpl departamentoImpl = new DepartamentoImpl();

		departamentoImpl.setNew(departamento.isNew());
		departamentoImpl.setPrimaryKey(departamento.getPrimaryKey());

		departamentoImpl.setIdDepartamento(departamento.getIdDepartamento());
		departamentoImpl.setNombre(departamento.getNombre());
		departamentoImpl.setDescripcion(departamento.getDescripcion());
		departamentoImpl.setCompanyId(departamento.getCompanyId());
		departamentoImpl.setGroupId(departamento.getGroupId());

		return departamentoImpl;
	}

	/**
	 * Returns the departamento with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the departamento
	 * @return the departamento
	 * @throws com.liferay.portal.NoSuchModelException if a departamento with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Departamento findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Integer)primaryKey).intValue());
	}

	/**
	 * Returns the departamento with the primary key or throws a {@link com.telefonica.NoSuchDepartamentoException} if it could not be found.
	 *
	 * @param idDepartamento the primary key of the departamento
	 * @return the departamento
	 * @throws com.telefonica.NoSuchDepartamentoException if a departamento with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Departamento findByPrimaryKey(int idDepartamento)
		throws NoSuchDepartamentoException, SystemException {
		Departamento departamento = fetchByPrimaryKey(idDepartamento);

		if (departamento == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + idDepartamento);
			}

			throw new NoSuchDepartamentoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				idDepartamento);
		}

		return departamento;
	}

	/**
	 * Returns the departamento with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the departamento
	 * @return the departamento, or <code>null</code> if a departamento with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Departamento fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Integer)primaryKey).intValue());
	}

	/**
	 * Returns the departamento with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param idDepartamento the primary key of the departamento
	 * @return the departamento, or <code>null</code> if a departamento with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Departamento fetchByPrimaryKey(int idDepartamento)
		throws SystemException {
		Departamento departamento = (Departamento)EntityCacheUtil.getResult(DepartamentoModelImpl.ENTITY_CACHE_ENABLED,
				DepartamentoImpl.class, idDepartamento);

		if (departamento == _nullDepartamento) {
			return null;
		}

		if (departamento == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				departamento = (Departamento)session.get(DepartamentoImpl.class,
						Integer.valueOf(idDepartamento));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (departamento != null) {
					cacheResult(departamento);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(DepartamentoModelImpl.ENTITY_CACHE_ENABLED,
						DepartamentoImpl.class, idDepartamento,
						_nullDepartamento);
				}

				closeSession(session);
			}
		}

		return departamento;
	}

	/**
	 * Returns all the departamentos where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching departamentos
	 * @throws SystemException if a system exception occurred
	 */
	public List<Departamento> findBygroupId(long groupId)
		throws SystemException {
		return findBygroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	public List<Departamento> findBygroupId(long groupId, int start, int end)
		throws SystemException {
		return findBygroupId(groupId, start, end, null);
	}

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
	public List<Departamento> findBygroupId(long groupId, int start, int end,
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

		List<Departamento> list = (List<Departamento>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Departamento departamento : list) {
				if ((groupId != departamento.getGroupId())) {
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

			query.append(_SQL_SELECT_DEPARTAMENTO_WHERE);

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

				list = (List<Departamento>)QueryUtil.list(q, getDialect(),
						start, end);
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
	 * Returns the first departamento in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching departamento
	 * @throws com.telefonica.NoSuchDepartamentoException if a matching departamento could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Departamento findBygroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchDepartamentoException, SystemException {
		Departamento departamento = fetchBygroupId_First(groupId,
				orderByComparator);

		if (departamento != null) {
			return departamento;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDepartamentoException(msg.toString());
	}

	/**
	 * Returns the first departamento in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching departamento, or <code>null</code> if a matching departamento could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Departamento fetchBygroupId_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Departamento> list = findBygroupId(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last departamento in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching departamento
	 * @throws com.telefonica.NoSuchDepartamentoException if a matching departamento could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Departamento findBygroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchDepartamentoException, SystemException {
		Departamento departamento = fetchBygroupId_Last(groupId,
				orderByComparator);

		if (departamento != null) {
			return departamento;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDepartamentoException(msg.toString());
	}

	/**
	 * Returns the last departamento in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching departamento, or <code>null</code> if a matching departamento could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Departamento fetchBygroupId_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countBygroupId(groupId);

		List<Departamento> list = findBygroupId(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	public Departamento[] findBygroupId_PrevAndNext(int idDepartamento,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchDepartamentoException, SystemException {
		Departamento departamento = findByPrimaryKey(idDepartamento);

		Session session = null;

		try {
			session = openSession();

			Departamento[] array = new DepartamentoImpl[3];

			array[0] = getBygroupId_PrevAndNext(session, departamento, groupId,
					orderByComparator, true);

			array[1] = departamento;

			array[2] = getBygroupId_PrevAndNext(session, departamento, groupId,
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

	protected Departamento getBygroupId_PrevAndNext(Session session,
		Departamento departamento, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_DEPARTAMENTO_WHERE);

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
			Object[] values = orderByComparator.getOrderByConditionValues(departamento);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Departamento> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the departamentos.
	 *
	 * @return the departamentos
	 * @throws SystemException if a system exception occurred
	 */
	public List<Departamento> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<Departamento> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
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
	public List<Departamento> findAll(int start, int end,
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

		List<Departamento> list = (List<Departamento>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_DEPARTAMENTO);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_DEPARTAMENTO;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<Departamento>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<Departamento>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the departamentos where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeBygroupId(long groupId) throws SystemException {
		for (Departamento departamento : findBygroupId(groupId)) {
			remove(departamento);
		}
	}

	/**
	 * Removes all the departamentos from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (Departamento departamento : findAll()) {
			remove(departamento);
		}
	}

	/**
	 * Returns the number of departamentos where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching departamentos
	 * @throws SystemException if a system exception occurred
	 */
	public int countBygroupId(long groupId) throws SystemException {
		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_GROUPID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DEPARTAMENTO_WHERE);

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
	 * Returns the number of departamentos.
	 *
	 * @return the number of departamentos
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_DEPARTAMENTO);

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
	 * Initializes the departamento persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.telefonica.model.Departamento")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Departamento>> listenersList = new ArrayList<ModelListener<Departamento>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Departamento>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(DepartamentoImpl.class.getName());
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
	private static final String _SQL_SELECT_DEPARTAMENTO = "SELECT departamento FROM Departamento departamento";
	private static final String _SQL_SELECT_DEPARTAMENTO_WHERE = "SELECT departamento FROM Departamento departamento WHERE ";
	private static final String _SQL_COUNT_DEPARTAMENTO = "SELECT COUNT(departamento) FROM Departamento departamento";
	private static final String _SQL_COUNT_DEPARTAMENTO_WHERE = "SELECT COUNT(departamento) FROM Departamento departamento WHERE ";
	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "departamento.groupId = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "departamento.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Departamento exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Departamento exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(DepartamentoPersistenceImpl.class);
	private static Departamento _nullDepartamento = new DepartamentoImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Departamento> toCacheModel() {
				return _nullDepartamentoCacheModel;
			}
		};

	private static CacheModel<Departamento> _nullDepartamentoCacheModel = new CacheModel<Departamento>() {
			public Departamento toEntityModel() {
				return _nullDepartamento;
			}
		};
}