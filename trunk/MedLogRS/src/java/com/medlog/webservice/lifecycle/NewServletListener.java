/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.medlog.webservice.lifecycle;

import java.util.logging.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.commons.lang3.builder.*;

/**
 * Web application lifecycle listener.
 *
 * @author (c)2016 Guiding Technologies
 */
public class NewServletListener implements ServletContextListener, ServletContextAttributeListener, HttpSessionListener {

@Override
public void attributeAdded(ServletContextAttributeEvent _event) {
   System.out.println( "com.medlog.webservice.lifecycle.NewServletListener.attributeAdded()" );
   logit(_event,"added");
   
}

@Override
public void attributeRemoved(ServletContextAttributeEvent _event) {
   
   System.out.println( "com.medlog.webservice.lifecycle.NewServletListener.attributeRemoved()" );
   logit(_event,"removed");
}

@Override
public void attributeReplaced(ServletContextAttributeEvent _arg0) {
   System.out.println( "com.medlog.webservice.lifecycle.NewServletListener.attributeReplaced()" );
   logit(_arg0,"replaced");
}

private void logit(ServletContextAttributeEvent e, String event) {
try{
   LOG.info( String.format("%s created %s=&s %s to context", e.getSource().getClass().getName(), e.getName(), e.getValue().toString(), event ) );
}catch(Exception ee){ee.printStackTrace();}
   
}

   


@Override
public void contextDestroyed(ServletContextEvent _sce) {

}

@Override
public void contextInitialized(ServletContextEvent _sce) {
   LOG.log( Level.INFO, String.format( "com.medlog.webservice.lifecycle.NewServletListener.contextInitialized() %s ", _sce.getServletContext().getContextPath() ) );
   _sce.getServletContext().setAttribute( "activeLogins", 0 );

}

@Override
public void sessionCreated(HttpSessionEvent _se) {
   Integer activeUsers = (Integer) _se.getSession().getServletContext().getAttribute( "activeLogins" );
   if ( activeUsers == null ) {
	  LOG.warning( "Active Users NULL!" );
	  activeUsers = 1;
   } else {
	  activeUsers++;
   }

   _se.getSession().getServletContext().setAttribute( "activeLogins", activeUsers );

   LOG.info( "com.medlog.webservice.lifecycle.NewServletListener.sesionCreated()" );
   System.out.println( "com.medlog.webservice.lifecycle.NewServletListener.sessionCreated() Users online: " + activeUsers );

}

@Override
public void sessionDestroyed(HttpSessionEvent _se) {
   Integer activeUsers = (Integer) _se.getSession().getServletContext().getAttribute( "activeLogins" );
   if ( activeUsers == null ) {
	  LOG.warning( "Active Users NULL!" );
	  activeUsers = 0;
   } else {
	  activeUsers--;
   }
   _se.getSession().getServletContext().setAttribute( "activeLogins", activeUsers );
   LOG.info( "com.medlog.webservice.lifecycle.NewServletListener.sesionDestroyed()" );
   System.out.println( "com.medlog.webservice.lifecycle.NewServletListener.sessionDestoyed() Users online: " + activeUsers );

}
private static final Logger LOG = Logger.getLogger( NewServletListener.class.getName() );
}
