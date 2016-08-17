package ru.inrecolan.statistics.action;

import java.io.IOException;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import ru.inrecolan.statistics.search.StatisticsDisplayTerms;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

public class StatisticsAction extends MVCPortlet {
	
	@Override
	public void serveResource(
			ResourceRequest resourceRequest, ResourceResponse resourceResponse)
		throws IOException, PortletException {
		
		String startDay = ParamUtil.getString(resourceRequest, StatisticsDisplayTerms.START_DAY);
		String startMonth = ParamUtil.getString(resourceRequest, StatisticsDisplayTerms.START_MONTH);
		String startYear = ParamUtil.getString(resourceRequest, StatisticsDisplayTerms.START_YEAR);
		
		String url = ParamUtil.getString(resourceRequest, StatisticsDisplayTerms.URL);
		
		System.out.println("Start day: " + startDay);
		System.out.println("Start month: " + startMonth);
		System.out.println("Start year: " + startYear);		
		System.out.println("URL: " + url);
		
		super.serveResource(resourceRequest, resourceResponse);
	}
}
