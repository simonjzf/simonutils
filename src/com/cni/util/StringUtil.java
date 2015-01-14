package com.cni.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class StringUtil {

	public static String getSimpleDateFormat(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(date).toString();
	}

	public static String getSimpleDateFormats(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(date).toString();
	}

	public static String getSimpleDateFormatd(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-");
		return sdf.format(date).toString();
	}

	public static String getSimpleDateFormaty(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-");
		return sdf.format(date).toString();
	}

	public static int getDayOfWeek(String pTime) throws Exception {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		c.setTime(format.parse(pTime));
		int dayForWeek = 0;
		if (c.get(Calendar.DAY_OF_WEEK) == 1) {
			dayForWeek = 7;
		} else {
			dayForWeek = c.get(Calendar.DAY_OF_WEEK) - 1;
		}
		return dayForWeek;
	}

	public static String getNextDate(Date date) {
		String str = StringUtil.getSimpleDateFormats(date);
		int intYear = Integer.parseInt(str.substring(0, 4));
		int intMonth = Integer.parseInt(str.substring(5, 7));
		int intDate = Integer.parseInt(str.substring(8, 10));

		Calendar cal = Calendar.getInstance();
		cal.set(intYear, intMonth - 1, intDate);
		cal.add(Calendar.DATE, +1);
		Date d = cal.getTime();
		String s = StringUtil.getSimpleDateFormats(d);

		return s;
	}

	public static String getOtType(int dayofweek) {
		if (dayofweek <= 5) {
			return "A";
		} else if (dayofweek == 6 || dayofweek == 7) {
			return "B";
		} else {
			return null;
		}

	}

	public static Date getDateFromString(String dateId) {
		if (dateId.equalsIgnoreCase("")) {
			return null;
		} else {
			SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
			try {
				Date date = f.parse(dateId);
				return date;
			} catch (ParseException e) {
				e.printStackTrace();
				return null;
			}
		}
	}

	public static String getRandomString(int length) {
		final String STR = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!";
		StringBuffer sb = new StringBuffer();

		for (int i = 0; i < length; i++) {
			Random rand = new Random();
			sb.append(Character.toString(STR.charAt(rand.nextInt(63))));
		}

		return sb.toString();
	}

	public static String getRandomStringContainDateInfo(int length) {
		final String STR = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!";
		StringBuffer sb = new StringBuffer();

		for (int i = 0; i < length; i++) {
			Random rand = new Random();
			sb.append(Character.toString(STR.charAt(rand.nextInt(63))));
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss-");

		return sdf.format(new Date()).toString() + sb.toString();

	}

	public static List<String> getDateStringBetweenDateStringZone(
			String dateId1, String dateId2) {
		List<String> zone = new ArrayList<String>();
		Date temp = StringUtil.getDateFromString(dateId1);
		Date end = StringUtil.getDateFromString(dateId2);
		while (temp.before(end)) {
			zone.add(StringUtil.getSimpleDateFormats(temp));
			temp.setTime(temp.getTime() + 1000 * 3600 * 24);
		}
		zone.add(StringUtil.getSimpleDateFormats(StringUtil.getDateFromString(dateId2)));
		return zone;
	}

}
