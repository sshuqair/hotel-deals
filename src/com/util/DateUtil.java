package com.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DateUtil {
	
	public static Date getDate(List<Integer> dateList) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(dateList.get(0), dateList.get(1) - 1, dateList.get(2));
		
		return calendar.getTime();
	}
	
	public static Date parseDate(String dateStr) {
		if(dateStr == null || dateStr.isEmpty()) {
			return null;
		}
				
		try {
			SimpleDateFormat toStringFormat = new SimpleDateFormat("EEE MMM dd hh:mm:ss zzz yyyy");
			Date originaldate = toStringFormat.parse(dateStr);
									
			return originaldate; 
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static boolean compareLessOrEqual(Date startDate, Date endDate) {
		if (startDate.compareTo(endDate) <= 0) {
			return true;
        } 
		return false;
	}
	public static boolean compareGreaterOrEqual(Date startDate, Date endDate) {
		if (startDate.compareTo(endDate) >= 0) {
			return true;
        } 
		return false;
	}
	public static String getDateAsString(Date date) {
		if(date == null) {
			return null;
		}
		return new SimpleDateFormat("yyyy-MM-dd").format(date);
	}
	
	public static String formatDate(Date date) {
		if(date == null) {
			return null;
		}
				
		SimpleDateFormat toStringFormat = new SimpleDateFormat("EEE MMM dd hh:mm:ss zzz yyyy");
		return toStringFormat.format(date);
	}
	
	
}
