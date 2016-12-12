/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var $ = window.jQuery || window.$;
var resource_name = {
    "patient": {"res": "r", "functions": [
            "add"
        ]}
    , "diary": {"res": "d"}
    , "medication": {"res": "m"}
    , "state": {"res": "s"}
};

/**
 * API URL BUILDER
 * @example  var apiUrlWithOutForm = new URLBuilder().setRes("d").setFn("find").build(); //(Finds all diary entries for current user) 
 * * @example var apiUrlWithForm = new URLBuilder().setRes("d").setFn("add").setFormData(userInfo).build(); // Adds diary entry  -- assumes you have stored form serialized data in 'userInfo'
 * @returns {URLBuilder}
 */

var URLBuilder = function () {
    this.res = "";
    this.params = "";
    this.fn = "";
    var apiPrefix = "/MedLogRS/api/";
    var isFirst = true;

    this.setRes = function (r) {
        this.res = r;
        apiPrefix = apiPrefix + (isFirst ? "?" : "&") + "res=" + r;
        isFirst = false;
        return this;
    };
    this.setFn = function (f) {
        this.fn = f;
        apiPrefix = apiPrefix + (isFirst ? "?" : "&") + "fn=" + f;
        isFirst = false;
        return this;
    };
    /**
     * Adds formdata 
     * @example (should use $([idForm]).serialize();
     * @param {type} formData -- JQ serialized
     * @returns {URLBuilder}
     */
    this.setFormData = function (formData) {
        this.params = formData;
        apiPrefix = apiPrefix + (isFirst ? "?" : "&") + "" + formData;
        isFirst = false;
        return this;
    };
    /**
     * Builds the URL string
     * @returns {String}
     */
    this.build = function () {
        return apiPrefix;
    };
};
$.extend({
    getUrlVars: function () {
        var vars = [
        ], hash,
                hashes = window.location.href.slice(window.location.href.indexOf('?') + 1).
                split('&');
        var i = 0;
        var hashLen = hashes.length;
        for (i = 0; i < hashes.length; i++)
        {
            hash = hashes[i].split('=');
            vars.push(hash[0]);
            vars[hash[0]] = hash[1];
        }
        return vars;
    },
    getUrlVar: function (name) {
        return $.getUrlVars()[name];
    }
});


/**
 * Creates option from JSON
 * @param {type} value value attr
 * @param {type} text display
 * @param {type} selected seleted?
 * @returns {String}
 */
function makeOptionTag(value, text, selected) {
    if ((typeof value === 'undefined') === false) {
        var optionMarkup = "<option value='" + value
                + (selected ? " selected " : "")
                + "'>" + text + "</option>";
//        console.log(optionMarkup);
        return optionMarkup;

    }
    return "";
} //end function  

/**
 * 
 * @param {type} drownDownListID id attr of slect tag
 * @param {type} jsonData array of states from server.
 * @param {type} nameOfValueField stateID for example
 * @param {type} nameOfDisplayField stateAbbreviation for example
 * @returns {undefined}
 */
function generateLookupList(drownDownListID, jsonData, nameOfValueField, nameOfDisplayField) {
    var dropDownTagSelector = "#" + drownDownListID;

    var optionTags = "";
    if (typeof jsonData === 'undefined' || jsonData === null || jsonData.length < 5 || !jsonData || typeof jsonData[0] === 'undefined' || typeof jsonData[0].stateName === 'undefined') {
        jsonData = states;
    }

    $(jsonData).each(function (i, vo) { //for loop
        optionTags += makeOptionTag(vo[nameOfValueField], vo[nameOfDisplayField]);
    }); //function
    //Update HTML
    $(dropDownTagSelector).empty().html(optionTags);


} //function



function setMessageText(elementID, isError, message, showForSeconds) {
    var jID = "#" + elementID, jqID = $(jID), showFor = showForSeconds * 1000 + 500;
    jqID.fadeIn('fast');
    jqID.empty().html(message);

    jqID.removeClass("messageFail messageSuccess messageWarning");
    if (isError) {

    }
    setTimeout(function () {
        jqID.fadeOut(1500);
    }, showFor);
}
$("input").focus(function () {
    $(this).css("background-color", "#FFFFCC");
});
$("input").blur(function () {
    $(this).css("background-color", "#FFF");
});

function redir(pg) {
    top.location.href = pg;
}
/**
 * ID PARAM
 * @returns {Number}
 */
