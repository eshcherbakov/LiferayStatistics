/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
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

package ru.inrecolan.statistics.util.comparator;

import ru.inrecolan.statistics.model.Statistics;
import ru.inrecolan.statistics.search.StatisticsDisplayTerms;

import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.OrderByComparator;

/**
 * @author Brian Wing Shun Chan
 */
public class StatisticsActionDateComparator extends OrderByComparator {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final String ORDER_BY_ASC = "Statistics.actionDate ASC";

	public static final String ORDER_BY_DESC = "Statistics.actionDate DESC";

	public static final String[] ORDER_BY_FIELDS = {StatisticsDisplayTerms.DATE_TIME};

	public StatisticsActionDateComparator() {
		this(false);
	}

	public StatisticsActionDateComparator(boolean ascending) {
		_ascending = ascending;
	}

	@Override
	public int compare(Object obj1, Object obj2) {
		Statistics statistics1 = (Statistics)obj1;
		Statistics statistics2 = (Statistics)obj2;

		int value = DateUtil.compareTo(
				statistics1.getActionDate(), statistics2.getActionDate());

		if (_ascending) {
			return value;
		}
		else {
			return -value;
		}
	}

	@Override
	public String getOrderBy() {
		if (_ascending) {
			return ORDER_BY_ASC;
		}
		else {
			return ORDER_BY_DESC;
		}
	}

	@Override
	public String[] getOrderByFields() {
		return ORDER_BY_FIELDS;
	}

	@Override
	public boolean isAscending() {
		return _ascending;
	}

	private boolean _ascending;

}