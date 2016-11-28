package com.medlog.webservice.util;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MakeSelectTag {
    public static String makeEnumSelect(String tagName, String selected, String[] options) {
        if("".equals(selected)){
            selected = "0";
        }
        String out = "<select name = \"" + tagName + "\">\n";
        out += "<option value=\"0\"></option>\n";
        int i = 0;
        while (i < options.length) {
            out += "<option value=\"" + (i + 1) + "\"";
            if ((i + 1) == Integer.parseInt(selected)) {
                out += " selected = \"selected\" ";
            }
            out += ">" + options[i] + "</option>\n";
            i++;
        }
        out += "</select>\n";
        return out;
    }
}
