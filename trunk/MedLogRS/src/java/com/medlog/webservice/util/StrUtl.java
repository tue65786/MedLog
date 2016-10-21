/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package com.medlog.webservice.util;

import java.util.regex.*;

/**
 *
 * @author (c)2016 Guiding Technologies
 */
public class StrUtl {
private static final String REGEX_HTML_MARKUP_CHARS = "<sty.*<.*>|<scr.*/script>|</?[a-z][a-z0-9]*[^<>]*>|<!--.*?-->";
/**
 * No instantiation.
 */
private StrUtl(){
   
}
	/**
	 * Safe toString method that converts nulls to empty strings.
	 *
	 * @param source
	 * @return source or ""
	 */
	public static String toS(final Object source) {
		return source == null ? "" : source.toString().trim();
	}

	/**
	 * Safe toString method with default value.
	 *
	 * @param source     input
	 * @param defaultVal value to return if source is null
	 * @return input or default value if input is null
	 */
	public static String toS(final Object source,
							 String defaultVal) {
		try {
			return (source == null || source.toString().isEmpty())
					? toS(defaultVal) : toS(source.toString()).trim();
		} catch (Exception e) {
			return defaultVal;
		}
	}

	/**
	 * Converts int to String (if value is 0, returns empty string)
	 *
	 * @param source
	 * @return
	 */
	public static String toS(final int source) {
		return source == 0 ? "" : String.valueOf(source);
	}
	/**
	 * Removes all html tags from string
	 *
	 * @param val
	 * @return
	 */
	public static String removeHtmlMarkups(String val) {
		String clean = "";
		try {
			Pattern pattern = Pattern.compile(REGEX_HTML_MARKUP_CHARS,
					Pattern.DOTALL | Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
			Matcher matcher = pattern.matcher(val);
			try {
				clean = matcher.replaceAll("");
			} catch (IllegalArgumentException ex) {
			} catch (IndexOutOfBoundsException ex) {
			}
		} catch (PatternSyntaxException ex) {
		}//
		return toS(clean);
	}

	/**
	 * HTML Encodes markup characters.
	 *
	 * @param src
	 * @return
	 */
	public static String replaceEntities(String src) {
		src = src.replace("&", "&amp;");
		src = src.replace("<", "&lt;");
		src = src.replace(">", "&gt;");
		src = src.replace("\"", "&quot;");

		return src;
	}
	
	/**
	 * Find first non-null and non-empty item
	 * @param items
	 * @return First matched String or else empty string
	 */
	public static String coalesce(Object... items) {
		if (items == null) {
			return "";
		}
		for (Object item : items) {
			if (item != null && ((String) item).length() > 0) {
				return item.toString();
			}
		}
		return "";
	}
	
/**
 * Check if x is in the set vals
 * @param x val to look for
 * @param vals a csv param
 * @return  true if found, uot found or error = false
 */
     public static boolean matchOR ( int x, int... vals){
      if ( vals == null ) {
         return false;
      }
      for (int i : vals) {
         if (x == i){ 
            return true;
         }
      }
      return false;
   }/**
    * 
    * @param valueToMatch
    * @param vals
    * @return 
    */
     public static boolean matchOR ( Boolean valueToMatch, boolean... vals){
      if ( vals == null || valueToMatch == null) {
         return false;
      }
      for (boolean i : vals) {
        if (valueToMatch == i){
           return true;
      }
      
   }return false;
}
   public static boolean matchOR ( String x, String... vals){
      if ( vals == null || x == null) {
         return false;
      }
      for (String i : vals) {
         if ( x.equalsIgnoreCase(StrUtl.toS(i)) ) { 
            return true;
         }
      }
      return false;
   }


}
