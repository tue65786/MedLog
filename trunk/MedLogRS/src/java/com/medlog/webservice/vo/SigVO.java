/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package com.medlog.webservice.vo;

import java.io.*;
import java.util.logging.*;

/**
 *
 * @author (c)2016 Guiding Technologies
 */
public class SigVO  implements Serializable, IEntityBase<SigVO> {

   private static final long serialVersionUID = -7174641424768405074L;

   @Override
   public boolean isValid() {
	  throw new UnsupportedOperationException( "Not supported yet." ); //To change body of generated methods, choose Tools | Templates.
   }

   @Override
   public boolean isValid(SigVO _vo) {
	  throw new UnsupportedOperationException( "Not supported yet." ); //To change body of generated methods, choose Tools | Templates.
   }

   @Override
   public boolean isValid(int _ACTION) {
	  throw new UnsupportedOperationException( "Not supported yet." ); //To change body of generated methods, choose Tools | Templates.
   }

   @Override
   public String toJSON() {
	  throw new UnsupportedOperationException( "Not supported yet." ); //To change body of generated methods, choose Tools | Templates.
   }

   @Override
   public String toTableRow() {
	  throw new UnsupportedOperationException( "Not supported yet." ); //To change body of generated methods, choose Tools | Templates.
   }
public String sigAbbrID;
public String definition;
public String category;
   public static class Builder {

   private String sigAbbrID;
   private String definition;
   private String category;

   private Builder() {
   }

   public Builder sigAbbrID(final String value) {
	  this.sigAbbrID = value;
	  return this;
   }

   public Builder definition(final String value) {
	  this.definition = value;
	  return this;
   }

   public Builder category(final String value) {
	  this.category = value;
	  return this;
   }

   public SigVO build() {
	  return new com.medlog.webservice.vo.SigVO( sigAbbrID, definition, category );
   }
   }

   public static SigVO.Builder builder() {
	  return new SigVO.Builder();
   }

   public SigVO(final String sigAbbrID, final String definition, final String category) {
	  this.sigAbbrID = sigAbbrID;
	  this.definition = definition;
	  this.category = category;
   }

   private static final Logger LOG = Logger.getLogger( SigVO.class.getName() );
}
