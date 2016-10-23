/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.medlog.webservice.rest;

import com.medlog.webservice.rest.helpers.*;
import com.medlog.webservice.vo.*;
import java.util.logging.*;
import javax.servlet.http.*;

/**
 * Strategies for connecting to data.
 * @author (c)2016
 */
public class MedLogControllerStrategy {

private static final Logger LOG = Logger.getLogger( MedLogControllerStrategy.class.getName() );

public MedLogControllerStrategy(HttpServletRequest _request, HttpServletResponse _response) {
   this.request = _request;
   this.response = _response;
   this.session = request.getSession();
}

/**
 * Current Request.
 */
private final HttpServletRequest request;
/**
 * Current Response.
 */
private final HttpServletResponse response;
/**
 * Session state.
 */
private final HttpSession session;
public DiaryVO loadDiaryFromRequest(){
  DiaryVO vo = null;
  ServletHelpers sh = new ServletHelpers(request, response );

  
 return vo;
}
}
