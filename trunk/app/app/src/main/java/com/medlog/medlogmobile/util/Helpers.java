 package com.medlog.medlogmobile.util;

import android.app.Activity;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.medlog.medlogmobile.vo.PatientVO;
import com.medlog.medlogmobile.vo.ResponseVO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by westy on 11/23/2016.
 */

public class Helpers {


    public static  PackageInfo getPackageInfo(final Activity mActivity)
    {
        PackageInfo pi = null;
        try
        {
            pi = mActivity.getPackageManager().getPackageInfo( mActivity.getPackageName(), PackageManager.GET_ACTIVITIES );
        }
        catch ( PackageManager.NameNotFoundException e )
        {
            e.printStackTrace();
        }
        return pi;
    }
    public static String toS(Object value, final String defaultV) {
        try {
//            String ret = "";
            if (value == null) return defaultV;
            try {
                if (value.getClass().equals("".getClass())){
                 return (String)value;
                }
                return String.valueOf(value);
            } catch (Exception e) {
                return defaultV;
            }
        } catch (Exception ee) {
            return defaultV;
        }
    }
    public static ResponseVO getDiaryUrlSource(String url) throws IOException {

        URL mURL = new URL(url);

        URLConnection urlConn = mURL.openConnection();

        BufferedReader in = new BufferedReader(new InputStreamReader(
                urlConn.getInputStream(), "UTF-8"));
        String inputLine;
        StringBuilder a = new StringBuilder();
        while ((inputLine = in.readLine()) != null)
            a.append(inputLine);
        in.close();
        try{
            try {
                System.err.println(a);
                Gson gson = new Gson();
//            TypeToken<List <CompanySearch> > token = new TypeToken<List <CompanySearch> >() {
                TypeToken<ResponseVO> token = new TypeToken<ResponseVO>(){
                };
                return gson.fromJson(a.toString(), token.getType());
            }catch(Exception ee){
                return new ResponseVO("error",ee.toString());
            }
        }catch(Exception e){

            return new ResponseVO("error",e.toString());
        }

    }

}
