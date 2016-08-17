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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import ru.inrecolan.statistics.service.ClpSerializer;
import ru.inrecolan.statistics.service.StatisticsLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author sea
 */
public class StatisticsClp extends BaseModelImpl<Statistics>
	implements Statistics {
	public StatisticsClp() {
	}

	public Class<?> getModelClass() {
		return Statistics.class;
	}

	public String getModelClassName() {
		return Statistics.class.getName();
	}

	public long getPrimaryKey() {
		return _statId;
	}

	public void setPrimaryKey(long primaryKey) {
		setStatId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_statId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
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

	@Override
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

	public long getStatId() {
		return _statId;
	}

	public void setStatId(long statId) {
		_statId = statId;

		if (_statisticsRemoteModel != null) {
			try {
				Class<?> clazz = _statisticsRemoteModel.getClass();

				Method method = clazz.getMethod("setStatId", long.class);

				method.invoke(_statisticsRemoteModel, statId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;

		if (_statisticsRemoteModel != null) {
			try {
				Class<?> clazz = _statisticsRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_statisticsRemoteModel, userId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;

		if (_statisticsRemoteModel != null) {
			try {
				Class<?> clazz = _statisticsRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_statisticsRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public Date getActionDate() {
		return _actionDate;
	}

	public void setActionDate(Date actionDate) {
		_actionDate = actionDate;

		if (_statisticsRemoteModel != null) {
			try {
				Class<?> clazz = _statisticsRemoteModel.getClass();

				Method method = clazz.getMethod("setActionDate", Date.class);

				method.invoke(_statisticsRemoteModel, actionDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getAction() {
		return _action;
	}

	public void setAction(String action) {
		_action = action;

		if (_statisticsRemoteModel != null) {
			try {
				Class<?> clazz = _statisticsRemoteModel.getClass();

				Method method = clazz.getMethod("setAction", String.class);

				method.invoke(_statisticsRemoteModel, action);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getPortletId() {
		return _portletId;
	}

	public void setPortletId(String portletId) {
		_portletId = portletId;

		if (_statisticsRemoteModel != null) {
			try {
				Class<?> clazz = _statisticsRemoteModel.getClass();

				Method method = clazz.getMethod("setPortletId", String.class);

				method.invoke(_statisticsRemoteModel, portletId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getUrl() {
		return _url;
	}

	public void setUrl(String url) {
		_url = url;

		if (_statisticsRemoteModel != null) {
			try {
				Class<?> clazz = _statisticsRemoteModel.getClass();

				Method method = clazz.getMethod("setUrl", String.class);

				method.invoke(_statisticsRemoteModel, url);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getStatisticsRemoteModel() {
		return _statisticsRemoteModel;
	}

	public void setStatisticsRemoteModel(BaseModel<?> statisticsRemoteModel) {
		_statisticsRemoteModel = statisticsRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _statisticsRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_statisticsRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			StatisticsLocalServiceUtil.addStatistics(this);
		}
		else {
			StatisticsLocalServiceUtil.updateStatistics(this);
		}
	}

	@Override
	public Statistics toEscapedModel() {
		return (Statistics)ProxyUtil.newProxyInstance(Statistics.class.getClassLoader(),
			new Class[] { Statistics.class }, new AutoEscapeBeanHandler(this));
	}

	public Statistics toUnescapedModel() {
		return this;
	}

	@Override
	public Object clone() {
		StatisticsClp clone = new StatisticsClp();

		clone.setStatId(getStatId());
		clone.setUserId(getUserId());
		clone.setGroupId(getGroupId());
		clone.setActionDate(getActionDate());
		clone.setAction(getAction());
		clone.setPortletId(getPortletId());
		clone.setUrl(getUrl());

		return clone;
	}

	public int compareTo(Statistics statistics) {
		long primaryKey = statistics.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof StatisticsClp)) {
			return false;
		}

		StatisticsClp statistics = (StatisticsClp)obj;

		long primaryKey = statistics.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{statId=");
		sb.append(getStatId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", actionDate=");
		sb.append(getActionDate());
		sb.append(", action=");
		sb.append(getAction());
		sb.append(", portletId=");
		sb.append(getPortletId());
		sb.append(", url=");
		sb.append(getUrl());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(25);

		sb.append("<model><model-name>");
		sb.append("ru.inrecolan.statistics.model.Statistics");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>statId</column-name><column-value><![CDATA[");
		sb.append(getStatId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>actionDate</column-name><column-value><![CDATA[");
		sb.append(getActionDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>action</column-name><column-value><![CDATA[");
		sb.append(getAction());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>portletId</column-name><column-value><![CDATA[");
		sb.append(getPortletId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>url</column-name><column-value><![CDATA[");
		sb.append(getUrl());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _statId;
	private long _userId;
	private String _userUuid;
	private long _groupId;
	private Date _actionDate;
	private String _action;
	private String _portletId;
	private String _url;
	private BaseModel<?> _statisticsRemoteModel;
}