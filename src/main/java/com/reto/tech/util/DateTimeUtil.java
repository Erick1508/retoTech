package com.reto.tech.util;

import org.joda.time.DateTime;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.Locale;

public class DateTimeUtil {


    public static final String DD_MM_YYYY = "dd-MM-yyyy";

    DateTimeUtil() {
        throw new IllegalStateException("Utility class");
    }

    public static String getDateDie(Date date) {
        DateFormat outputFormat = new SimpleDateFormat(DD_MM_YYYY, Locale.US);
        DateTime dtOrg = new DateTime(date);
        DateTime dtPlus = dtOrg.plusYears(80);

        return outputFormat.format(dtPlus.toDate());
    }

    public static Date getDateClient(Date date) {
        DateTime dtOrg = new DateTime(date);
        DateTime dtPlus = dtOrg.plusHours(6);
        return dtPlus.toDate();
    }

    public static String getDateFormat(Date date) {
        DateFormat outputFormat = new SimpleDateFormat(DD_MM_YYYY, Locale.US);
        DateTime dtOrg = new DateTime(date);

        return outputFormat.format(dtOrg.toDate());
    }


}
