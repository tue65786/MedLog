/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.medlog.webservice.vo;

import java.io.*;

/**
 *
 * @author (c)2016 Guiding Technologies
 */
public class DietaryRestrictionVO implements Serializable, IEntityBase<DietaryRestrictionVO> {
public int dietaryRestrictionID;
public String name;
public String restrictions;
}
