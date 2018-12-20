package fi.kela.drools.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateHelper {
    public static String sFormat = "yyyy-MM-dd";
	public static SimpleDateFormat defaultSdf = new SimpleDateFormat(sFormat);

    public static Date getDate(String sDate) {
        try {
        	return defaultSdf.parse(sDate);
        } catch (Exception e) {
        	return null;
        }
    }

    public static Date getDate(String sDate, String anotherFormat)
            throws Exception {
    	SimpleDateFormat sdf = new SimpleDateFormat(anotherFormat);
        try {
        	return sdf.parse(sDate);
        } catch (Exception e) {
        	return null;
        }
    }
}