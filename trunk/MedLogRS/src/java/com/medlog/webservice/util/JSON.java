package com.medlog.webservice.util;

import com.google.gson.*;

public class JSON {

    public static String doubleQuote(String val) {
        return " \"" + val + "\"";
    }

    public static String nameValuePair(String name, String value) {
        return doubleQuote(name) + " : " + doubleQuote(value);
    }

    /* 
 This class uses GSON (from google), a java library that converts from json to java object
 and from jason objects to json. 

 * download from here: http://search.maven.org/remotecontent?filepath=com/google/code/gson/gson/2.5/gson-2.5.jar 
 * I recommend you save this file into your NetBeans projects folder 
 * right click the libraries folder (of your project in NetBeans) and select "add jar", 
 * don't forget to use the import statement (at the top of your class):   import com.google.gson.*;
 * javadocs are here: http://google.github.io/gson/apidocs/ but all you need is the sample code shown here:
    
 // Sample code
 Gson gson = new Gson(); 
    
 // Java Object to json example...
 MyType target = new MyType();
 String json = gson.toJson(target); // serializes target to Json
    
 // Json to Java Object example
 MyType target2 = gson.fromJson(json, MyType.class); // deserializes json into target2

     */

 /*
        public static StringData toStringData(String json) {

            Gson gson = new Gson();

            // from json to java object
            StringDataAngular stringDataAlt = gson.fromJson(json, StringDataAngular.class);
            stringDataAlt.Gender.replace("\"", "");
            System.out.print("Json converted Gender is " + stringDataAlt.Gender);

            StringData stringData = new StringData();
            stringData.personId = stringDataAlt.Id;
            stringData.name = stringDataAlt.Name;
            try {
                stringData.age = new Integer(stringDataAlt.Age).toString();
            } catch (Exception e) {
                stringData.age = "0";
            }
            stringData.sex = stringDataAlt.Gender;
            return stringData;
        }
     */
    public static String toJson(Object o) {

        Gson gson = new Gson();

        // from java object to json
        String json = gson.toJson(o);
        return json;
    }
}
