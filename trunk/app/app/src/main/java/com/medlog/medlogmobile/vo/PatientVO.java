package com.medlog.medlogmobile.vo;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Dan on 11/20/2016.
 */

public class PatientVO  implements Serializable, Parcelable {
    private int patientID;
    private String userName;
    private String userPassword;
    private String userHash;
    private String firstName;
    private String lastName;
    private String phoneHome;
    private String phoneMobile;
    private String email;
    private String status;
    private String addressStreet;
    private String addressCity;
    private StateVO addressState;
    private String addressCountry;
    private String addressPostalcode;
    private String userPreferences;
    private Date pwdLastChanged;
    private String lang;
    private String timezoneId;
    private Date dateOfBirth;
    private Date dateJoined;
    private String picture;
    private String metaData;
    private int userRole;
    private List<DiaryVO> diaryList;

    public int getPatientID() {
        return patientID;
    }

    public void setPatientID(int patientID) {
        this.patientID = patientID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserHash() {
        return userHash;
    }

    public void setUserHash(String userHash) {
        this.userHash = userHash;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneHome() {
        return phoneHome;
    }

    public void setPhoneHome(String phoneHome) {
        this.phoneHome = phoneHome;
    }

    public String getPhoneMobile() {
        return phoneMobile;
    }

    public void setPhoneMobile(String phoneMobile) {
        this.phoneMobile = phoneMobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAddressStreet() {
        return addressStreet;
    }

    public void setAddressStreet(String addressStreet) {
        this.addressStreet = addressStreet;
    }

    public String getAddressCity() {
        return addressCity;
    }

    public void setAddressCity(String addressCity) {
        this.addressCity = addressCity;
    }

    public StateVO getAddressState() {
        return addressState;
    }

    public void setAddressState(StateVO addressState) {
        this.addressState = addressState;
    }

    public String getAddressCountry() {
        return addressCountry;
    }

    public void setAddressCountry(String addressCountry) {
        this.addressCountry = addressCountry;
    }

    public String getAddressPostalcode() {
        return addressPostalcode;
    }

    public void setAddressPostalcode(String addressPostalcode) {
        this.addressPostalcode = addressPostalcode;
    }

    public String getUserPreferences() {
        return userPreferences;
    }

    public void setUserPreferences(String userPreferences) {
        this.userPreferences = userPreferences;
    }

    public Date getPwdLastChanged() {
        return pwdLastChanged;
    }

    public void setPwdLastChanged(Date pwdLastChanged) {
        this.pwdLastChanged = pwdLastChanged;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getTimezoneId() {
        return timezoneId;
    }

    public void setTimezoneId(String timezoneId) {
        this.timezoneId = timezoneId;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Date getDateJoined() {
        return dateJoined;
    }

    public void setDateJoined(Date dateJoined) {
        this.dateJoined = dateJoined;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getMetaData() {
        return metaData;
    }

    public void setMetaData(String metaData) {
        this.metaData = metaData;
    }

    public int getUserRole() {
        return userRole;
    }

    public void setUserRole(int userRole) {
        this.userRole = userRole;
    }

    public List<DiaryVO> getDiaryList() {
        return diaryList;
    }

    public void setDiaryList(List<DiaryVO> diaryList) {
        this.diaryList = diaryList;
    }

    public PatientVO() {
    }

    public static PatientVO  fromJSON(String json){
        try {
            System.err.println(json);
            Gson gson = new Gson();
//            TypeToken<List <CompanySearch> > token = new TypeToken<List <CompanySearch> >() {
            TypeToken<PatientVO> token = new TypeToken<PatientVO>(){
            };
            return gson.fromJson(json, token.getType());
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return new PatientVO();
    }

    @Override
    public String toString() {
        return new org.apache.commons.lang.builder.ToStringBuilder(this)
                .append("patientID", patientID)
                .append("userName", userName)
                .append("userPassword", userPassword)
                .append("userHash", userHash)
                .append("firstName", firstName)
                .append("lastName", lastName)
                .append("phoneHome", phoneHome)
                .append("phoneMobile", phoneMobile)
                .append("email", email)
                .append("status", status)
                .append("addressStreet", addressStreet)
                .append("addressCity", addressCity)
                .append("addressState", addressState)
                .append("addressCountry", addressCountry)
                .append("addressPostalcode", addressPostalcode)
                .append("userPreferences", userPreferences)
                .append("pwdLastChanged", pwdLastChanged)
                .append("lang", lang)
                .append("timezoneId", timezoneId)
                .append("dateOfBirth", dateOfBirth)
                .append("dateJoined", dateJoined)
                .append("picture", picture)
                .append("metaData", metaData)
                .append("userRole", userRole)
                .append("diaryList", diaryList)
                .toString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.patientID);
        dest.writeString(this.userName);
        dest.writeString(this.userPassword);
        dest.writeString(this.userHash);
        dest.writeString(this.firstName);
        dest.writeString(this.lastName);
        dest.writeString(this.phoneHome);
        dest.writeString(this.phoneMobile);
        dest.writeString(this.email);
        dest.writeString(this.status);
        dest.writeString(this.addressStreet);
        dest.writeString(this.addressCity);
        dest.writeParcelable(this.addressState, flags);
        dest.writeString(this.addressCountry);
        dest.writeString(this.addressPostalcode);
        dest.writeString(this.userPreferences);
        dest.writeLong(pwdLastChanged != null ? pwdLastChanged.getTime() : -1);
        dest.writeString(this.lang);
        dest.writeString(this.timezoneId);
        dest.writeLong(dateOfBirth != null ? dateOfBirth.getTime() : -1);
        dest.writeLong(dateJoined != null ? dateJoined.getTime() : -1);
        dest.writeString(this.picture);
        dest.writeString(this.metaData);
        dest.writeInt(this.userRole);
        dest.writeList(this.diaryList);
    }

    protected PatientVO(Parcel in) {
        this.patientID = in.readInt();
        this.userName = in.readString();
        this.userPassword = in.readString();
        this.userHash = in.readString();
        this.firstName = in.readString();
        this.lastName = in.readString();
        this.phoneHome = in.readString();
        this.phoneMobile = in.readString();
        this.email = in.readString();
        this.status = in.readString();
        this.addressStreet = in.readString();
        this.addressCity = in.readString();
        this.addressState = in.readParcelable(StateVO.class.getClassLoader());
        this.addressCountry = in.readString();
        this.addressPostalcode = in.readString();
        this.userPreferences = in.readString();
        long tmpPwdLastChanged = in.readLong();
        this.pwdLastChanged = tmpPwdLastChanged == -1 ? null : new Date(tmpPwdLastChanged);
        this.lang = in.readString();
        this.timezoneId = in.readString();
        long tmpDateOfBirth = in.readLong();
        this.dateOfBirth = tmpDateOfBirth == -1 ? null : new Date(tmpDateOfBirth);
        long tmpDateJoined = in.readLong();
        this.dateJoined = tmpDateJoined == -1 ? null : new Date(tmpDateJoined);
        this.picture = in.readString();
        this.metaData = in.readString();
        this.userRole = in.readInt();
        this.diaryList = new ArrayList<DiaryVO>();
        in.readList(this.diaryList, List.class.getClassLoader());
    }

    public static final Creator<PatientVO> CREATOR = new Creator<PatientVO>() {
        public PatientVO createFromParcel(Parcel source) {
            return new PatientVO(source);
        }

        public PatientVO[] newArray(int size) {
            return new PatientVO[size];
        }
    };
}
