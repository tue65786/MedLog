/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.medlog.webservice.vo;

/**
 *
 * @author (c)2016 Guiding Technologies
 * @param <VO>
 */
public interface IEntityBase <VO> {

public String toTableRow();

public String toJSON();

public boolean isValid();
public boolean isValid(VO vo);
public boolean isValid(int ACTION);
}
