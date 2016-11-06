/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.medlog.webservice.util;

/**
 *
 * @author (c)2016 Guiding Technologies
 */
public class HTMLUtils {

private HTMLUtils() {

}

public static String makeButton(int key, String name, String cssClass, String value) {
   return "<input type=\"text\" class=\"" + cssClass + "\" value=\"" + value + "\" id=\"" + key + "\" />";
}

}
