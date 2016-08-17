<%@ page contentType="text/html; charset=UTF-8" %>
<%@page import="com.liferay.portal.model.Portlet"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="java.util.Calendar"%>
<%@page import="com.liferay.portal.kernel.search.SearchContext"%>
<%@page import="com.liferay.portal.kernel.search.SearchContextFactory"%>
<%@page import="ru.inrecolan.statistics.search.StatisticsSearchTerms"%>
<%@page import="ru.inrecolan.statistics.model.Statistics"%>
<%@page import="java.util.ArrayList"%>
<%@ include file="/html/init.jsp" %>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.JavaConstants"%>
<%@page import="javax.portlet.PortletRequest"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="ru.inrecolan.statistics.search.StatisticsSearch"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@page import="ru.inrecolan.statistics.search.StatisticsDisplayTerms"%>
<%@page import="com.liferay.portal.kernel.dao.search.DisplayTerms"%>
<%@page import="com.liferay.portal.util.SessionClicks"%>
<%@page import="com.liferay.portal.service.PortletLocalServiceUtil"%>
<%@page import="com.liferay.portal.service.GroupLocalServiceUtil"%>
<%@page import="com.liferay.portal.service.UserLocalServiceUtil"%>
<%@page import="ru.inrecolan.statistics.service.StatisticsLocalServiceUtil"%>
	<% 
	PortletURL portletURL = (PortletURL)request.getAttribute("portletURL");
	if(portletURL == null) {
		portletURL = renderResponse.createRenderURL();
	}
	PortletRequest portletRequest = 
		(PortletRequest)request.getAttribute(JavaConstants.JAVAX_PORTLET_REQUEST); %>

