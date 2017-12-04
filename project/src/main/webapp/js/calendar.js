function addEvent() {
	document.forms[0].action = "/if-calendar/event/create";
}

function remove(id) {
	document.forms[0].action = "/if-calendar/event/delete/" + id;
}

function edit(id) {
	document.forms[0].action = "/if-calendar/event/edit/" + id;
}

function manageParticipants(){
	document.forms[0].action = "/if-calendar/calendar/participants";
}

function changePermissions(){
	var elements = document.getElementsByClassName("check");
	var values = "";
	[].forEach.call(elements, function (element) {
		values += element.id + "," + element.checked + ",";
	});
	document.forms[0].action = "/if-calendar/calendar/changePermission/" + values;
}

function verifyCalendarName() {
	var field = document.getElementById("calendarName");
	if (field.value == null || field.value.trim() == "") {
		alert("Type a name for your calendar!");
	} else {
		document.forms[0].submit();
	}
}

function checkPermission(id) {
	var checkbox = document.getElementById(id);
	checkbox.checked = !checkbox.checked;
}

function addUser(){
	document.forms[0].action = "/if-calendar/calendar/saveParticipant";
}

function chooseDay(obj) {
	var day = obj.innerHTML.trim();
	day = day.replace("<a>", "");
	day = day.replace("</a>", "");
	document.forms[0].action = "/if-calendar/calendar/chooseDay/" + day;
	document.forms[0].submit();
}

function insertEvent() {
	window.location.href = "http://localhost:8080/if-calendar/event/create";
}

function cancelSignup() {
	window.location.href = "http://localhost:8080/if-calendar/";
}
