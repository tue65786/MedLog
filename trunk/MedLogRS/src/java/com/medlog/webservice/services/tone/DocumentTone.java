/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.medlog.webservice.services.tone;

/**
 *
 * @author westy
 */

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
@Deprecated
public class DocumentTone {

@SerializedName("tone_categories")
@Expose
public List<Tone> emotionCategories;

public List<Tone> socialCategories;
public List<Tone> languageCategories;


}
