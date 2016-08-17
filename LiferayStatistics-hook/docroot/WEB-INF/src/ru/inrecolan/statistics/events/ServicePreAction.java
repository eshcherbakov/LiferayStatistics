package ru.inrecolan.statistics.events;

import java.util.Date;
import javax.portlet.ActionRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ru.inrecolan.statistics.model.Statistics;
import ru.inrecolan.statistics.service.StatisticsLocalServiceUtil;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.events.Action;
import com.liferay.portal.kernel.events.ActionException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.log.LogUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Layout;
import com.liferay.portal.theme.ThemeDisplay;

public class ServicePreAction extends Action {

	@Override
	public void run(HttpServletRequest request, HttpServletResponse response)
			throws ActionException {
		try {
			ThemeDisplay themeDisplay = getThemeDisplay(request);
			if (!themeDisplay.getURLCurrent().contains("control_panel")) {
				generateStatistics(request);
			}
		} catch(Exception exp) {
			exp.printStackTrace();
		}
	}
	
	// Возвращает действие пользователя
	private String getAction(HttpServletRequest request) {
		String action = null;
		String actionParam = String.format("_%s_%s", getPortletId(request), 
				ActionRequest.ACTION_NAME);
		String strutsParam = String.format("_%s_struts_action", 
				getPortletId(request));
		if(request.getParameter(actionParam) == null) {
			action = request.getParameter(strutsParam);
		} else {
			action = request.getParameter(actionParam);
		}
		return action;
	}
	
	// Возвращает идентификатор портлета
	private String getPortletId(HttpServletRequest request) {
		return request.getParameter("p_p_id");
	}
	
	private ThemeDisplay getThemeDisplay(HttpServletRequest request) {
		return (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
	}
	
	private void generateStatistics(HttpServletRequest request) {
		String friendlyURL = (String)request.getAttribute("FRIENDLY_URL");
		
		ThemeDisplay themeDisplay = getThemeDisplay(request);
		// Возвращаем идентификатор пользователя
		long userId = themeDisplay.getUserId();
		
		Layout layout = themeDisplay.getLayout();
		long groupId = layout.getGroupId();
		
		// Получаем идентификатор портлета
		String portletId = getPortletId(request);
		// Получаем действие пользователя
		String action = getAction(request);

		if (friendlyURL != null || action != null || portletId != null) {
			try {
				// Вычисляем идентификатор столбца
				long id = CounterLocalServiceUtil.increment(Statistics.class.getName());
				// Создаём объект статистики
				Statistics stat = StatisticsLocalServiceUtil.createStatistics(id);
				stat.setUserId(userId);
				stat.setActionDate(new Date());
				stat.setUrl(friendlyURL);
				stat.setPortletId(portletId);
				stat.setAction(action);
				stat.setGroupId(groupId);
				// Добавляем статистику
				StatisticsLocalServiceUtil.addStatistics(stat);
			} catch (Exception e) {
				_log.error("Ошибка вставки записи статистики в БД: " + e.getMessage());
			}
		}
	}
	
	private Log _log = LogFactoryUtil.getLog(this.getClass());
}
