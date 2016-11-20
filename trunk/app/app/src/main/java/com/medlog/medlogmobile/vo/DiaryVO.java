package com.medlog.medlogmobile.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Dan on 11/20/2016.
 */

public class DiaryVO implements Serializable {
    private int id;
    private String title;
    private String notes;
    private String notesActivity;
    private Date createdDate;
    private Date updatedDate;
    private String includeMedsCurrent;
    private String attachmentPath;
    private int mood;
    private int productivity;


    public static DiaryVO create(final int id, final String title, final String notes, final String notesActivity, final Date createdDate, final Date updatedDate, final String includeMedsCurrent, final String attachmentPath, final int mood, final int productivity) {
        return new DiaryVO( id, title, notes, notesActivity, createdDate, updatedDate, includeMedsCurrent, attachmentPath, mood, productivity);
    }
    public static class Builder {

        private int id;
        private String title;
        private String notes;
        private String notesActivity;
        private Date createdDate;
        private Date updatedDate;
        private String includeMedsCurrent;
        private String attachmentPath;
        private int mood;
        private int productivity;

        private Builder() {
        }

        public Builder id(final int value) {
            this.id = value;
            return this;
        }

        public Builder title(final String value) {
            this.title = value;
            return this;
        }

        public Builder notes(final String value) {
            this.notes = value;
            return this;
        }

        public Builder notesActivity(final String value) {
            this.notesActivity = value;
            return this;
        }

        public Builder createdDate(final Date value) {
            this.createdDate = value;
            return this;
        }

        public Builder updatedDate(final Date value) {
            this.updatedDate = value;
            return this;
        }

        public Builder includeMedsCurrent(final String value) {
            this.includeMedsCurrent = value;
            return this;
        }

        public Builder attachmentPath(final String value) {
            this.attachmentPath = value;
            return this;
        }

        public Builder mood(final int value) {
            this.mood = value;
            return this;
        }

        public Builder productivity(final int value) {
            this.productivity = value;
            return this;
        }



        public DiaryVO build() {
            return DiaryVO.create( id, title, notes, notesActivity, createdDate, updatedDate, includeMedsCurrent, attachmentPath, mood, productivity);
        }
//        public DiaryVO build(int ct) {
//            DiaryVO vo =   DiaryVO.create( id, title, notes, notesActivity, createdDate, updatedDate, includeMedsCurrent, attachmentPath, mood, productivity, tagList, patientID );
//            vo.setRow( ct );
//            return vo;
//        }
    }

    public static DiaryVO.Builder builder() {
        return new DiaryVO.Builder();
    }

    private DiaryVO(final int id, final String title, final String notes, final String notesActivity, final Date createdDate, final Date updatedDate, final String includeMedsCurrent, final String attachmentPath, final int mood, final int productivity) {
        this.id = id;
        this.title = title;
        this.notes = notes;
        this.notesActivity = notesActivity;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
        this.includeMedsCurrent = includeMedsCurrent;
        this.attachmentPath = attachmentPath;
        this.mood = mood;
        this.productivity = productivity;


    }
}
