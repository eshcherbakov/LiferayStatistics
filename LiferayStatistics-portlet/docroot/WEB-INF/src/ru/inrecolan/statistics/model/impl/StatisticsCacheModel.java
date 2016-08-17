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

package ru.inrecolan.statistics.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import ru.inrecolan.statistics.model.Statistics;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing Statistics in entity cache.
 *
 * @author sea
 * @see Statistics
 * @generated
 */
public class StatisticsCacheModel implements CacheModel<Statistics>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{statId=");
		sb.append(statId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", actionDate=");
		sb.append(actionDate);
		sb.append(", action=");
		sb.append(action);
		sb.append(", portletId=");
		sb.append(portletId);
		sb.append(", url=");
		sb.append(url);
		sb.append("}");

		return sb.toString();
	}

	public Statistics toEntityModel() {
		StatisticsImpl statisticsImpl = new StatisticsImpl();

		statisticsImpl.setStatId(statId);
		statisticsImpl.setUserId(userId);
		statisticsImpl.setGroupId(groupId);

		if (actionDate == Long.MIN_VALUE) {
			statisticsImpl.setActionDate(null);
		}
		else {
			statisticsImpl.setActionDate(new Date(actionDate));
		}

		if (action == null) {
			statisticsImpl.setAction(StringPool.BLANK);
		}
		else {
			statisticsImpl.setAction(action);
		}

		if (portletId == null) {
			statisticsImpl.setPortletId(StringPool.BLANK);
		}
		else {
			statisticsImpl.setPortletId(portletId);
		}

		if (url == null) {
			statisticsImpl.setUrl(StringPool.BLANK);
		}
		else {
			statisticsImpl.setUrl(url);
		}

		statisticsImpl.resetOriginalValues();

		return statisticsImpl;
	}

	public long statId;
	public long userId;
	public long groupId;
	public long actionDate;
	public String action;
	public String portletId;
	public String url;
}