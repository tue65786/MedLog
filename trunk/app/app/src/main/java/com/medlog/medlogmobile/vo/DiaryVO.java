package com.medlog.medlogmobile.vo;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Dan on 11/20/2016.
 */

public class DiaryVO implements Serializable,Parcelable{
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
    private  int row;

    public DiaryVO(){

    }
    protected DiaryVO(Parcel in) {
        id = in.readInt();
        title = in.readString();
        notes = in.readString();
        notesActivity = in.readString();
        includeMedsCurrent = in.readString();
        attachmentPath = in.readString();
        mood = in.readInt();
        productivity = in.readInt();
        row = in.readInt();
    }

    public static final Creator<DiaryVO> CREATOR = new Creator<DiaryVO>() {
        @Override
        public DiaryVO createFromParcel(Parcel in) {
            return new DiaryVO(in);
        }

        @Override
        public DiaryVO[] newArray(int size) {
            return new DiaryVO[size];
        }
    };

    public static DiaryVO create(final int id, final String title, final String notes, final String notesActivity, final Date createdDate, final Date updatedDate, final String includeMedsCurrent, final String attachmentPath, final int mood, final int productivity) {
        return new DiaryVO( id, title, notes, notesActivity, createdDate, updatedDate, includeMedsCurrent, attachmentPath, mood, productivity);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getNotesActivity() {
        return notesActivity;
    }

    public void setNotesActivity(String notesActivity) {
        this.notesActivity = notesActivity;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public String getIncludeMedsCurrent() {
        return includeMedsCurrent;
    }

    public void setIncludeMedsCurrent(String includeMedsCurrent) {
        this.includeMedsCurrent = includeMedsCurrent;
    }

    public String getAttachmentPath() {
        return attachmentPath;
    }

    public void setAttachmentPath(String attachmentPath) {
        this.attachmentPath = attachmentPath;
    }

    public int getMood() {
        return mood;
    }

    public void setMood(int mood) {
        this.mood = mood;
    }

    public int getProductivity() {
        return productivity;
    }

    public void setProductivity(int productivity) {
        this.productivity = productivity;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(title);
        parcel.writeString(notes);
        parcel.writeString(notesActivity);
        parcel.writeString(includeMedsCurrent);
        parcel.writeString(attachmentPath);
        parcel.writeInt(mood);
        parcel.writeInt(productivity);
        parcel.writeInt(row);
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
        this.setId(id);
        this.setTitle(title);
        this.setNotes(notes);
        this.setNotesActivity(notesActivity);
        this.setCreatedDate(createdDate);
        this.setUpdatedDate(updatedDate);
        this.setIncludeMedsCurrent(includeMedsCurrent);
        this.setAttachmentPath(attachmentPath);
        this.setMood(mood);
        this.setProductivity(productivity);


    }
    public String getURLString(int patientID)  {
        StringBuilder sb = new StringBuilder("");
        sb.append("fn=mobisync");

        try {
            sb.append("&title=").append(URLEncoder.encode(getTitle(),"utf-8"))
                    .append("&notes=").append(URLEncoder.encode(getNotes(),"utf-8")).append("&mood=")
                    .append(getMood()).append("&productivity=").append(getProductivity())
                    .append("&patientID=").append(patientID);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
    public static ArrayList<DiaryVO> fromJSON(String json){
        try {
            System.err.println(json);
            Gson gson = new Gson();
            TypeToken<List <DiaryVO> > token = new TypeToken<List<DiaryVO>>() {
//            TypeToken<PatientVO> token = new TypeToken<PatientVO>(){
            };
            return gson.fromJson(json, token.getType());
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return new ArrayList<DiaryVO>();
    }

    @Override
    public String toString() {
        return "DiaryVO{" +
                "title='" + getTitle() + '\'' +
                ", notes='" + getNotes() + '\'' +
                ", mood=" + getMood() +
                ", productivity=" + getProductivity() +
                '}';
    }
}
