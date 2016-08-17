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

package ru.inrecolan.statistics.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link StatisticsLocalService}.
 * </p>
 *
 * @author    sea
 * @see       StatisticsLocalService
 * @generated
 */
public class StatisticsLocalServiceWrapper implements StatisticsLocalService,
	ServiceWrapper<StatisticsLocalService> {
	public StatisticsLocalServiceWrapper(
		StatisticsLocalService statisticsLocalService) {
		_statisticsLocalService = statisticsLocalService;
	}

	/**
	* Adds the statistics to the database. Also notifies the appropriate model listeners.
	*
	* @param statistics the statistics
	* @return the statistics that was added
	* @throws SystemException if a system exception occurred
	*/
	public ru.inrecolan.statistics.model.Statistics addStatistics(
		ru.inrecolan.statistics.model.Statistics statistics)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _statisticsLocalService.addStatistics(statistics);
	}

	/**
	* Creates a new statistics with the primary key. Does not add the statistics to the database.
	*
	* @param statId the primary key for the new statistics
	* @return the new statistics
	*/
	public ru.inrecolan.statistics.model.Statistics createStatistics(
		long statId) {
		return _statisticsLocalService.createStatistics(statId);
	}

	/**
	* Deletes the statistics with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param statId the primary key of the statistics
	* @return the statistics that was removed
	* @throws PortalException if a statistics with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public ru.inrecolan.statistics.model.Statistics deleteStatistics(
		long statId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _statisticsLocalService.deleteStatistics(statId);
	}

	/**
	* Deletes the statistics from the database. Also notifies the appropriate model listeners.
	*
	* @param statistics the statistics
	* @return the statistics that was removed
	* @throws SystemException if a system exception occurred
	*/
	public ru.inrecolan.statistics.model.Statistics deleteStatistics(
		ru.inrecolan.statistics.model.Statistics statistics)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _statisticsLocalService.deleteStatistics(statistics);
	}

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _statisticsLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _statisticsLocalService.dynamicQuery(dynamicQuery);
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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _statisticsLocalService.dynamicQuery(dynamicQuery, start, end);
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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _statisticsLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _statisticsLocalService.dynamicQueryCount(dynamicQuery);
	}

	public ru.inrecolan.statistics.model.Statistics fetchStatistics(long statId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _statisticsLocalService.fetchStatistics(statId);
	}

	/**
	* Returns the statistics with the primary key.
	*
	* @param statId the primary key of the statistics
	* @return the statistics
	* @throws PortalException if a statistics with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public ru.inrecolan.statistics.model.Statistics getStatistics(long statId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _statisticsLocalService.getStatistics(statId);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _statisticsLocalService.getPersistedModel(primaryKeyObj);
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
	public java.util.List<ru.inrecolan.statistics.model.Statistics> getStatisticses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _statisticsLocalService.getStatisticses(start, end);
	}

	/**
	* Returns the number of statisticses.
	*
	* @return the number of statisticses
	* @throws SystemException if a system exception occurred
	*/
	public int getStatisticsesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _statisticsLocalService.getStatisticsesCount();
	}

	/**
	* Updates the statistics in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param statistics the statistics
	* @return the statistics that was updated
	* @throws SystemException if a system exception occurred
	*/
	public ru.inrecolan.statistics.model.Statistics updateStatistics(
		ru.inrecolan.statistics.model.Statistics statistics)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _statisticsLocalService.updateStatistics(statistics);
	}

	/**
	* Updates the statistics in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param statistics the statistics
	* @param merge whether to merge the statistics with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the statistics that was updated
	* @throws SystemException if a system exception occurred
	*/
	public ru.inrecolan.statistics.model.Statistics updateStatistics(
		ru.inrecolan.statistics.model.Statistics statistics, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _statisticsLocalService.updateStatistics(statistics, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _statisticsLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_statisticsLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _statisticsLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	public java.util.List<java.lang.String> getURLs() {
		return _statisticsLocalService.getURLs();
	}

	public java.util.List<ru.inrecolan.statistics.model.Statistics> search(
		java.util.Date startDate, java.util.Date endDate, java.lang.String url,
		boolean isAndOperator) {
		return _statisticsLocalService.search(startDate, endDate, url,
			isAndOperator);
	}

	public java.util.List<ru.inrecolan.statistics.model.Statistics> getStatistices(
		java.util.Date startDate, java.util.Date endDate, java.lang.String url,
		int start, int end, boolean isAndOperator,
		com.liferay.portal.kernel.util.OrderByComparator comparator) {
		return _statisticsLocalService.getStatistices(startDate, endDate, url,
			start, end, isAndOperator, comparator);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public StatisticsLocalService getWrappedStatisticsLocalService() {
		return _statisticsLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedStatisticsLocalService(
		StatisticsLocalService statisticsLocalService) {
		_statisticsLocalService = statisticsLocalService;
	}

	public StatisticsLocalService getWrappedService() {
		return _statisticsLocalService;
	}

	public void setWrappedService(StatisticsLocalService statisticsLocalService) {
		_statisticsLocalService = statisticsLocalService;
	}

	private StatisticsLocalService _statisticsLocalService;
}