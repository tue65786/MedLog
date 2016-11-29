/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.medlog.webservice.lifecycle;

import com.medlog.webservice.CONST.API_ACTIONS;
import static com.medlog.webservice.CONST.API_ACTIONS.API_FUNCTION_FIND;
import static com.medlog.webservice.CONST.API_ACTIONS.API_PARAM_FUNCTION;
import static com.medlog.webservice.CONST.API_ACTIONS.API_PARAM_RESOURCE;
import static com.medlog.webservice.CONST.API_ACTIONS.API_RESOURCE_PHARM;
import static com.medlog.webservice.CONST.API_ACTIONS.API_RESOURCE_SIG;
import static com.medlog.webservice.CONST.API_ACTIONS.API_RESOURCE_STATES;
import static com.medlog.webservice.CONST.SETTINGS.*;
import static com.medlog.webservice.CONST.STRINGS.*;
import com.medlog.webservice.util.*;
import com.medlog.webservice.vo.*;
import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.*;
import java.util.logging.*;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.*;
import org.apache.commons.lang3.*;

/**
 *
 * @author (c)2016 Guiding Technologies
 */
@WebFilter(filterName = "Security", urlPatterns = {"/*"})
public class Security implements Filter {

    private static final boolean debug = DEBUG;

// The filter configuration object we are associated with.  If
// this value is null, this filter instance is not currently
// configured. 
    private FilterConfig filterConfig = null;

    public Security() {
    }

    private void doBeforeProcessing(ServletRequest request, ServletResponse response)
            throws IOException, ServletException {
        if (debug) {

            log("context path: " + request.getServletContext().getContextPath());
            log("Security:DoBeforeProcessing");
        }

        // Write code here to process the request and/or response before
        // the rest of the filter chain is invoked.
        // For example, a logging filter might log items on the request object,
        // such as the parameters.
        /*
    * for (Enumeration en = request.getParameterNames(); en.hasMoreElements(); ) {
    * String name = (String)en.nextElement();
    * String values[] = request.getParameterValues(name);
    * int n = values.length;
    * StringBuffer buf = new StringBuffer();
    * buf.append(name);
    * buf.append("=");
    * for(int i=0; i < n; i++) {
    * buf.append(values[i]);
    * if (i < n-1)
    * buf.append(",");
    * }
    * log(buf.toString());
    * }
         */
    }

    private void doAfterProcessing(ServletRequest request, ServletResponse response)
            throws IOException, ServletException {
        if (debug) {
            log("Security:DoAfterProcessing");
        }

        // Write code h	 ere to process the request and/or response after
        // the rest of the filter chain is invoked.
        // For example, a logging filter might log the attributes on the
        // request object after the request has been processed. 
        /*
    * for (Enumeration en = request.getAttributeNames(); en.hasMoreElements(); ) {
    * String name = (String)en.nextElement();
    * Object value = request.getAttribute(name);
    * log("attribute: " + name + "=" + value.toString());
    *
    * }
         */
        // For example, a filter might append something to the response.
        /*
    * PrintWriter respOut = new PrintWriter(response.getWriter());
    * respOut.println("<P><B>This has been appended by an intrusive filter.</B>");
         */
    }

    /**
     *
     * @param request The servlet request we are processing
     * @param response The servlet response we are creating
     * @param chain The filter chain we are processing
     *
     * @exception IOException if an input/output error occurs
     * @exception ServletException if a servlet error occurs
     */
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httprequest = (HttpServletRequest) request;
        HttpServletResponse httpresponse = (HttpServletResponse) response;
        PatientVO user;
        boolean isLoggedIn;
        boolean shouldDeny = false;
        String uri = null;
        String file = null;

        if (DEBUG) {
            log("Security:doFilter()");
        }
        isLoggedIn = isLoggedIn(httprequest);
        if (DEBUG) {
            log(String.format("User %s", isLoggedIn ? "IS LOGGED IN!!" : " IS NOT LOGGED IN"));
        }

//   Map m = new TreeMap();
//   m.put( "URI", httprequest.getRequestURI() );
//   m.put( "URL", httprequest.getRequestURL().toString() );
//   StrUtl.toS( httprequest.getRequestURI() );
        doBeforeProcessing(request, response);
        String[] urlParts = getUriParts(httprequest);
        uri = urlParts[0];
        file = urlParts[1];
        if (!hasAccess(uri, file, httprequest)) {
            if (DEBUG) {
                log("Not logged in! Redirect");
            }
            httpresponse.sendRedirect("/MedLogRS/login.html?d=1");
        }
        Throwable problem = null;
        try {
            chain.doFilter(request, response);
        } catch (Throwable t) {
            // If an exception is thrown somewhere down the filter chain,
            // we still want to execute our after processing, and then
            // rethrow the problem after that.

            problem = t;
            t.printStackTrace();
        }

        doAfterProcessing(request, response);

