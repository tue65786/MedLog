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

 var APIURlBuilder = function () {
	 this.res = "";
	 this.params = "";
	 this.fn = "";
	 var apiPrefix = "./api/?";
	 
	 this.setRes = function ( r ) {
		 this.res = r;
		 return this; 
	 };
	 this.setFn= function(f){
		 this.fn = f;
		 return this;		 
	 }
	 this.setFormData = function (formData){
		 this.params= formData;
	 }
	 this.build = function(){
		 return 
	 }
 }