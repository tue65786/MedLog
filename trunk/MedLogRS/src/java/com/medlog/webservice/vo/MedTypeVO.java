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
public class MedTypeVO implements Serializable, IEntityBase<MedTypeVO> {
private static final Logger LOG = Logger.getLogger( MedTypeVO.class.getName() );
private static final long serialVersionUID = -4600105812671714226L;

@Override
public boolean isValid() {
   throw new UnsupportedOperationException( "Not supported yet." ); //To change body of generated methods, choose Tools | Templates.
}

@Override
public boolean isValid(MedTypeVO _vo) {
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
public String medTypeID;

public static MedTypeVO GET_RX(){
   MedTypeVO vo = new MedTypeVO();
   vo.medTypeID = "RX";
   return vo;  
}
public static MedTypeVO GET_OTC(){
   MedTypeVO vo = new MedTypeVO();
   vo.medTypeID = "OTC";
   return vo;  
}

}
