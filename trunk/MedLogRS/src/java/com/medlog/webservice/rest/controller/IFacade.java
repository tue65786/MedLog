/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.medlog.webservice.rest.controller;

import java.util.*;

/**
 *
 * @author (c)2016 Guiding Technologies
 */
public abstract class IFacade<T> {

private Class<T> entityClass;
ArrayList<T> voList;

public IFacade(Class<T> entityClass, ArrayList<T> voList) {
   this.entityClass = entityClass;
   this.voList = voList;
}

/**
 *
 * @param <T>
 * @param col
 * @param predicate
 * @return
 */
public ArrayList<T> filterList(ArrayList<T> col, IPredicate<T> predicate) {
   ArrayList<T> result = new ArrayList<T>();

   for ( T element : col ) {
	  if ( predicate.apply( element ) ) {
		 result.add( element );
	  }
   }
   return result;
}

}
