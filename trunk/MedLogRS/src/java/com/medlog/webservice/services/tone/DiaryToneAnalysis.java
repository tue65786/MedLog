/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.medlog.webservice.services.tone;

import java.io.Serializable;

/**
 *
 * @author westy
 */
  
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
@Deprecated
public class DiaryToneAnalysis implements Serializable{

        private static final long serialVersionUID = -8711974988379436489L;

        
@SerializedName("document_tone")
@Expose
public DocumentTone documentTone;
//@SerializedName("sentences_tone")
//@Expose
//public ArrayList<SentencesTone> sentencesTone;  
    }
