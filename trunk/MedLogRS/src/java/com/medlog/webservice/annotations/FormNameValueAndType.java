/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.medlog.webservice.annotations;

import java.lang.annotation.*;
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Documented
/**
 *
 * @author (c)2016 
 */
public @interface FormNameValueAndType {


    /**
     *
     * @return if field is ID
     */
    public boolean isPK() default false;

    /**
     *
     * @return if field is Name
     */
    public boolean isName() default false;
	
	public String formFieldType() default "text";
}


