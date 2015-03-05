package iss.TourRecommendation.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TourUtil {

	public static String getFestival(Date date1) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date newYearLow = sdf.parse("2016-01-01");
			Date newYearHigh = sdf.parse("2015-12-31");

			Date christmasLow = sdf.parse("2015-12-19");
			Date christmasHigh = sdf.parse("2015-12-25");

			Date huriyaLow;
			Date huriyaHigh;

			Date lunarLow;
			Date lunarHigh;

			Date deewaliLow;
			Date deewaliHigh;

			Date date2 = sdf.parse("2010-01-31");

			if ((date1.compareTo(newYearLow) >= 0)
					&& (date1.compareTo(newYearHigh) <= 0))
				return "newyear";

		} catch (Exception e) {
			// TODO: handle exception
		}
		return "";
	}

	public static int getBudgetRange(int number) {
		if (number > 0 && number < 20)
			return 1;
		else if (number >= 20 && number < 35)
			return 2;
		else
			return 3;
	}

}
