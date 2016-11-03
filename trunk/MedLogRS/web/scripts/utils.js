 /* 
  * To change this license header, choose License Headers in Project Properties.
  * To change this template file, choose Tools | Templates
  * and open the template in the editor.
  */
  var $ = window.jQuery || window.$;
 $.extend({
	 getUrlVars : function () {
		 var vars = [
		 ], hash;
		 var hashes = window.location.href.slice(window.location.href.indexOf('?') + 1).
			 split('&');
		 for ( var i = 0; i < hashes.length; i++ )
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
 function makeOptionTag( value,text,selected ) {
	 if ( typeof value !== 'undefined' ) {
		 var optionMarkup = "<option value='" + vo.stateID  + (selected ? " selected " : "")+  "'>" + vo.stateName  +  "</option>";
		 return optionMarkup;
	 }
	 return "";
 } //end function

 
