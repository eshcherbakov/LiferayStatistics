package ru.inrecolan.statistics.search;

import javax.portlet.PortletRequest;
import com.liferay.portal.kernel.dao.search.DAOParamUtil;

public class StatisticsSearchTerms extends StatisticsDisplayTerms {

	public StatisticsSearchTerms(PortletRequest portletRequest) {
		super(portletRequest);
		
		startDay = DAOParamUtil.getInteger(portletRequest, START_DAY);
		startMonth = DAOParamUtil.getInteger(portletRequest, START_MONTH);
		startYear = DAOParamUtil.getInteger(portletRequest, START_YEAR);
		if(startYear <= 0 || startMonth < 0 || startDay <= 0) {
			createDefaultStartDate();
		}		
		setStartDate(createDate(startYear, startMonth, startDay, false));
		
		endDay = DAOParamUtil.getInteger(portletRequest, END_DAY);
		endMonth = DAOParamUtil.getInteger(portletRequest, END_MONTH);
		endYear = DAOParamUtil.getInteger(portletRequest, END_YEAR);
		if(endYear <= 0 || endMonth < 0 || endDay <= 0) {
			createDefaultEndDate();
		}
		setEndDate(createDate(endYear, endMonth, endDay, true));		
		
		url = DAOParamUtil.getString(portletRequest, URL);
		portletId = DAOParamUtil.getString(portletRequest, PORTLET);
		action = DAOParamUtil.getString(portletRequest, ACTION);
		userId = DAOParamUtil.getLong(portletRequest, USER);
		groupId = DAOParamUtil.getLong(portletRequest, GROUP);
	}

}
