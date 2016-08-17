package ru.inrecolan.statistics.search;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.portlet.PortletRequest;

import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;

public class StatisticsDisplayTerms extends DisplayTerms {
	
	public static final String DATE_TIME = "date-and-time";
	
	public static final String START_DATE = "start-date";	
	public static final String START_DAY = "start-day";
	public static final String START_MONTH = "start-month";
	public static final String START_YEAR = "start-year";
	
	public static final String END_DATE = "end-date";	
	public static final String END_DAY = "end-day";
	public static final String END_MONTH = "end-month";
	public static final String END_YEAR = "end-year";		
	
	public static final String URL = "url";
	public static final String USER = "user";
    public static final String GROUP = "group";
    public static final String PORTLET = "portlet"; 
    public static final String ACTION = "action";
    
	public StatisticsDisplayTerms(PortletRequest portletRequest) {
		super(portletRequest);
		
		// Определяем дату начала
		startYear = ParamUtil.getInteger(portletRequest, START_YEAR);
		startMonth = ParamUtil.getInteger(portletRequest, START_MONTH);
		startDay = ParamUtil.getInteger(portletRequest, START_DAY);
		
		if(startYear <= 0 || startMonth < 0 || startDay <= 0) {
			createDefaultStartDate();
		}
		startDate = createDate(startYear, startMonth, startDay, false);
		
		// Определяем дату окончания
		endYear = ParamUtil.getInteger(portletRequest, END_YEAR);
		endMonth = ParamUtil.getInteger(portletRequest, END_MONTH);
		endDay = ParamUtil.getInteger(portletRequest, END_DAY);
		
		if(endYear <= 0 || endMonth < 0 || endDay <= 0) {
			createDefaultEndDate();
		}
		endDate = createDate(endYear, endMonth, endDay, true);
		
		// Определяем остальные параметры фильтра
		url = ParamUtil.getString(portletRequest, URL);
		action = ParamUtil.getString(portletRequest, ACTION);
		userId = ParamUtil.getLong(portletRequest, USER);
		groupId = ParamUtil.getLong(portletRequest, GROUP);
	}
	
	public Date createDate(int year, int month, int day, boolean isEndOfDay) {
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		calendar.set(Calendar.YEAR, year);

		calendar.set(Calendar.MONTH, month);
		calendar.set(Calendar.DAY_OF_MONTH, day);
		if(isEndOfDay) {
			calendar.add(Calendar.DAY_OF_MONTH, 1);
			calendar.add(Calendar.MILLISECOND, -1);
		}
		Date date = calendar.getTime();
		return date;
	}
	
	protected void createDefaultStartDate() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		startYear = calendar.get(Calendar.YEAR);
		startMonth = calendar.get(Calendar.MONTH);
		startDay = calendar.get(Calendar.DAY_OF_MONTH);	
	}
	
	protected void createDefaultEndDate() {
		Calendar calendar = Calendar.getInstance();
		endYear = calendar.get(Calendar.YEAR);
		endMonth = calendar.get(Calendar.MONTH);
		endDay = calendar.get(Calendar.DAY_OF_MONTH);	
	}	

	@Override
	public boolean isAdvancedSearch() {
		return true;
	}	

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getStartYear() {
		return startYear;
	}

	public void setStartYear(int startYear) {
		this.startYear = startYear;
	}

	public int getStartMonth() {
		return startMonth;
	}

	public void setStartMonth(int startMonth) {
		this.startMonth = startMonth;
	}

	public int getStartDay() {
		return startDay;
	}

	public void setStartDay(int startDay) {
		this.startDay = startDay;
	}

	public int getEndYear() {
		return endYear;
	}

	public void setEndYear(int endYear) {
		this.endYear = endYear;
	}

	public int getEndMonth() {
		return endMonth;
	}

	public void setEndMonth(int endMonth) {
		this.endMonth = endMonth;
	}

	public int getEndDay() {
		return endDay;
	}

	public void setEndDay(int endDay) {
		this.endDay = endDay;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	private Date startDate;
	protected int startYear = 0;
	protected int startMonth = 0;
	protected int startDay = 0;
		
	private Date endDate;
	protected int endYear = 0;
	protected int endMonth = 0;
	protected int endDay = 0;	
	
	protected String url = StringPool.BLANK;
	protected String portletId = StringPool.BLANK;
	protected String action = StringPool.BLANK;
	protected long userId = 0L;
	protected long groupId = 0L;

}
