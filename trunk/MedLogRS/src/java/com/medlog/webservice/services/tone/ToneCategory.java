/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.medlog.webservice.services.tone;

import com.ibm.watson.developer_cloud.personality_insights.v3.model.Profile;
import com.ibm.watson.developer_cloud.tone_analyzer.v3.model.ToneAnalysis;
import java.io.Serializable;

/**
 * Wrapper for analysis.
 * @author westy
 */
public class ToneCategory implements Serializable{

    public static ToneCategory create(final ToneAnalysis tone, final Profile profile) {
        return new ToneCategory(tone, profile);
    }

    /**
     * @return the tone
     */
    public ToneAnalysis getTone() {
        return tone;
    }

    /**
     * @param tone the tone to set
     */
    public void setTone(ToneAnalysis tone) {
        this.tone = tone;
    }

    /**
     * @return the profile
     */
    public Profile getProfile() {
        return profile;
    }

    /**
     * @param profile the profile to set
     */
    public void setProfile(Profile profile) {
        this.profile = profile;
    }
         private ToneAnalysis tone = null;
        private Profile profile = null;

    public static class Builder {

        private ToneAnalysis tone;
        private Profile profile;

        private Builder() {
        }

        public Builder tone(final ToneAnalysis value) {
            this.tone = value;
            return this;
        }

        public Builder profile(final Profile value) {
            this.profile = value;
            return this;
        }

        public ToneCategory build() {
            return ToneCategory.create(tone, profile);
        }
    }

    public static ToneCategory.Builder builder() {
        return new ToneCategory.Builder();
    }

    private ToneCategory(final ToneAnalysis tone, final Profile profile) {
        this.tone = tone;
        this.profile = profile;
    }
}