        // If there was a problem, we want to rethrow it if it is
        // a known type, otherwise log it.
        if (problem != null) {
            if (problem instanceof ServletException) {
                throw (ServletException) problem;
            }
            if (problem instanceof IOException) {
                throw (IOException) problem;
            }
            sendProcessingError(problem, response);
        }
    }

    private boolean isAPIRequest(HttpServletRequest req) {
        System.out.println("com.medlog.webservice.lifecycle.Security.isAPIRequest()" + req.getRequestURI());
        String fn = "";
        if (req.getParameter(API_PARAM_FUNCTION) != null) {
            fn = req.getParameter(API_PARAM_FUNCTION);
            return true;

        }
        if (req.getParameter(API_PARAM_RESOURCE) != null) {
            return true;
        }

//        if (!StrUtl.matchOR(res, API_RESOURCE_STATES,API_RESOURCE_SIG,API_RESOURCE_PHARM)){
//            //TODO HANDLE ONLY FIND FUNCTIONS
//            return false;
//        }
        if (StrUtl.matchOR(fn, API_FUNCTION_FIND, API_ACTIONS.API_FUNCTION_INSERT, API_ACTIONS.API_FUNCTION_FIND_BY_ID, API_ACTIONS.API_FUNCTION_LOGIN, API_ACTIONS.API_FUNCTION_LOGOUT)) {
            if (req.getParameter(API_PARAM_RESOURCE) != null) {

                String res = StrUtl.toS(req.getParameter(API_PARAM_RESOURCE));

                return true;
            }

        }
        return true;
    }

    private boolean isLoggedIn(HttpServletRequest httprequest) {
        try {
            boolean ret = ((PatientVO) httprequest.getSession().getAttribute(SESSION_BEAN_USER)).getPatientID() > 0;
            if (DEBUG) {
                log(String.format("User %s", ret ? "IS LOGGED IN!!" : " IS NOT LOGGED IN"));
            }
            return ret;
        } catch (Exception e) {
            if (DEBUG) {
//	e.printStackTrace();
            }
        }
        return false;

    }

    private boolean hasAccess(String uri, String file, HttpServletRequest httprequest) {
        boolean hasAccess = isLoggedIn(httprequest) || StrUtl.regexTest(REG_EX_isNonSecurePages, StrUtl.toS(uri), true) || (!StringUtils.endsWith(uri, "html") && !StringUtils.endsWith(uri, "jsp"));
        if (DEBUG) {
            log(String.format("User %s access to %s.", hasAccess ? "HAS" : "DOES HOT HAVE", StrUtl.toS(uri)));
        }
        return hasAccess;
    }

    private String[] getUriParts(HttpServletRequest httprequest) {
        String[] ret = new String[2];
        ret[0] = StrUtl.toS(httprequest.getRequestURI());
        try {
            String file = ret[0];
            if (file.contains("/")) {
                file = file.substring(file.lastIndexOf("/") + 1, file.length());
            }
            if (file.contains("?")) {
                file = file.substring(0, file.indexOf("?"));
            }
            System.out.println("com.medlog.webservice.lifecycle.Security.getUriParts() FileName " + file);
            ret[1] = file;
        } catch (Exception e) {
            ret[1] = "";
        }
        return ret;
    }

    /**
     * Return the filter configuration object for this filter.
     */
    public FilterConfig getFilterConfig() {
        return (this.filterConfig);
    }

    /**
     * Set the filter configuration object for this filter.
     *
     * @param filterConfig The filter configuration object
     */
    public void setFilterConfig(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
    }

    /**
     * Destroy method for this filter
     */
    public void destroy() {
    }

    /**
     * Init method for this filter
     */
    public void init(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
        if (filterConfig != null) {
            if (debug) {
                log("Security:Initializing filter");
            }
        }
    }

    /**
     * Return a String representation of this object.
     */
    @Override
    public String toString() {
        if (filterConfig == null) {
            return ("Security()");
        }
        StringBuffer sb = new StringBuffer("Security(");
        sb.append(filterConfig);
        sb.append(")");
        return (sb.toString());
    }

    private void sendProcessingError(Throwable t, ServletResponse response) {
        String stackTrace = getStackTrace(t);

        if (stackTrace != null && !stackTrace.equals("")) {
            try {
                response.setContentType("text/html");
                PrintStream ps = new PrintStream(response.getOutputStream());
                PrintWriter pw = new PrintWriter(ps);
                pw.print("<html>\n<head>\n<title>Error</title>\n</head>\n<body>\n"); //NOI18N

                // PENDING! Localize this for next official release
                pw.print("<h1>The resource did not process correctly</h1>\n<pre>\n");
                pw.print(stackTrace);
                pw.print("</pre></body>\n</html>"); //NOI18N
                pw.close();
                ps.close();
                response.getOutputStream().close();
            } catch (Exception ex) {
            }
        } else {
            try {
                PrintStream ps = new PrintStream(response.getOutputStream());
                t.printStackTrace(ps);
                ps.close();
                response.getOutputStream().close();
            } catch (Exception ex) {
            }
        }
    }

    public static String getStackTrace(Throwable t) {
        String stackTrace = null;
        try {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            t.printStackTrace(pw);
            pw.close();
            sw.close();
            stackTrace = sw.getBuffer().toString();
        } catch (Exception ex) {
        }
        return stackTrace;
    }

    public void log(String msg) {
        filterConfig.getServletContext().log(msg);
    }
    private static final Logger LOG = Logger.getLogger(Security.class.getName());

}
