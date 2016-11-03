 /* 
  * To change this license header, choose License Headers in Project Properties.
  * To change this template file, choose Tools | Templates
  * and open the template in the editor.
  */
 var $ = window.jQuery || window.$;
 /**
  * Generate <option> tags from StateVO JSON
  * @param {StateVO} vo
  * @syntax getOptionTagFromStateVO([{stateID:2,stateName:"Pennsylvania"},{stateID:1,stateName:"New Jersey"}]) - anonymous Array of object
  * @syntax getOptionTagFromStateVO(stateVOs) -- object.
  * @returns {String} HTML options.
  */
 function makeOptionTagFromStateVO( vo,selected ) {
	 if ( $.isPlainObject(vo) && typeof vo.stateID !== 'undefined' ) {
		 var optionMarkup = "<option value='" + vo.stateID  + (selected ? " selected " : "")+  "'>" + vo.stateName  +  "</option>";
		 return optionMarkup;
	 }
	 return "";
 } //end function

 /**
  * Sets selected value of drop down list
  * @param {type} drownDownListID id property of drop down
  * @param {type} selectedOption key to select
  * @example setDropDownSelectValue('stateID',2); // sets tag with id="stateID" to 2
  * @returns {Boolean}
  */
 function setDropDownSelectValue( drownDownListID, selectedOption ) {
	 var dropDownTagSelector = "#" + drownDownListID;
	 $(dropDownTagSelector).val(selectedOption); // set value
	 return false;
 }
 /**
  * Generate states list
  * @param {type} stateVOList
  * @returns {String} HTML
  */
 function generateStateList( drownDownListID, stateVOList ) {
//Add JQuery Syntax mark to select tag ID
	 var dropDownTagSelector = "#" + drownDownListID
	 ,blankState = {
		 "stateID" : "",
		 "stateName" : "Select..." }
	 
	 , stateListOptionTags = makeOptionTagFromStateVO(blankState,true); // Add default option to select.

	 if ( $.isArray(stateVOList) && stateVOList.length > 0 ) {//validate array

		 $(stateVOList).each(function ( i, vo ) { //for loop
			 stateListOptionTags += makeOptionTagFromStateVO(vo);
		 }); //function
		 //Update HTML

		 $(dropDownTagSelector).empty().html(stateListOptionTags);
	 } //valid voList
 } //function

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
 /**
  * JSON Array of StateVO Objects.
  * Brackets [] define array
  * Braces {} define object
  * Name valiue pair syntax uses colon comma and quotes(for string values) -->
  * 
  * @syntax {
  "stateID" : 1,
  "stateName" : "New Jersey",
  "stateAbbreviation" : "NJ"
  }
  * @description JAVA version looks like:
  * public class StateVO{
  *			int stateID = 1;
  *			String stateName = "New Jersey";		
  *			String stateAbbreviation = "PA";
  * }//end class
  *
  */
 var stateLisTT;
 //</editor-fold>

function myFunction() {
    var inpObj = document.getElementById("id1");
    if (inpObj.checkValidity() == false) {
        document.getElementById("demo").innerHTML = inpObj.validationMessage;
    } else {
        document.getElementById("demo").innerHTML = "Input OK";
    }
}