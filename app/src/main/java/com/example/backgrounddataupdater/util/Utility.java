package com.example.backgrounddataupdater.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utility {
    public static SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
    public static SimpleDateFormat dateFormatter1 = new SimpleDateFormat("yyyy-MM-dd");

    public static int tryParseInt(String value, int defaultValue) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }
public static String convertDate(String date){
        String result ="";
    try {
        Date d = dateFormatter.parse(date);
        result = dateFormatter1.format(d);

    } catch (ParseException e) {
        e.printStackTrace();
    }
return result;
}

public static String convertDate(Date date){
        String result ="";
        // Date d = dateFormatter.parse(date);
        result = dateFormatter1.format(date);

        return result;
}

    public static boolean isValidText(String text) {
        if (text.length() < 7) {
            return false;
        } else if (text.length() == 7) {
            try {
                Integer.parseInt(text);
                return true;
            } catch (Exception e) {
                return false;
            }
        } else if (text.length() == 10) {
            return true;
        } else {
            return false;
        }
    }

}
