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

package ru.inrecolan.statistics.service.persistence;

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
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
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import ru.inrecolan.statistics.NoSuchStatisticsException;
import ru.inrecolan.statistics.model.Statistics;
import ru.inrecolan.statistics.model.impl.StatisticsImpl;
import ru.inrecolan.statistics.model.impl.StatisticsModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the statistics service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author sea
 * @see StatisticsPersistence
 * @see StatisticsUtil
 * @generated
 */
public class StatisticsPersistenceImpl extends BasePersistenceImpl<Statistics>
	implements StatisticsPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link StatisticsUtil} to access the statistics persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = StatisticsImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(StatisticsModelImpl.ENTITY_CACHE_ENABLED,
			StatisticsModelImpl.FINDER_CACHE_ENABLED, StatisticsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(StatisticsModelImpl.ENTITY_CACHE_ENABLED,
			StatisticsModelImpl.FINDER_CACHE_ENABLED, StatisticsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(StatisticsModelImpl.ENTITY_CACHE_ENABLED,
			StatisticsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the statistics in the entity cache if it is enabled.
	 *
	 * @param statistics the statistics
	 */
	public void cacheResult(Statistics statistics) {
		EntityCacheUtil.putResult(StatisticsModelImpl.ENTITY_CACHE_ENABLED,
			StatisticsImpl.class, statistics.getPrimaryKey(), statistics);

		statistics.resetOriginalValues();
	}

	/**
	 * Caches the statisticses in the entity cache if it is enabled.
	 *
	 * @param statisticses the statisticses
	 */
	public void cacheResult(List<Statistics> statisticses) {
		for (Statistics statistics : statisticses) {
			if (EntityCacheUtil.getResult(
						StatisticsModelImpl.ENTITY_CACHE_ENABLED,
						StatisticsImpl.class, statistics.getPrimaryKey()) == null) {
				cacheResult(statistics);
			}
			else {
				statistics.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all statisticses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(StatisticsImpl.class.getName());
		}

		EntityCacheUtil.clearCache(StatisticsImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the statistics.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Statistics statistics) {
		EntityCacheUtil.removeResult(StatisticsModelImpl.ENTITY_CACHE_ENABLED,
			StatisticsImpl.class, statistics.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Statistics> statisticses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Statistics statistics : statisticses) {
			EntityCacheUtil.removeResult(StatisticsModelImpl.ENTITY_CACHE_ENABLED,
				StatisticsImpl.class, statistics.getPrimaryKey());
		}
	}

	/**
	 * Creates a new statistics with the primary key. Does not add the statistics to the database.
	 *
	 * @param statId the primary key for the new statistics
	 * @return the new statistics
	 */
	public Statistics create(long statId) {
		Statistics statistics = new StatisticsImpl();

		statistics.setNew(true);
		statistics.setPrimaryKey(statId);

		return statistics;
	}

	/**
	 * Removes the statistics with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param statId the primary key of the statistics
	 * @return the statistics that was removed
	 * @throws ru.inrecolan.statistics.NoSuchStatisticsException if a statistics with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Statistics remove(long statId)
		throws NoSuchStatisticsException, SystemException {
		return remove(Long.valueOf(statId));
	}

	/**
	 * Removes the statistics with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the statistics
	 * @return the statistics that was removed
	 * @throws ru.inrecolan.statistics.NoSuchStatisticsException if a statistics with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Statistics remove(Serializable primaryKey)
		throws NoSuchStatisticsException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Statistics statistics = (Statistics)session.get(StatisticsImpl.class,
					primaryKey);

			if (statistics == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchStatisticsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(statistics);
		}
		catch (NoSuchStatisticsException nsee) {
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
	protected Statistics removeImpl(Statistics statistics)
		throws SystemException {
		statistics = toUnwrappedModel(statistics);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, statistics);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(statistics);

		return statistics;
	}

	@Override
	public Statistics updateImpl(
		ru.inrecolan.statistics.model.Statistics statistics, boolean merge)
		throws SystemException {
		statistics = toUnwrappedModel(statistics);

		boolean isNew = statistics.isNew();

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, statistics, merge);

			statistics.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(StatisticsModelImpl.ENTITY_CACHE_ENABLED,
			StatisticsImpl.class, statistics.getPrimaryKey(), statistics);

		return statistics;
	}

	protected Statistics toUnwrappedModel(Statistics statistics) {
		if (statistics instanceof StatisticsImpl) {
			return statistics;
		}

		StatisticsImpl statisticsImpl = new StatisticsImpl();

		statisticsImpl.setNew(statistics.isNew());
		statisticsImpl.setPrimaryKey(statistics.getPrimaryKey());

		statisticsImpl.setStatId(statistics.getStatId());
		statisticsImpl.setUserId(statistics.getUserId());
		statisticsImpl.setGroupId(statistics.getGroupId());
		statisticsImpl.setActionDate(statistics.getActionDate());
		statisticsImpl.setAction(statistics.getAction());
		statisticsImpl.setPortletId(statistics.getPortletId());
		statisticsImpl.setUrl(statistics.getUrl());

		return statisticsImpl;
	}

	/**
	 * Returns the statistics with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the statistics
	 * @return the statistics
	 * @throws com.liferay.portal.NoSuchModelException if a statistics with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Statistics findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the statistics with the primary key or throws a {@link ru.inrecolan.statistics.NoSuchStatisticsException} if it could not be found.
	 *
	 * @param statId the primary key of the statistics
	 * @return the statistics
	 * @throws ru.inrecolan.statistics.NoSuchStatisticsException if a statistics with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Statistics findByPrimaryKey(long statId)
		throws NoSuchStatisticsException, SystemException {
		Statistics statistics = fetchByPrimaryKey(statId);

		if (statistics == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + statId);
			}

			throw new NoSuchStatisticsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				statId);
		}

		return statistics;
	}

	/**
	 * Returns the statistics with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the statistics
	 * @return the statistics, or <code>null</code> if a statistics with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Statistics fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the statistics with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param statId the primary key of the statistics
	 * @return the statistics, or <code>null</code> if a statistics with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Statistics fetchByPrimaryKey(long statId) throws SystemException {
		Statistics statistics = (Statistics)EntityCacheUtil.getResult(StatisticsModelImpl.ENTITY_CACHE_ENABLED,
				StatisticsImpl.class, statId);

		if (statistics == _nullStatistics) {
			return null;
		}

		if (statistics == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				statistics = (Statistics)session.get(StatisticsImpl.class,
						Long.valueOf(statId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (statistics != null) {
					cacheResult(statistics);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(StatisticsModelImpl.ENTITY_CACHE_ENABLED,
						StatisticsImpl.class, statId, _nullStatistics);
				}

				closeSession(session);
			}
		}

		return statistics;
	}

	/**
	 * Returns all the statisticses.
	 *
	 * @return the statisticses
	 * @throws SystemException if a system exception occurred
	 */
	public List<Statistics> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the statisticses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of statisticses
	 * @param end the upper bound of the range of statisticses (not inclusive)
	 * @return the range of statisticses
	 * @throws SystemException if a system exception occurred
	 */
	public List<Statistics> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the statisticses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of statisticses
	 * @param end the upper bound of the range of statisticses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of statisticses
	 * @throws SystemException if a system exception occurred
	 */
	public List<Statistics> findAll(int start, int end,
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

		List<Statistics> list = (List<Statistics>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_STATISTICS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_STATISTICS;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<Statistics>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<Statistics>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the statisticses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (Statistics statistics : findAll()) {
			remove(statistics);
		}
	}

	/**
	 * Returns the number of statisticses.
	 *
	 * @return the number of statisticses
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_STATISTICS);

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
	 * Initializes the statistics persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.ru.inrecolan.statistics.model.Statistics")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Statistics>> listenersList = new ArrayList<ModelListener<Statistics>>();

				for (String listenerClassName : listenerClassNames) {
					Class<?> clazz = getClass();

					listenersList.add((ModelListener<Statistics>)InstanceFactory.newInstance(
							clazz.getClassLoader(), listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(StatisticsImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = StatisticsPersistence.class)
	protected StatisticsPersistence statisticsPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_STATISTICS = "SELECT statistics FROM Statistics statistics";
	private static final String _SQL_COUNT_STATISTICS = "SELECT COUNT(statistics) FROM Statistics statistics";
	private static final String _ORDER_BY_ENTITY_ALIAS = "statistics.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Statistics exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(StatisticsPersistenceImpl.class);
	private static Statistics _nullStatistics = new StatisticsImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Statistics> toCacheModel() {
				return _nullStatisticsCacheModel;
			}
		};

	private static CacheModel<Statistics> _nullStatisticsCacheModel = new CacheModel<Statistics>() {
			public Statistics toEntityModel() {
				return _nullStatistics;
			}
		};
}