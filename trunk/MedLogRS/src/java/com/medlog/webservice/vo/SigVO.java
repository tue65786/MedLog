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

   /**
    * @return the category
    */
   public String getCategory() {
	  return category;
   }

   /**
    * @param category the category to set
    */
   public void setCategory(String category) {
	  this.category = category;
   }

   /**
    * @return the definition
    */
   public String getDefinition() {
	  return definition;
   }

   /**
    * @param definition the definition to set
    */
   public void setDefinition(String definition) {
	  this.definition = definition;
   }

   /**
    * @return the sigAbbrID
    */
   public String getSigAbbrID() {
	  return sigAbbrID;
   }

   /**
    * @param sigAbbrID the sigAbbrID to set
    */
   public void setSigAbbrID(String sigAbbrID) {
	  this.sigAbbrID = sigAbbrID;
   }

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
private String sigAbbrID;
private String definition;
private String category;
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
