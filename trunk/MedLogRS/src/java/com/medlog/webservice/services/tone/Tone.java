/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.medlog.webservice.services.tone;

import com.google.gson.annotations.SerializedName;

/**
 *
 * @author westy
 */
@Deprecated
public class Tone {
    
  @SerializedName("tone_id")
  private String id;

  @SerializedName("tone_name")
  private String name;

  /** The score. */
  private Double score;
  
  public Tone(){
      
  }

    public Tone(com.ibm.watson.developer_cloud.tone_analyzer.v3.model.Tone id, String name, Double score) {
//        this.id = id;
        this.name = name;
        this.score = score;
    }
  
}
