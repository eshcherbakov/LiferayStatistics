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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * The utility for the statistics local service. This utility wraps {@link ru.inrecolan.statistics.service.impl.StatisticsLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author sea
 * @see StatisticsLocalService
 * @see ru.inrecolan.statistics.service.base.StatisticsLocalServiceBaseImpl
 * @see ru.inrecolan.statistics.service.impl.StatisticsLocalServiceImpl
 * @generated
 */
public class StatisticsLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link ru.inrecolan.statistics.service.impl.StatisticsLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the statistics to the database. Also notifies the appropriate model listeners.
	*
	* @param statistics the statistics
	* @return the statistics that was added
	* @throws SystemException if a system exception occurred
	*/
	public static ru.inrecolan.statistics.model.Statistics addStatistics(
		ru.inrecolan.statistics.model.Statistics statistics)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addStatistics(statistics);
	}

	/**
	* Creates a new statistics with the primary key. Does not add the statistics to the database.
	*
	* @param statId the primary key for the new statistics
	* @return the new statistics
	*/
	public static ru.inrecolan.statistics.model.Statistics createStatistics(
		long statId) {
		return getService().createStatistics(statId);
	}

	/**
	* Deletes the statistics with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param statId the primary key of the statistics
	* @return the statistics that was removed
	* @throws PortalException if a statistics with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static ru.inrecolan.statistics.model.Statistics deleteStatistics(
		long statId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteStatistics(statId);
	}

	/**
	* Deletes the statistics from the database. Also notifies the appropriate model listeners.
	*
	* @param statistics the statistics
	* @return the statistics that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static ru.inrecolan.statistics.model.Statistics deleteStatistics(
		ru.inrecolan.statistics.model.Statistics statistics)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteStatistics(statistics);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
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
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	public static ru.inrecolan.statistics.model.Statistics fetchStatistics(
		long statId) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchStatistics(statId);
	}

	/**
	* Returns the statistics with the primary key.
	*
	* @param statId the primary key of the statistics
	* @return the statistics
	* @throws PortalException if a statistics with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static ru.inrecolan.statistics.model.Statistics getStatistics(
		long statId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getStatistics(statId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<ru.inrecolan.statistics.model.Statistics> getStatisticses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getStatisticses(start, end);
	}

	/**
	* Returns the number of statisticses.
	*
	* @return the number of statisticses
	* @throws SystemException if a system exception occurred
	*/
	public static int getStatisticsesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getStatisticsesCount();
	}

	/**
	* Updates the statistics in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param statistics the statistics
	* @return the statistics that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static ru.inrecolan.statistics.model.Statistics updateStatistics(
		ru.inrecolan.statistics.model.Statistics statistics)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateStatistics(statistics);
	}

	/**
	* Updates the statistics in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param statistics the statistics
	* @param merge whether to merge the statistics with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the statistics that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static ru.inrecolan.statistics.model.Statistics updateStatistics(
		ru.inrecolan.statistics.model.Statistics statistics, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateStatistics(statistics, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static java.util.List<java.lang.String> getURLs() {
		return getService().getURLs();
	}

	public static java.util.List<ru.inrecolan.statistics.model.Statistics> search(
		java.util.Date startDate, java.util.Date endDate, java.lang.String url,
		boolean isAndOperator) {
		return getService().search(startDate, endDate, url, isAndOperator);
	}

	public static java.util.List<ru.inrecolan.statistics.model.Statistics> getStatistices(
		java.util.Date startDate, java.util.Date endDate, java.lang.String url,
		int start, int end, boolean isAndOperator,
		com.liferay.portal.kernel.util.OrderByComparator comparator) {
		return getService()
				   .getStatistices(startDate, endDate, url, start, end,
			isAndOperator, comparator);
	}

	public static void clearService() {
		_service = null;
	}

	public static StatisticsLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					StatisticsLocalService.class.getName());

			if (invokableLocalService instanceof StatisticsLocalService) {
				_service = (StatisticsLocalService)invokableLocalService;
			}
			else {
				_service = new StatisticsLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(StatisticsLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated
	 */
	public void setService(StatisticsLocalService service) {
	}

	private static StatisticsLocalService _service;
}