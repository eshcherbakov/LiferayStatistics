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

package ru.inrecolan.statistics.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletClassLoaderUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringPool;
import ru.inrecolan.statistics.model.Statistics;
import ru.inrecolan.statistics.service.StatisticsLocalServiceUtil;
import ru.inrecolan.statistics.service.base.StatisticsLocalServiceBaseImpl;

/**
 * The implementation of the statistics local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link ru.inrecolan.statistics.service.StatisticsLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author sea
 * @see ru.inrecolan.statistics.service.base.StatisticsLocalServiceBaseImpl
 * @see ru.inrecolan.statistics.service.StatisticsLocalServiceUtil
 */
public class StatisticsLocalServiceImpl extends StatisticsLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link ru.inrecolan.statistics.service.StatisticsLocalServiceUtil} to access the statistics local service.
	 */

	@SuppressWarnings("unchecked")
	public List<String> getURLs() {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Statistics.class, 
				PortletClassLoaderUtil.getClassLoader());
		Projection projection = ProjectionFactoryUtil.distinct(ProjectionFactoryUtil.property("url"));
		dynamicQuery.setProjection(projection);
		dynamicQuery.add(PropertyFactoryUtil.forName("url").ne(StringPool.BLANK));
		List<String> urlList = new ArrayList<String>();
		try {
			urlList = StatisticsLocalServiceUtil.dynamicQuery(dynamicQuery);
		} catch (SystemException e) {
			_log.error("Ошибка при получении списка URL из БД: " + e.getMessage());
		}
		return urlList;
	}
	
	// Выполняет поиск статистики по дате и пути
	@SuppressWarnings("unchecked")
	public List<Statistics> search(
			Date startDate, 
 			Date endDate,
 			String url,
 			boolean isAndOperator) {
		
 		List<Statistics> audits = null;
		try {
			DynamicQuery auditQuery = DynamicQueryFactoryUtil.forClass(Statistics.class);
			Criterion sumCriterion = null;
			Criterion startDateCrit = RestrictionsFactoryUtil.ge("actionDate", startDate);
			Criterion endDateCrit = RestrictionsFactoryUtil.le("actionDate", endDate);					
			Criterion urlCrit = RestrictionsFactoryUtil.eq("url", url);
			
			if(isAndOperator) {
				if (isYearValid(startDate)) {
					if(sumCriterion == null) {
						sumCriterion = startDateCrit;
					}
				}
				if (isYearValid(endDate)) {
					if(sumCriterion == null) {
						sumCriterion = endDateCrit;
					} else {
						sumCriterion = RestrictionsFactoryUtil.and(sumCriterion, endDateCrit);
					};
				}
				if (url != null && !(url.equals(StringPool.BLANK))) {
					if(sumCriterion == null) {
						sumCriterion = urlCrit;
					} else {					
						sumCriterion = RestrictionsFactoryUtil.and(sumCriterion, urlCrit);
					}
				}		
			} else {
				if (isYearValid(startDate)) {
					if(sumCriterion == null) {
						sumCriterion = startDateCrit;
					}
				}
				if (isYearValid(endDate)) {
					if(sumCriterion == null) {
						sumCriterion = endDateCrit;
					} else {
						sumCriterion = RestrictionsFactoryUtil.or(sumCriterion, endDateCrit);
					};
				}
				if (url != null && !(url.equals(StringPool.BLANK))) {
					if(sumCriterion == null) {
						sumCriterion = urlCrit;
					} else {					
						sumCriterion = RestrictionsFactoryUtil.or(sumCriterion, urlCrit);
					}
				}					
			}
			if(sumCriterion != null) {
				auditQuery.add(sumCriterion);
			}
			audits = (List<Statistics>) StatisticsLocalServiceUtil
					.dynamicQuery(auditQuery);
		} catch (SystemException e) {
			_log.error("Ошибка при извлечении статистики по дате и пути URL: " + e.getMessage());
		}
		return audits;
	}
	
	// Проверяет дату на корректность
	private boolean isYearValid(Date date) {
		int MIN_YEAR = 1970;
		boolean isYearValid = false;
		if(date != null) {
			Calendar calendar = Calendar.getInstance();
			calendar.clear();
			calendar.setTime(date);
			int year = calendar.get(Calendar.YEAR);
			if(year > MIN_YEAR) {
				isYearValid = true;
			}
		}
		return isYearValid;
	}
	
	// Вовзращает список статистики действий пользователя
	public List<Statistics> getStatistices(
			Date startDate, 
 			Date endDate,
 			String url,
			int start,
			int end,
 			boolean isAndOperator,
 			OrderByComparator comparator) {
		
		// Получаем все элементы списка
		List<Statistics> statistices = null;
		statistices = search(startDate, endDate, url, isAndOperator);
		if (statistices == null) {
			statistices = new ArrayList<Statistics>();
		}
		
		// Сортируем записи
		List<Statistics> data = new ArrayList<Statistics>(statistices);
		Collections.sort(data, comparator);
		
		// Получаем элементы списка в заданном диапазоне
		List<Statistics> result = new ArrayList();
		for(int i = start; i < end; i++) {
			if(i < data.size()) {
				Statistics audit = data.get(i);
				result.add(audit);
			}
		}
		return result;
	}
	
	private Log _log = LogFactoryUtil.getLog(this.getClass());
}