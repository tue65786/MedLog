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
public class DietaryRestrictionVO implements Serializable, IEntityBase<DietaryRestrictionVO> {

private static final long serialVersionUID = -1555382307773210788L;

@Override
public boolean isValid() {
   throw new UnsupportedOperationException( "Not supported yet." ); //To change body of generated methods, choose Tools | Templates.
}

@Override
public boolean isValid(DietaryRestrictionVO _vo) {
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
public int dietaryRestrictionID;
public String name;
public String restrictions;
private static final Logger LOG = Logger.getLogger( DietaryRestrictionVO.class.getName() );
}
