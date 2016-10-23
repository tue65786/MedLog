//Stack track for form instance posting
var idNum = 0; //current id - also necessary for cycling to the current value to be pushed on stack
var formStack = []; //array for tracking stack values

function CreateJournalEntry() {
	idNum++; //increment at beginning for each unique field identifier

	//Fetch entered input values
	console.log("Getting data from: ", "#Diary");
	var DiaryEntryValue = $("#Diary").val();
	var ActivityEntryValue = $("#ALog").val();
    var MoodRateValue = $("#MRate").val();
    var ProdRateValue = $("#PRate").val();

	//Generate posted log of an entry

    //Capture the full entry element with necessary id
	var FullEntry = document.createElement('div');
	FullEntry.id = "formContainer" + idNum;
    
	//Capture diary element with necessary id
    var DiaryEntry = document.createElement('textarea');
	DiaryEntry.id = 'Diary' + idNum;
	DiaryEntry.setAttribute('rows', '4');
	DiaryEntry.setAttribute('cols', '50');
	DiaryEntry.value = DiaryEntryValue;

	//Capture activity log element with necessary id
	var ActivityEntry = document.createElement('textarea');
	ActivityEntry.id = 'ALog' + idNum;
	ActivityEntry.setAttribute('rows', '4');
	ActivityEntry.setAttribute('cols', '50');
	ActivityEntry.value = ActivityEntryValue;
	
	//Capture mood rate element with necessary id
	var MoodEntry = document.createElement('input');
	MoodEntry.setAttribute('type', 'range');
	MoodEntry.id = 'MRate' + idNum;
	MoodEntry.setAttribute('min', '0');
	MoodEntry.setAttribute('max', '10');
	MoodEntry.value = MoodRateValue;

	//Capture productivty rate element with necessary id
	var ProdEntry = document.createElement('input');
	ProdEntry.setAttribute('type', 'range');
	ProdEntry.id = 'PRate' + idNum;
	ProdEntry.setAttribute('min', '0');
	ProdEntry.setAttribute('max', '10');
	ProdEntry.value = ProdRateValue;
    
    //Post the full entry per element and input
	FullEntry.appendChild(DiaryEntry);
	FullEntry.appendChild(ActivityEntry);
	FullEntry.appendChild(MoodEntry);
	FullEntry.appendChild(ProdEntry);
    
    //push id on top of the stack
	formStack.push({id: idNum});
	
	
	
	var elem = document.getElementById('title');
	if(elem.nextSibling) {
		elem.parentNode.insertBefore(FullEntry, elem.nextSibling);
	} else {
		elem.parentNode.appendChild(FullEntry);
	}
	
	console.log(formStack); //incorporate stacktrace
};