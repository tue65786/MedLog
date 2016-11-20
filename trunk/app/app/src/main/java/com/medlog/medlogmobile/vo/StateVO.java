package com.medlog.medlogmobile.vo;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by Dan on 11/20/2016.
 */

public class StateVO implements Serializable, Parcelable {
    private int stateID;
    private String stateName;
    private String stateAbbreviation;

    @Override
    public String toString() {
        return new org.apache.commons.lang.builder.ToStringBuilder(this)
                .append("stateID", stateID)
                .append("stateName", stateName)
                .append("stateAbbreviation", stateAbbreviation)
                .toString();
    }

    public int getStateID() {
        return stateID;
    }

    public void setStateID(int stateID) {
        this.stateID = stateID;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getStateAbbreviation() {
        return stateAbbreviation;
    }

    public void setStateAbbreviation(String stateAbbreviation) {
        this.stateAbbreviation = stateAbbreviation;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.stateID);
        dest.writeString(this.stateName);
        dest.writeString(this.stateAbbreviation);
    }

    public StateVO() {
    }

    protected StateVO(Parcel in) {
        this.stateID = in.readInt();
        this.stateName = in.readString();
        this.stateAbbreviation = in.readString();
    }

    public static final Parcelable.Creator<StateVO> CREATOR = new Parcelable.Creator<StateVO>() {
        public StateVO createFromParcel(Parcel source) {
            return new StateVO(source);
        }

        public StateVO[] newArray(int size) {
            return new StateVO[size];
        }
    };

}
