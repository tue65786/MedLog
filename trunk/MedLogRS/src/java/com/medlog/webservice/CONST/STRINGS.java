/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.medlog.webservice.CONST;

import java.util.logging.*;
import java.util.regex.*;

/**
 *
 * @author (c)2016 Guiding Technologies
 */
public class STRINGS {

/**
 *
 */
public static final String REG_EX_email = "[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?";
/**
 * When matched anonymous users can acccess page.
 */
public static final String REG_EX_isNonSecurePages = "(User\\.htm|login\\.htm)";

private static final Logger LOG = Logger.getLogger( STRINGS.class.getName() );
/**
 * No instantiate.
 */
private STRINGS() {

}  
}