<aui:form action="<%= portletURL.toString() %>" method="post" name="fm">
	<liferay-ui:search-container
		searchContainer="<%= new StatisticsSearch(portletRequest, portletURL) %>">
		<%
			// Получаем настройки поиска
			StatisticsDisplayTerms displayTerms =
	    		(StatisticsDisplayTerms)searchContainer.getDisplayTerms();
			// Получаем выбранные значения фильтров
			StatisticsSearchTerms searchTerms = 
				(StatisticsSearchTerms)searchContainer.getSearchTerms();
		
			List<Statistics> statistices = new ArrayList<Statistics>();
			List<Statistics> allStatistices = new ArrayList<Statistics>();
			
			if(searchTerms != null) {
				// Получаем список ститистик действий пользователя 
				statistices = StatisticsLocalServiceUtil.getStatistices(
						searchTerms.getStartDate(),
						searchTerms.getEndDate(), 
						searchTerms.getUrl(), 
						searchContainer.getStart(), 
						searchContainer.getEnd(), 
						searchTerms.isAndOperator(),
						searchContainer.getOrderByComparator());
				allStatistices = StatisticsLocalServiceUtil.search(
						searchTerms.getStartDate(), 
						searchTerms.getEndDate(), 
						searchTerms.getUrl(), 
						searchTerms.isAndOperator());
			}
			// Раскрываем вкладку «Дополнительно»
			String key = "statisticsSearchToggle";
			SessionClicks.put(request, key, "advanced");			
		%>
	    <liferay-ui:search-container-results
	    	results="<%=statistices %>"
	    	total="<%= allStatistices.size() %>"
	    />
	    <liferay-ui:search-toggle 
	    	displayTerms="<%= displayTerms %>" 
	    	id="statisticsSearchToggle" 
	    	buttonLabel="Search">
	    	<aui:field-wrapper name="<%= displayTerms.START_DATE %>">
	        	<liferay-ui:input-date formName="date" yearRangeStart="1970" yearRangeEnd="2100"
       	            dayParam="<%= displayTerms.START_DAY %>" 
       	            monthParam="<%= displayTerms.START_MONTH %>" 
       	            yearParam="<%= displayTerms.START_YEAR %>"
       	            dayValue="<%= displayTerms.getStartDay() %>"
       	            monthValue="<%= displayTerms.getStartMonth() %>"
       	            yearValue="<%= displayTerms.getStartYear() %>"  
       	            dayNullable="true" 
       	            monthNullable="true" 
       	            yearNullable="true" />
	   		</aui:field-wrapper>
			<aui:field-wrapper name="<%= displayTerms.END_DATE %>">
        		<liferay-ui:input-date formName="date" yearRangeStart="1970"
       	            yearRangeEnd="2100"
       	            dayParam="<%= displayTerms.END_DAY %>" 
       	            monthParam="<%= displayTerms.END_MONTH %>" 
       	            yearParam="<%= displayTerms.END_YEAR %>"
       	            dayValue="<%= displayTerms.getEndDay() %>"
       	            monthValue="<%= displayTerms.getEndMonth() %>"
       	            yearValue="<%= displayTerms.getEndYear() %>"        	            
       	            dayNullable="true" 
       	            monthNullable="true" 
       	            yearNullable="true" />
    		</aui:field-wrapper>
	    	<aui:fieldset>
				<aui:select name="<%= displayTerms.URL %>">
					<%
						List<String> urlList = StatisticsLocalServiceUtil.getURLs();
					%>
						<aui:option selected="true" />
					<%					
						if (urlList != null && urlList.size() > 0) {
							for (String url: urlList) {
					%>
							<aui:option value="<%= url %>"
								selected="<%= displayTerms.getUrl().equals(url) %>" 
								label="<%= url %>" />
					<%
							}
						}
					%>
				</aui:select>  	
	    	</aui:fieldset>
	    </liferay-ui:search-toggle>
	    <%
			// Раскрываем вкладку «Дополнительно»
			SessionClicks.put(request, key, "advanced");
	    %>
	    <br />
	    <liferay-ui:search-container-row
	        className="ru.inrecolan.statistics.model.Statistics"
	        keyProperty="statId"
	        modelVar="statistics" escapedModel="<%= true %>"
	    >
	        <liferay-ui:search-container-column-text
	            name="<%= StatisticsDisplayTerms.DATE_TIME %>"
	            value="<%= dateFormat.format(statistics.getActionDate()) %>"
	            orderable="<%= true %>"
	            orderableProperty="<%= StatisticsDisplayTerms.DATE_TIME %>"
	        />
	        
	        <a href="<%=statistics.getUrl()%>">
		        <liferay-ui:search-container-column-text
		        	href="<%= statistics.getUrl() %>"
		            name="<%= StatisticsDisplayTerms.URL %>"
		            value="<%= statistics.getUrl() %>"
		            orderable="<%= true %>"
		            orderableProperty="<%= StatisticsDisplayTerms.URL %>"
		        />
	        </a>
	
	        <%
	        	String sPortletName = "Веб-страница";
	        	String sPortletId = statistics.getPortletId();
	        	if(sPortletId != null) {
	        		if(!sPortletId.equals(StringPool.BLANK)) {
		        		Portlet portlet = PortletLocalServiceUtil.getPortletById(sPortletId);
		        		if(portlet != null) {
		        			sPortletName = portlet.getDisplayName();
		        		}
	        		}
	        	}
	        %>
	        
	        <liferay-ui:search-container-column-text
	            name="<%= StatisticsDisplayTerms.PORTLET %>"
	            value="<%= sPortletName %>"
	        />
	        
	        <%
	        	String action = statistics.getAction();
	        	if(action == null) {
	        		action = "Просмотр страницы";
	        	} else {
	        		if(action.equals(StringPool.BLANK)) {
	        			action = "Просмотр страницы";
	        		}
	        	}
	        	
	        %>
	
	        <liferay-ui:search-container-column-text
	            name="<%= StatisticsDisplayTerms.ACTION %>"
	            value="<%= action %>"
	        />
	        
	        <liferay-ui:search-container-column-text
	            name="<%= StatisticsDisplayTerms.USER %>"
	            value="<%= UserLocalServiceUtil.getUser(statistics.getUserId()).getLogin() %>"
	        />
	
	        <liferay-ui:search-container-column-text
	            name="<%= StatisticsDisplayTerms.GROUP %>"
	            value="<%= GroupLocalServiceUtil.getGroup(statistics.getGroupId()).getName() %>"
	        />        
	    </liferay-ui:search-container-row>
	    <liferay-ui:search-iterator />
	</liferay-ui:search-container>
</aui:form>