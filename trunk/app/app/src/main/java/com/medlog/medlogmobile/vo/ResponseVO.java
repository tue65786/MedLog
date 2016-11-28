package com.medlog.medlogmobile.vo;

import com.medlog.medlogmobile.util.Helpers;

import java.io.Serializable;

/**
 * Created by westy on 11/23/2016.
 */

public class ResponseVO implements Serializable{
    private String state;
    private String message;

    public ResponseVO(String state, String message) {
        this.state = state;
        this.message = message;
    }

    public ResponseVO() {
    }

    @Override
    public String toString() {
        return "ResponseVO{" +
                "state='" + getState() + '\'' +
                ", message='" + getMessage() + '\'' +
                '}';
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = Helpers.toS(state,"unknonw");
    }

    public String getMessage() {
        return Helpers.toS(message,"???");
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
