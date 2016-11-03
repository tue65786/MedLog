/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package com.medlog.webservice.rest.controller;

import com.medlog.webservice.vo.*;
import java.util.*;
import java.util.logging.*;


public class SigFacadeImpl extends IFacade<SigVO> {

   /**
    *
    * @param _entityClass
    */
   public SigFacadeImpl(Class<SigVO> _entityClass, ArrayList<SigVO> voList) {
	  super( _entityClass,voList );
   }
   
   public ArrayList<SigVO> getPrimarySigs(){
	  IPredicate<SigVO> filt = new IPredicate<SigVO>() {
		 @Override
		 public boolean apply(SigVO _type) {
			return (_type != null && _type.getCategory().equalsIgnoreCase( "time"));
		 }
	  };
	  return filterList( this.voList, filt);
   }

   private static final Logger LOG = Logger.getLogger( SigFacadeImpl.class.getName() );
   
   
   
   
   
   

}
