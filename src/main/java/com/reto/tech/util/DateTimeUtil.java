package com.reto.tech.util;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeUtil {


    DateTimeUtil() {
        throw new IllegalStateException("Utility class");
    }

    public static Timestamp getDate(String sDate1) {
        try {
            Date date1 =new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Date date = new Date();
        return new Timestamp(date.getTime());
    }

    public static String getDateTimeFormatInvoice(String date) {
        SimpleDateFormat fromUnifier = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss");
        SimpleDateFormat formatInvoice = new SimpleDateFormat("dd-MM-yyyy");
        String reformattedStr ="";
        try {
            reformattedStr = formatInvoice.format(fromUnifier.parse(date));
        } catch (ParseException e) {
            e.getMessage();
        }
        return reformattedStr;
    }
}
