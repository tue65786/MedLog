/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.medlog.webservice.util;

import com.google.gson.*;
import static com.medlog.webservice.CONST.SETTINGS.*;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.logging.*;
import java.util.regex.*;

/**
 *
 * @author (c)2016 Guiding Technologies
 */
public class StrUtl {

    private static final String REGEX_HTML_MARKUP_CHARS = "\r\n|\r|\n|\t|<sty.*<.*>|<scr.*/script>|</?[a-z][a-z0-9]*[^<>]*>|<!--.*?-->|\\f|;";

    /**
     * No instantiation.
     */
    private StrUtl() {

    }

    /**
     * get Json
     *
     * @param state
     * @param msg
     * @return
     */
    public static String getJSONMsg(String state, String msg) {
        return StrUtl.getJSONMsg(state, msg, null);
    }

    /**
     * Get JSON
     *
     * @param state info error
     * @param msg
     * @return
     */
    public static String getJSONMsg(String state, String msg, Integer val) {
        JsonObject json = new JsonObject();

        json.addProperty("state", StrUtl.toS(state));
        json.addProperty("message", StrUtl.toS(msg, state.equals("error") ? "Something went wrong!" : "Unknown"));
        if (val != null) {
            json.addProperty("id", val);
        }
        return json.toString();
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
     * @param source input
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
            } catch (Exception ex) {
            }
        } catch (Exception ex) {
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
     *
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
     *
     * @param x val to look for
     * @param vals a csv param
     * @return true if found, uot found or error = false
     */
    public static boolean matchOR(int x, int... vals) {
        if (vals == null) {
            return false;
        }
        for (int i : vals) {
            if (x == i) {
                return true;
            }
        }
        return false;
    }

    /**
     *
     * @param valueToMatch
     * @param vals
     * @return
     */
    public static boolean matchOR(Boolean valueToMatch, boolean... vals) {
        if (vals == null || valueToMatch == null) {
            return false;
        }
        for (boolean i : vals) {
            if (valueToMatch == i) {
                return true;
            }

        }
        return false;
    }

    public static boolean matchOR(String x, String... vals) {
        if (vals == null || x == null) {
            return false;
        }
        for (String i : vals) {
            if (x.equalsIgnoreCase(StrUtl.toS(i))) {
                return true;
            }
        }
        return false;
    }

    /**
     * Stores stack track as String
     *
     * @param exception Thrown
     * @return String containing stack trace.
     */
    public static final String throwableStackTraceToString(final Throwable exception) {
        if (exception != null) {

            final StringWriter stringWriter = new StringWriter();
            exception.printStackTrace(new PrintWriter(stringWriter));
            return stringWriter.toString();
        } else {
            LOG.warning("Exception null printing stack track");
            return "";
        }
    }

    /**
     *
     * @param e
     * @return
     */
    public static final String stackStraceAsStringDetails(final Throwable e) {
        StringBuilder sb = new StringBuilder("");
        if (e != null) {
            final StringWriter stringWriter = new StringWriter();
            try {
                e.printStackTrace(new PrintWriter(stringWriter));
                sb.append(stringWriter.toString());
                sb.append("\nCause:");
                sb.append(e);
                Throwable t = e.getCause();
                while (t != null) {
                    sb.append(t);
                    sb.append("\n");
                    t = t.getCause();
                }
            } catch (Exception exc) {
                sb.append(e.getMessage());
            } finally {
                return StrUtl.toS(sb.toString(), "Sorry.. full stack trace not available");
            }

        } else {
            LOG.warning("Exception null printing stack track");
            return "Null exception";
        }
    }
    private static final Logger LOG = Logger.getLogger(StrUtl.class.getName());

    /**
     *
     * @param input
     * @param length
     * @return
     */
    public static String truncateAtWord(String input, int length) {
        int offset;
        int iNextSpace;
        offset = 1;
        if (input == null || input.length() < (length - offset)) {
            return StrUtl.toS(input);
        }
        iNextSpace = input.lastIndexOf(" ", length);
        String trunc = input;
        try {
            trunc = String.format(input
                    .substring(0, (iNextSpace > 0) ? iNextSpace : (length - offset))
                    .trim());
            return trunc;
        } catch (Exception e) {
            return StrUtl.toS(trunc).trim();
        }
    }

    /**
     *
     * @param REGEX String expression
     * @param valvalue to check
     * @param partialMatch allow partial match.
     * @return found
     */
    public static boolean regexTest(String REGEX, String val, boolean partialMatch) {
        boolean foundMatch = false;
        try {
            Pattern regex = Pattern.compile(REGEX, Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE | Pattern.COMMENTS);
            Matcher regexMatcher = regex.matcher(StrUtl.toS(val));
            foundMatch = partialMatch ? regexMatcher.find() : regexMatcher.matches();
        } catch (PatternSyntaxException e) {
            if (DEBUG) {
                e.printStackTrace();
            }

        } catch (IllegalArgumentException e) {
            if (DEBUG) {
                e.printStackTrace();
            }

        }
        return foundMatch;
    }

    /**
     * Return format date with specified format.
     *
     * @param n date
     * @param format date format
     * @return
     */
    public static String getDateWithFormat(Date n, String format) {
        if (n == null) {
            if (DEBUG) {
                System.out.println("com.medlog.webservice.util.StrUtl.getDateWithFormat() : Null Date");
                return "";
            }

        }
        DateFormat d = new SimpleDateFormat(format);
        d.setTimeZone(TimeZone.getTimeZone("EST"));
        return d.format(n);
    }

    /**
     * Format date as string
     *
     * @param n datte
     * @return date format yyyy--MM--dd
     */
    public static String getDateWithFormat(Date n) {
        return StrUtl.getDateWithFormat(n, "yyyy-MM-dd");

    }
}
