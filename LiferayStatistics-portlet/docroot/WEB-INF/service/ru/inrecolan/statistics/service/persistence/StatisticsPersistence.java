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

import com.liferay.portal.service.persistence.BasePersistence;

import ru.inrecolan.statistics.model.Statistics;

/**
 * The persistence interface for the statistics service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author sea
 * @see StatisticsPersistenceImpl
 * @see StatisticsUtil
 * @generated
 */
public interface StatisticsPersistence extends BasePersistence<Statistics> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link StatisticsUtil} to access the statistics persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the statistics in the entity cache if it is enabled.
	*
	* @param statistics the statistics
	*/
	public void cacheResult(ru.inrecolan.statistics.model.Statistics statistics);

	/**
	* Caches the statisticses in the entity cache if it is enabled.
	*
	* @param statisticses the statisticses
	*/
	public void cacheResult(
		java.util.List<ru.inrecolan.statistics.model.Statistics> statisticses);

	/**
	* Creates a new statistics with the primary key. Does not add the statistics to the database.
	*
	* @param statId the primary key for the new statistics
	* @return the new statistics
	*/
	public ru.inrecolan.statistics.model.Statistics create(long statId);

	/**
	* Removes the statistics with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param statId the primary key of the statistics
	* @return the statistics that was removed
	* @throws ru.inrecolan.statistics.NoSuchStatisticsException if a statistics with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public ru.inrecolan.statistics.model.Statistics remove(long statId)
		throws com.liferay.portal.kernel.exception.SystemException,
			ru.inrecolan.statistics.NoSuchStatisticsException;

	public ru.inrecolan.statistics.model.Statistics updateImpl(
		ru.inrecolan.statistics.model.Statistics statistics, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the statistics with the primary key or throws a {@link ru.inrecolan.statistics.NoSuchStatisticsException} if it could not be found.
	*
	* @param statId the primary key of the statistics
	* @return the statistics
	* @throws ru.inrecolan.statistics.NoSuchStatisticsException if a statistics with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public ru.inrecolan.statistics.model.Statistics findByPrimaryKey(
		long statId)
		throws com.liferay.portal.kernel.exception.SystemException,
			ru.inrecolan.statistics.NoSuchStatisticsException;

	/**
	* Returns the statistics with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param statId the primary key of the statistics
	* @return the statistics, or <code>null</code> if a statistics with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public ru.inrecolan.statistics.model.Statistics fetchByPrimaryKey(
		long statId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the statisticses.
	*
	* @return the statisticses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<ru.inrecolan.statistics.model.Statistics> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<ru.inrecolan.statistics.model.Statistics> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<ru.inrecolan.statistics.model.Statistics> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the statisticses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of statisticses.
	*
	* @return the number of statisticses
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}