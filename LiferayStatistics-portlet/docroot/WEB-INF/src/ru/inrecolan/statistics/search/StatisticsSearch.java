package ru.inrecolan.statistics.search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import ru.inrecolan.statistics.model.Statistics;
import ru.inrecolan.statistics.util.comparator.StatisticsActionDateComparator;
import ru.inrecolan.statistics.util.comparator.StatisticsURLComparator;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portlet.PortalPreferences;
import com.liferay.portlet.PortletPreferencesFactoryUtil;

public class StatisticsSearch extends SearchContainer<Statistics> {
	
	static final String STATISTICS_NS = "Statistics_WAR";
	
	public static final String EMPTY_RESULTS_MESSAGE =
			"no-records-were-found";	
	
	public StatisticsSearch(PortletRequest portletRequest, PortletURL portletURL) {
		super(
			portletRequest, new StatisticsDisplayTerms(portletRequest),
			new StatisticsSearchTerms(portletRequest), DEFAULT_CUR_PARAM,
			DEFAULT_DELTA, portletURL, null, EMPTY_RESULTS_MESSAGE);
		
		StatisticsDisplayTerms displayTerms =
				(StatisticsDisplayTerms)getDisplayTerms();
		StatisticsSearchTerms searchTerms =
				(StatisticsSearchTerms)getSearchTerms();
		
		if(displayTerms != null) {
			// Запоминаем значения		
			portletURL.setParameter(
					StatisticsDisplayTerms.START_YEAR,
					String.valueOf(displayTerms.getStartYear()));
			portletURL.setParameter(
					StatisticsDisplayTerms.START_MONTH,
					String.valueOf(displayTerms.getStartMonth()));
			portletURL.setParameter(
					StatisticsDisplayTerms.START_DAY,
					String.valueOf(displayTerms.getStartDay()));
			
			portletURL.setParameter(
					StatisticsDisplayTerms.END_YEAR,
					String.valueOf(displayTerms.getEndYear()));
			portletURL.setParameter(
					StatisticsDisplayTerms.END_MONTH,
					String.valueOf(displayTerms.getEndMonth()));
			portletURL.setParameter(
					StatisticsDisplayTerms.END_DAY,
					String.valueOf(displayTerms.getEndDay()));
			portletURL.setParameter(
					StatisticsDisplayTerms.URL, 
					displayTerms.getUrl()); 
		}
		try {
			// Настраиваем сортировку
			PortalPreferences preferences =
				PortletPreferencesFactoryUtil.getPortalPreferences(
					portletRequest);

			String orderByCol = ParamUtil.getString(
				portletRequest, "orderByCol");
			if(orderByCol.equals(StringPool.BLANK)) {
				orderByCol = getOrderByCol();
			}
			
			String orderByType = ParamUtil.getString(
				portletRequest, "orderByType");
			if(orderByType.equals(StringPool.BLANK)) {
				orderByType = getOrderByType();
			}

			if (Validator.isNotNull(orderByCol) &&
				Validator.isNotNull(orderByType)) {
				preferences.setValue(
					STATISTICS_NS, "statistics-order-by-col", orderByCol);
				preferences.setValue(
					STATISTICS_NS, "statistics-order-by-type", orderByType);
			}
			else {
				orderByCol = preferences.getValue(
					STATISTICS_NS, "statistics-order-by-col", StatisticsDisplayTerms.DATE_TIME);
				orderByType = preferences.getValue(
					STATISTICS_NS, "statistics-order-by-type", "desc");
			}
			
			OrderByComparator orderByComparator =
					getStatisticsOrderByComparator(
					orderByCol, orderByType);
			setOrderByCol(orderByCol);
			setOrderByType(orderByType);
			setOrderByComparator(orderByComparator);
		}
		catch (Exception e) {
			_log.error("Ошибка сортировки статистики: " + e.getMessage());
		}
	}
	
	public static OrderByComparator getStatisticsOrderByComparator(
		String orderByCol, String orderByType) {

		boolean orderByAsc = false;

		if (orderByType.equals("asc")) {
			orderByAsc = true;
		}

		OrderByComparator orderByComparator = null;

		if (orderByCol.equals(StatisticsDisplayTerms.DATE_TIME)) {
			orderByComparator = new StatisticsActionDateComparator(orderByAsc);
		}
		if (orderByCol.equals(StatisticsDisplayTerms.URL)) {
			orderByComparator = new StatisticsURLComparator(orderByAsc);
		}		
		return orderByComparator;
	}

	
	private static Log _log = LogFactoryUtil.getLog(StatisticsSearch.class);
}
