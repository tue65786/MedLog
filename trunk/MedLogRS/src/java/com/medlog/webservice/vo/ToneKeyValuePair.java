/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.medlog.webservice.vo;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author westy
 */
public class ToneKeyValuePair implements Comparable<ToneKeyValuePair>,Serializable {

    /**
     * @return the value
     */
    public double getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(double value) {
        this.value = value;
    }

    /**
     * @return the rank
     */
    public int getRank() {
        return rank;
    }

    /**
     * @param rank the rank to set
     */
    public void setRank(int rank) {
        this.rank = rank;
    }

    /**
     * @return the weightedValue
     */
    public double getWeightedValue() {
        return weightedValue;
    }

    /**
     * @param weightedValue the weightedValue to set
     */
    public void setWeightedValue(double weightedValue) {
        this.weightedValue = weightedValue;
    }

    /**
     * @return the key
     */
    public String getKey() {
        return key;
    }

    /**
     * @param key the key to set
     */
    public void setKey(String key) {
        this.key = key;
    }

    public static ToneKeyValuePair create(final double value, final int rank, final double weightedValue, final String key) {
        return new ToneKeyValuePair(value, rank, weightedValue, key);
    }
    private double value;
    private int rank;
    private double weightedValue;
    private String key;

    public ToneKeyValuePair() {
    }

    @Override
    public int compareTo(ToneKeyValuePair that) {
    if (this.getWeightedValue()>that.getWeightedValue())return -1;
    if (this.getWeightedValue()<that.getWeightedValue())return 1;
    return 0;
    }

    public static class Builder {

        private double value;
        private int rank;
        private double weightedValue;
        private String key;

        private Builder() {
        }

        public Builder value(final double value) {
            this.value = value;
            return this;
        }

        public Builder rank(final int value) {
            this.rank = value;
            return this;
        }

        public Builder weightedValue(final double value) {
            this.weightedValue = value;
            return this;
        }

        public Builder key(final String value) {
            this.key = value;
            return this;
        }

        public ToneKeyValuePair build() {
            return ToneKeyValuePair.create(value, rank, weightedValue, key);
        }
    }

    public static ToneKeyValuePair.Builder builder() {
        return new ToneKeyValuePair.Builder();
    }

    private ToneKeyValuePair(final double value, final int rank, final double weightedValue, final String key) {
        this.value = value;
        this.rank = rank;
        this.weightedValue = weightedValue;
        this.key = key;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + (int) (Double.doubleToLongBits(this.getValue()) ^ (Double.doubleToLongBits(this.getValue()) >>> 32));
        hash = 89 * hash + (int) (Double.doubleToLongBits(this.getWeightedValue()) ^ (Double.doubleToLongBits(this.getWeightedValue()) >>> 32));
        hash = 89 * hash + Objects.hashCode(this.getKey());
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ToneKeyValuePair other = (ToneKeyValuePair) obj;
        if (Double.doubleToLongBits(this.getValue()) != Double.doubleToLongBits(other.getValue())) {
            return false;
        }
        if (Double.doubleToLongBits(this.getWeightedValue()) != Double.doubleToLongBits(other.getWeightedValue())) {
            return false;
        }
        if (!Objects.equals(this.key, other.key)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ToneKeyValuePair{" + "value=" + value + ", rank=" + rank + ", weightedValue=" + weightedValue + ", key=" + key + '}';
    }
    public String toHTML() {
        final String css = " style=\""+ (rank % 2 ==0 ? "background-color: #EEE\" ": "background-color:#FFF\" ");
        return "<tr>" + "<td" +css +">" + key  + "</td> <td" +css +">" + rank + "</td><td" 
                +css +">"+ String.format("%.4f%%",weightedValue)  + "</td><td" +css +">" + String.format("%.4f",value)  + "</td></tr>";
    }
}
