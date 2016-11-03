/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.medlog.webservice.rest.controller;

/**
 *
 * @author (c)2016 Guiding Technologies
 */
public interface IPredicate<T> {

    /**

     @param type
     @return
     */
    boolean apply(T type);

}
