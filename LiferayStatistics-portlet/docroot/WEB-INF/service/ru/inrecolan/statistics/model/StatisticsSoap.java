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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link ru.inrecolan.statistics.service.http.StatisticsServiceSoap}.
 *
 * @author    sea
 * @see       ru.inrecolan.statistics.service.http.StatisticsServiceSoap
 * @generated
 */
public class StatisticsSoap implements Serializable {
	public static StatisticsSoap toSoapModel(Statistics model) {
		StatisticsSoap soapModel = new StatisticsSoap();

		soapModel.setStatId(model.getStatId());
		soapModel.setUserId(model.getUserId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setActionDate(model.getActionDate());
		soapModel.setAction(model.getAction());
		soapModel.setPortletId(model.getPortletId());
		soapModel.setUrl(model.getUrl());

		return soapModel;
	}

	public static StatisticsSoap[] toSoapModels(Statistics[] models) {
		StatisticsSoap[] soapModels = new StatisticsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static StatisticsSoap[][] toSoapModels(Statistics[][] models) {
		StatisticsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new StatisticsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new StatisticsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static StatisticsSoap[] toSoapModels(List<Statistics> models) {
		List<StatisticsSoap> soapModels = new ArrayList<StatisticsSoap>(models.size());

		for (Statistics model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new StatisticsSoap[soapModels.size()]);
	}

	public StatisticsSoap() {
	}

	public long getPrimaryKey() {
		return _statId;
	}

	public void setPrimaryKey(long pk) {
		setStatId(pk);
	}

	public long getStatId() {
		return _statId;
	}

	public void setStatId(long statId) {
		_statId = statId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public Date getActionDate() {
		return _actionDate;
	}

	public void setActionDate(Date actionDate) {
		_actionDate = actionDate;
	}

	public String getAction() {
		return _action;
	}

	public void setAction(String action) {
		_action = action;
	}

	public String getPortletId() {
		return _portletId;
	}

	public void setPortletId(String portletId) {
		_portletId = portletId;
	}

	public String getUrl() {
		return _url;
	}

	public void setUrl(String url) {
		_url = url;
	}

	private long _statId;
	private long _userId;
	private long _groupId;
	private Date _actionDate;
	private String _action;
	private String _portletId;
	private String _url;
}