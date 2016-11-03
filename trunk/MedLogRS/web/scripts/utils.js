 /* 
  * To change this license header, choose License Headers in Project Properties.
  * To change this template file, choose Tools | Templates
  * and open the template in the editor.
  */
 var $ = window.jQuery || window.$;
 var resource_name = {
	 "patient" : {"res" : "r","functions":["add"]}
	 , "diary" : {"res" : "d"}
	 , "medication" : {"res" : "m"}
	 , "state" : {"res" : "s"}
 };

/**
 * API URL BUILDER
 * @returns {URLBuilder}
 */

 var URLBuilder = function () {
	 this.res = "";
	 this.params = "";
	 this.fn = "";
	 var apiPrefix = "./api/";
	 var isFirst = true;

	 this.setRes = function ( r ) {
		 this.res = r;
		 apiPrefix = apiPrefix + (isFirst ? "?" : "&") + "res=" + r;
		 isFirst = false;
		 return this;
	 };
	 this.setFn = function ( f ) {
		 this.fn = f;
		 apiPrefix = apiPrefix + (isFirst ? "?" : "&") + "fn=" + f;
		 isFirst = false;
		 return this;
	 };
	 this.setFormData = function ( formData ) {
		 this.params = formData;
		 apiPrefix = apiPrefix + (isFirst ? "?" : "&") + "" + formData;
		 isFirst = false;
	 };
	 this.build = function () {
		 alert(apiPrefix);
		 return apiPrefix;
	 };
 };
 $.extend({
	 getUrlVars : function () {
		 var vars = [
		 ], hash,
			 hashes = window.location.href.slice(window.location.href.indexOf('?') + 1).
			 split('&');
		 var i = 0;
		 var hashLen = hashes.length;
		 for ( i = 0; i < hashes.length; i++ )
		 {
			 hash = hashes[i].split('=');
			 vars.push(hash[0]);
			 vars[hash[0]] = hash[1];
		 }
		 return vars;
	 },
	 getUrlVar : function ( name ) {
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
 function makeOptionTag( value, text, selected ) {
	 if ( (typeof value === 'undefined') === false ) {
		 var optionMarkup = "<option value='" + value
			 + (selected ? " selected " : "")
			 + "'>" + text + "</option>";
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
 function generateLookupList( drownDownListID, jsonData, nameOfValueField, nameOfDisplayField ) {
	 var dropDownTagSelector = "#" + drownDownListID;
	 var optionTags = makeOptionTag("", "Select....", true); // Add default option to select.
	 if ( $.isArray(jsonData, nameOfValueField, nameOfDisplayField) && jsonData.legth > 0) {//validate array
		 $(jsonData).each(function ( i, vo ) { //for loop
			 optionTags += makeOptionTag(vo[nameOfValueField],vo[nameOfDisplayField]);
		 }); //function
		 //Update HTML

		 $(dropDownTagSelector).empty().html(optionTags);
	 } //valid voList
 } //function



 function setMessageText( elementID, isError, message, showForSeconds ) {
	 var jID = "#" + elementID, jqID = $(jID), showFor = showForSeconds * 1000 + 500;
	 jqID.fadeIn('fast');
	 jqID.empty().html(message);

	 jqID.removeClass("messageFail messageSuccess messageWarning");
	 if ( isError ) {

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
