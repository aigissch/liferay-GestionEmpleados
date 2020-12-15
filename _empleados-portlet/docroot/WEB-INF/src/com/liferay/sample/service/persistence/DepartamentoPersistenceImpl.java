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

import com.liferay.sample.NoSuchDepartamentoException;
import com.liferay.sample.model.Departamento;
import com.liferay.sample.model.impl.DepartamentoImpl;
import com.liferay.sample.model.impl.DepartamentoModelImpl;

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
	public static final FinderPath FINDER_PATH_FETCH_BY_GROUPID = new FinderPath(DepartamentoModelImpl.ENTITY_CACHE_ENABLED,
			DepartamentoModelImpl.FINDER_CACHE_ENABLED, DepartamentoImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchBygroupId",
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

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_GROUPID,
			new Object[] { Long.valueOf(departamento.getGroupId()) },
			departamento);

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

		clearUniqueFindersCache(departamento);
	}

	@Override
	public void clearCache(List<Departamento> departamentos) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Departamento departamento : departamentos) {
			EntityCacheUtil.removeResult(DepartamentoModelImpl.ENTITY_CACHE_ENABLED,
				DepartamentoImpl.class, departamento.getPrimaryKey());

			clearUniqueFindersCache(departamento);
		}
	}

	protected void clearUniqueFindersCache(Departamento departamento) {
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_GROUPID,
			new Object[] { Long.valueOf(departamento.getGroupId()) });
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
	 * @throws com.liferay.sample.NoSuchDepartamentoException if a departamento with the primary key could not be found
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
	 * @throws com.liferay.sample.NoSuchDepartamentoException if a departamento with the primary key could not be found
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
		com.liferay.sample.model.Departamento departamento, boolean merge)
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

		EntityCacheUtil.putResult(DepartamentoModelImpl.ENTITY_CACHE_ENABLED,
			DepartamentoImpl.class, departamento.getPrimaryKey(), departamento);

		if (isNew) {
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_GROUPID,
				new Object[] { Long.valueOf(departamento.getGroupId()) },
				departamento);
		}
		else {
			if ((departamentoModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(departamentoModelImpl.getOriginalGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);

				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_GROUPID, args);

				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_GROUPID,
					new Object[] { Long.valueOf(departamento.getGroupId()) },
					departamento);
			}
		}

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
	 * Returns the departamento with the primary key or throws a {@link com.liferay.sample.NoSuchDepartamentoException} if it could not be found.
	 *
	 * @param idDepartamento the primary key of the departamento
	 * @return the departamento
	 * @throws com.liferay.sample.NoSuchDepartamentoException if a departamento with the primary key could not be found
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
	 * Returns the departamento where groupId = &#63; or throws a {@link com.liferay.sample.NoSuchDepartamentoException} if it could not be found.
	 *
	 * @param groupId the group ID
	 * @return the matching departamento
	 * @throws com.liferay.sample.NoSuchDepartamentoException if a matching departamento could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Departamento findBygroupId(long groupId)
		throws NoSuchDepartamentoException, SystemException {
		Departamento departamento = fetchBygroupId(groupId);

		if (departamento == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchDepartamentoException(msg.toString());
		}

		return departamento;
	}

	/**
	 * Returns the departamento where groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param groupId the group ID
	 * @return the matching departamento, or <code>null</code> if a matching departamento could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Departamento fetchBygroupId(long groupId) throws SystemException {
		return fetchBygroupId(groupId, true);
	}

	/**
	 * Returns the departamento where groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching departamento, or <code>null</code> if a matching departamento could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Departamento fetchBygroupId(long groupId, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_GROUPID,
					finderArgs, this);
		}

		if (result instanceof Departamento) {
			Departamento departamento = (Departamento)result;

			if ((groupId != departamento.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_SELECT_DEPARTAMENTO_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				List<Departamento> list = q.list();

				result = list;

				Departamento departamento = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_GROUPID,
						finderArgs, list);
				}
				else {
					departamento = list.get(0);

					cacheResult(departamento);

					if ((departamento.getGroupId() != groupId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_GROUPID,
							finderArgs, departamento);
					}
				}

				return departamento;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_GROUPID,
						finderArgs);
				}

				closeSession(session);
			}
		}
		else {
			if (result instanceof List<?>) {
				return null;
			}
			else {
				return (Departamento)result;
			}
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
	 * Removes the departamento where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @return the departamento that was removed
	 * @throws SystemException if a system exception occurred
	 */
	public Departamento removeBygroupId(long groupId)
		throws NoSuchDepartamentoException, SystemException {
		Departamento departamento = findBygroupId(groupId);

		return remove(departamento);
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
						"value.object.listener.com.liferay.sample.model.Departamento")));

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