function getIDParamFromRequest() {
    var id = 0;
    try {
        id = $.getUrlVar("id");
        id = parseInt(id);
    } catch (e) {
        id = 0;
    }
    if (typeof id === 'undefined' || id === null || id == '') {
        id = 0;
    }

    return id;
}
var states = [{"stateID": 5, "stateName": "Alabama", "stateAbbreviation": "AL", "patientList": null}, {"stateID": 6, "stateName": "Alaska", "stateAbbreviation": "AK", "patientList": null}, {"stateID": 7, "stateName": "Arizona", "stateAbbreviation": "AZ", "patientList": null}, {"stateID": 8, "stateName": "Arkansas", "stateAbbreviation": "AR", "patientList": null}, {"stateID": 55, "stateName": "Armed Forces Americas", "stateAbbreviation": "AA", "patientList": null}, {"stateID": 4, "stateName": "California", "stateAbbreviation": "CA", "patientList": null}, {"stateID": 9, "stateName": "Colorado", "stateAbbreviation": "CO", "patientList": null}, {"stateID": 10, "stateName": "Connecticut", "stateAbbreviation": "CT", "patientList": null}, {"stateID": 11, "stateName": "Delaware", "stateAbbreviation": "DE", "patientList": null}, {"stateID": 12, "stateName": "District of Columbia", "stateAbbreviation": "DC", "patientList": null}, {"stateID": 13, "stateName": "Florida", "stateAbbreviation": "FL", "patientList": null}, {"stateID": 14, "stateName": "Georgia", "stateAbbreviation": "GA", "patientList": null}, {"stateID": 52, "stateName": "Guam", "stateAbbreviation": "GU", "patientList": null}, {"stateID": 15, "stateName": "Hawaii", "stateAbbreviation": "HI", "patientList": null}, {"stateID": 16, "stateName": "Idaho", "stateAbbreviation": "ID", "patientList": null}, {"stateID": 17, "stateName": "Illinois", "stateAbbreviation": "IL", "patientList": null}, {"stateID": 18, "stateName": "Indiana", "stateAbbreviation": "IN", "patientList": null}, {"stateID": 19, "stateName": "Iowa", "stateAbbreviation": "IA", "patientList": null}, {"stateID": 20, "stateName": "Kansas", "stateAbbreviation": "KS", "patientList": null}, {"stateID": 21, "stateName": "Kentucky", "stateAbbreviation": "KY", "patientList": null}, {"stateID": 22, "stateName": "Louisiana", "stateAbbreviation": "LA", "patientList": null}, {"stateID": 23, "stateName": "Maine", "stateAbbreviation": "ME", "patientList": null}, {"stateID": 35, "stateName": "Maryland", "stateAbbreviation": "MD", "patientList": null}, {"stateID": 36, "stateName": "Massachusetts", "stateAbbreviation": "MA", "patientList": null}, {"stateID": 37, "stateName": "Michigan", "stateAbbreviation": "MI", "patientList": null}, {"stateID": 38, "stateName": "Minnesota", "stateAbbreviation": "MN", "patientList": null}, {"stateID": 39, "stateName": "Mississippi", "stateAbbreviation": "MS", "patientList": null}, {"stateID": 40, "stateName": "Missouri", "stateAbbreviation": "MO", "patientList": null}, {"stateID": 24, "stateName": "Montana", "stateAbbreviation": "MT", "patientList": null}, {"stateID": 25, "stateName": "Nebraska", "stateAbbreviation": "NE", "patientList": null}, {"stateID": 26, "stateName": "Nevada", "stateAbbreviation": "NV", "patientList": null}, {"stateID": 27, "stateName": "New Hampshire", "stateAbbreviation": "NH", "patientList": null}, {"stateID": 1, "stateName": "New Jersey", "stateAbbreviation": "NJ", "patientList": null}, {"stateID": 28, "stateName": "New Mexico", "stateAbbreviation": "NM", "patientList": null}, {"stateID": 29, "stateName": "New York", "stateAbbreviation": "NY", "patientList": null}, {"stateID": 30, "stateName": "North Carolina", "stateAbbreviation": "NC", "patientList": null}, {"stateID": 31, "stateName": "North Dakota", "stateAbbreviation": "ND", "patientList": null}, {"stateID": 32, "stateName": "Ohio", "stateAbbreviation": "OH", "patientList": null}, {"stateID": 33, "stateName": "Oklahoma", "stateAbbreviation": "OK", "patientList": null}, {"stateID": 34, "stateName": "Oregon", "stateAbbreviation": "OR", "patientList": null}, {"stateID": 2, "stateName": "Pennsylvania", "stateAbbreviation": "PA", "patientList": null}, {"stateID": 53, "stateName": "Puerto Rico", "stateAbbreviation": "PR", "patientList": null}, {"stateID": 41, "stateName": "Rhode Island", "stateAbbreviation": "RI", "patientList": null}, {"stateID": 42, "stateName": "South Carolina", "stateAbbreviation": "SC", "patientList": null}, {"stateID": 43, "stateName": "South Dakota", "stateAbbreviation": "SD", "patientList": null}, {"stateID": 44, "stateName": "Tennessee", "stateAbbreviation": "TN", "patientList": null}, {"stateID": 45, "stateName": "Texas", "stateAbbreviation": "TX", "patientList": null}, {"stateID": 46, "stateName": "Utah", "stateAbbreviation": "UT", "patientList": null}, {"stateID": 47, "stateName": "Vermont", "stateAbbreviation": "VT", "patientList": null}, {"stateID": 54, "stateName": "Virgin Islands", "stateAbbreviation": "VI", "patientList": null}, {"stateID": 48, "stateName": "Virginia", "stateAbbreviation": "VA", "patientList": null}, {"stateID": 3, "stateName": "Washington", "stateAbbreviation": "WA", "patientList": null}, {"stateID": 49, "stateName": "West Virginia", "stateAbbreviation": "WV", "patientList": null}, {"stateID": 50, "stateName": "Wisconsin", "stateAbbreviation": "WI", "patientList": null}, {"stateID": 51, "stateName": "Wyoming", "stateAbbreviation": "WY", "patientList": null}];
$(document).ready(function () {
    $("input").focus(function () {
        $(this).css("background-color", "#FFFFCC");
    });
    $("input").blur(function () {
        $(this).css("background-color", "#FFF");
    });
});