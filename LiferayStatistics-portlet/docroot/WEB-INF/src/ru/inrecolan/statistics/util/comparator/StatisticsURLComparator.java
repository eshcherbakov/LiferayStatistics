package ru.inrecolan.statistics.util.comparator;

import ru.inrecolan.statistics.model.Statistics;
import ru.inrecolan.statistics.search.StatisticsDisplayTerms;
import com.liferay.portal.kernel.util.OrderByComparator;

public class StatisticsURLComparator extends OrderByComparator {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final String ORDER_BY_ASC = "Statistics.url ASC";

	public static final String ORDER_BY_DESC = "Statistics.url DESC";

	public static final String[] ORDER_BY_FIELDS = {StatisticsDisplayTerms.URL};

	public StatisticsURLComparator() {
		this(false);
	}

	public StatisticsURLComparator(boolean ascending) {
		_ascending = ascending;
	}

	@Override
	public int compare(Object obj1, Object obj2) {
		Statistics statistics1 = (Statistics)obj1;
		Statistics statistics2 = (Statistics)obj2;

		int value = statistics1.getUrl().toLowerCase().compareTo(statistics2.getUrl().toLowerCase());

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
