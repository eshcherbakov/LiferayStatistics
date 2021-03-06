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

package ru.inrecolan.statistics.service.base;

import com.liferay.counter.service.CounterLocalService;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.PersistedModel;
import com.liferay.portal.service.BaseLocalServiceImpl;
import com.liferay.portal.service.PersistedModelLocalServiceRegistryUtil;
import com.liferay.portal.service.ResourceLocalService;
import com.liferay.portal.service.ResourceService;
import com.liferay.portal.service.UserLocalService;
import com.liferay.portal.service.UserService;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;

import ru.inrecolan.statistics.model.Statistics;
import ru.inrecolan.statistics.service.StatisticsLocalService;
import ru.inrecolan.statistics.service.StatisticsService;
import ru.inrecolan.statistics.service.persistence.StatisticsPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * The base implementation of the statistics local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link ru.inrecolan.statistics.service.impl.StatisticsLocalServiceImpl}.
 * </p>
 *
 * @author sea
 * @see ru.inrecolan.statistics.service.impl.StatisticsLocalServiceImpl
 * @see ru.inrecolan.statistics.service.StatisticsLocalServiceUtil
 * @generated
 */
public abstract class StatisticsLocalServiceBaseImpl
	extends BaseLocalServiceImpl implements StatisticsLocalService,
		IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ru.inrecolan.statistics.service.StatisticsLocalServiceUtil} to access the statistics local service.
	 */

	/**
	 * Adds the statistics to the database. Also notifies the appropriate model listeners.
	 *
	 * @param statistics the statistics
	 * @return the statistics that was added
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	public Statistics addStatistics(Statistics statistics)
		throws SystemException {
		statistics.setNew(true);

		return statisticsPersistence.update(statistics, false);
	}

	/**
	 * Creates a new statistics with the primary key. Does not add the statistics to the database.
	 *
	 * @param statId the primary key for the new statistics
	 * @return the new statistics
	 */
	public Statistics createStatistics(long statId) {
		return statisticsPersistence.create(statId);
	}

	/**
	 * Deletes the statistics with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param statId the primary key of the statistics
	 * @return the statistics that was removed
	 * @throws PortalException if a statistics with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	public Statistics deleteStatistics(long statId)
		throws PortalException, SystemException {
		return statisticsPersistence.remove(statId);
	}

	/**
	 * Deletes the statistics from the database. Also notifies the appropriate model listeners.
	 *
	 * @param statistics the statistics
	 * @return the statistics that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	public Statistics deleteStatistics(Statistics statistics)
		throws SystemException {
		return statisticsPersistence.remove(statistics);
	}

	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(Statistics.class,
			clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return statisticsPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return statisticsPersistence.findWithDynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return statisticsPersistence.findWithDynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	 * Returns the number of rows that match the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows that match the dynamic query
	 * @throws SystemException if a system exception occurred
	 */
	public long dynamicQueryCount(DynamicQuery dynamicQuery)
		throws SystemException {
		return statisticsPersistence.countWithDynamicQuery(dynamicQuery);
	}

	public Statistics fetchStatistics(long statId) throws SystemException {
		return statisticsPersistence.fetchByPrimaryKey(statId);
	}

	/**
	 * Returns the statistics with the primary key.
	 *
	 * @param statId the primary key of the statistics
	 * @return the statistics
	 * @throws PortalException if a statistics with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Statistics getStatistics(long statId)
		throws PortalException, SystemException {
		return statisticsPersistence.findByPrimaryKey(statId);
	}

	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException, SystemException {
		return statisticsPersistence.findByPrimaryKey(primaryKeyObj);
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
	public List<Statistics> getStatisticses(int start, int end)
		throws SystemException {
		return statisticsPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of statisticses.
	 *
	 * @return the number of statisticses
	 * @throws SystemException if a system exception occurred
	 */
	public int getStatisticsesCount() throws SystemException {
		return statisticsPersistence.countAll();
	}

	/**
	 * Updates the statistics in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param statistics the statistics
	 * @return the statistics that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	public Statistics updateStatistics(Statistics statistics)
		throws SystemException {
		return updateStatistics(statistics, true);
	}

	/**
	 * Updates the statistics in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param statistics the statistics
	 * @param merge whether to merge the statistics with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	 * @return the statistics that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	public Statistics updateStatistics(Statistics statistics, boolean merge)
		throws SystemException {
		statistics.setNew(false);

		return statisticsPersistence.update(statistics, merge);
	}

	/**
	 * Returns the statistics local service.
	 *
	 * @return the statistics local service
	 */
	public StatisticsLocalService getStatisticsLocalService() {
		return statisticsLocalService;
	}

	/**
	 * Sets the statistics local service.
	 *
	 * @param statisticsLocalService the statistics local service
	 */
	public void setStatisticsLocalService(
		StatisticsLocalService statisticsLocalService) {
		this.statisticsLocalService = statisticsLocalService;
	}

	/**
	 * Returns the statistics remote service.
	 *
	 * @return the statistics remote service
	 */
	public StatisticsService getStatisticsService() {
		return statisticsService;
	}

	/**
	 * Sets the statistics remote service.
	 *
	 * @param statisticsService the statistics remote service
	 */
	public void setStatisticsService(StatisticsService statisticsService) {
		this.statisticsService = statisticsService;
	}

	/**
	 * Returns the statistics persistence.
	 *
	 * @return the statistics persistence
	 */
	public StatisticsPersistence getStatisticsPersistence() {
		return statisticsPersistence;
	}

	/**
	 * Sets the statistics persistence.
	 *
	 * @param statisticsPersistence the statistics persistence
	 */
	public void setStatisticsPersistence(
		StatisticsPersistence statisticsPersistence) {
		this.statisticsPersistence = statisticsPersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the resource remote service.
	 *
	 * @return the resource remote service
	 */
	public ResourceService getResourceService() {
		return resourceService;
	}

	/**
	 * Sets the resource remote service.
	 *
	 * @param resourceService the resource remote service
	 */
	public void setResourceService(ResourceService resourceService) {
		this.resourceService = resourceService;
	}

	/**
	 * Returns the resource persistence.
	 *
	 * @return the resource persistence
	 */
	public ResourcePersistence getResourcePersistence() {
		return resourcePersistence;
	}

	/**
	 * Sets the resource persistence.
	 *
	 * @param resourcePersistence the resource persistence
	 */
	public void setResourcePersistence(ResourcePersistence resourcePersistence) {
		this.resourcePersistence = resourcePersistence;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user remote service.
	 *
	 * @return the user remote service
	 */
	public UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
		Class<?> clazz = getClass();

		_classLoader = clazz.getClassLoader();

		PersistedModelLocalServiceRegistryUtil.register("ru.inrecolan.statistics.model.Statistics",
			statisticsLocalService);
	}

	public void destroy() {
		PersistedModelLocalServiceRegistryUtil.unregister(
			"ru.inrecolan.statistics.model.Statistics");
	}

	/**
	 * Returns the Spring bean ID for this bean.
	 *
	 * @return the Spring bean ID for this bean
	 */
	public String getBeanIdentifier() {
		return _beanIdentifier;
	}

	/**
	 * Sets the Spring bean ID for this bean.
	 *
	 * @param beanIdentifier the Spring bean ID for this bean
	 */
	public void setBeanIdentifier(String beanIdentifier) {
		_beanIdentifier = beanIdentifier;
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		if (contextClassLoader != _classLoader) {
			currentThread.setContextClassLoader(_classLoader);
		}

		try {
			return _clpInvoker.invokeMethod(name, parameterTypes, arguments);
		}
		finally {
			if (contextClassLoader != _classLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	protected Class<?> getModelClass() {
		return Statistics.class;
	}

	protected String getModelClassName() {
		return Statistics.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = statisticsPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = StatisticsLocalService.class)
	protected StatisticsLocalService statisticsLocalService;
	@BeanReference(type = StatisticsService.class)
	protected StatisticsService statisticsService;
	@BeanReference(type = StatisticsPersistence.class)
	protected StatisticsPersistence statisticsPersistence;
	@BeanReference(type = CounterLocalService.class)
	protected CounterLocalService counterLocalService;
	@BeanReference(type = ResourceLocalService.class)
	protected ResourceLocalService resourceLocalService;
	@BeanReference(type = ResourceService.class)
	protected ResourceService resourceService;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserLocalService.class)
	protected UserLocalService userLocalService;
	@BeanReference(type = UserService.class)
	protected UserService userService;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private String _beanIdentifier;
	private ClassLoader _classLoader;
	private StatisticsLocalServiceClpInvoker _clpInvoker = new StatisticsLocalServiceClpInvoker();
}