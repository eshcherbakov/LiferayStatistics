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

package ru.inrecolan.statistics.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Statistics}.
 * </p>
 *
 * @author    sea
 * @see       Statistics
 * @generated
 */
public class StatisticsWrapper implements Statistics, ModelWrapper<Statistics> {
	public StatisticsWrapper(Statistics statistics) {
		_statistics = statistics;
	}

	public Class<?> getModelClass() {
		return Statistics.class;
	}

	public String getModelClassName() {
		return Statistics.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("statId", getStatId());
		attributes.put("userId", getUserId());
		attributes.put("groupId", getGroupId());
		attributes.put("actionDate", getActionDate());
		attributes.put("action", getAction());
		attributes.put("portletId", getPortletId());
		attributes.put("url", getUrl());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		Long statId = (Long)attributes.get("statId");

		if (statId != null) {
			setStatId(statId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Date actionDate = (Date)attributes.get("actionDate");

		if (actionDate != null) {
			setActionDate(actionDate);
		}

		String action = (String)attributes.get("action");

		if (action != null) {
			setAction(action);
		}

		String portletId = (String)attributes.get("portletId");

		if (portletId != null) {
			setPortletId(portletId);
		}

		String url = (String)attributes.get("url");

		if (url != null) {
			setUrl(url);
		}
	}

	/**
	* Returns the primary key of this statistics.
	*
	* @return the primary key of this statistics
	*/
	public long getPrimaryKey() {
		return _statistics.getPrimaryKey();
	}

	/**
	* Sets the primary key of this statistics.
	*
	* @param primaryKey the primary key of this statistics
	*/
	public void setPrimaryKey(long primaryKey) {
		_statistics.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the stat ID of this statistics.
	*
	* @return the stat ID of this statistics
	*/
	public long getStatId() {
		return _statistics.getStatId();
	}

	/**
	* Sets the stat ID of this statistics.
	*
	* @param statId the stat ID of this statistics
	*/
	public void setStatId(long statId) {
		_statistics.setStatId(statId);
	}

	/**
	* Returns the user ID of this statistics.
	*
	* @return the user ID of this statistics
	*/
	public long getUserId() {
		return _statistics.getUserId();
	}

	/**
	* Sets the user ID of this statistics.
	*
	* @param userId the user ID of this statistics
	*/
	public void setUserId(long userId) {
		_statistics.setUserId(userId);
	}

	/**
	* Returns the user uuid of this statistics.
	*
	* @return the user uuid of this statistics
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _statistics.getUserUuid();
	}

	/**
	* Sets the user uuid of this statistics.
	*
	* @param userUuid the user uuid of this statistics
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_statistics.setUserUuid(userUuid);
	}

	/**
	* Returns the group ID of this statistics.
	*
	* @return the group ID of this statistics
	*/
	public long getGroupId() {
		return _statistics.getGroupId();
	}

	/**
	* Sets the group ID of this statistics.
	*
	* @param groupId the group ID of this statistics
	*/
	public void setGroupId(long groupId) {
		_statistics.setGroupId(groupId);
	}

	/**
	* Returns the action date of this statistics.
	*
	* @return the action date of this statistics
	*/
	public java.util.Date getActionDate() {
		return _statistics.getActionDate();
	}

	/**
	* Sets the action date of this statistics.
	*
	* @param actionDate the action date of this statistics
	*/
	public void setActionDate(java.util.Date actionDate) {
		_statistics.setActionDate(actionDate);
	}

	/**
	* Returns the action of this statistics.
	*
	* @return the action of this statistics
	*/
	public java.lang.String getAction() {
		return _statistics.getAction();
	}

	/**
	* Sets the action of this statistics.
	*
	* @param action the action of this statistics
	*/
	public void setAction(java.lang.String action) {
		_statistics.setAction(action);
	}

	/**
	* Returns the portlet ID of this statistics.
	*
	* @return the portlet ID of this statistics
	*/
	public java.lang.String getPortletId() {
		return _statistics.getPortletId();
	}

	/**
	* Sets the portlet ID of this statistics.
	*
	* @param portletId the portlet ID of this statistics
	*/
	public void setPortletId(java.lang.String portletId) {
		_statistics.setPortletId(portletId);
	}

	/**
	* Returns the url of this statistics.
	*
	* @return the url of this statistics
	*/
	public java.lang.String getUrl() {
		return _statistics.getUrl();
	}

	/**
	* Sets the url of this statistics.
	*
	* @param url the url of this statistics
	*/
	public void setUrl(java.lang.String url) {
		_statistics.setUrl(url);
	}

	public boolean isNew() {
		return _statistics.isNew();
	}

	public void setNew(boolean n) {
		_statistics.setNew(n);
	}

	public boolean isCachedModel() {
		return _statistics.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_statistics.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _statistics.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _statistics.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_statistics.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _statistics.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_statistics.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new StatisticsWrapper((Statistics)_statistics.clone());
	}

	public int compareTo(ru.inrecolan.statistics.model.Statistics statistics) {
		return _statistics.compareTo(statistics);
	}

	@Override
	public int hashCode() {
		return _statistics.hashCode();
	}

	public com.liferay.portal.model.CacheModel<ru.inrecolan.statistics.model.Statistics> toCacheModel() {
		return _statistics.toCacheModel();
	}

	public ru.inrecolan.statistics.model.Statistics toEscapedModel() {
		return new StatisticsWrapper(_statistics.toEscapedModel());
	}

	public ru.inrecolan.statistics.model.Statistics toUnescapedModel() {
		return new StatisticsWrapper(_statistics.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _statistics.toString();
	}

	public java.lang.String toXmlString() {
		return _statistics.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_statistics.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof StatisticsWrapper)) {
			return false;
		}

		StatisticsWrapper statisticsWrapper = (StatisticsWrapper)obj;

		if (Validator.equals(_statistics, statisticsWrapper._statistics)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public Statistics getWrappedStatistics() {
		return _statistics;
	}

	public Statistics getWrappedModel() {
		return _statistics;
	}

	public void resetOriginalValues() {
		_statistics.resetOriginalValues();
	}

	private Statistics _statistics;
}