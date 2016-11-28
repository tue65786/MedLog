package com.medlog.webservice.util;

public class ValidationUtils {
    /* Convert "val" (String) to Integer and return the converted Integer. */
    public static Integer integerConversion(String val) {

        if ((val == null) || (val.length() == 0)) {
            return null;
        }
        try {
            return new Integer(val);
        } catch (Exception e) {
            System.out.println("ValidationUtils.integerConversion(): cannot convert " + val + " to Integer.");
            return null;
        }
    } // integerConversion()
}
