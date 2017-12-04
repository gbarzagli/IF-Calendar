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
	document.forms[0].action = "/if-calendar/calendar/changePermission";
}

function addUser(){
	document.forms[0].action = "/if-calendar/calendar/saveParticipant";
}

function chooseDay(obj) {
	var day = obj.innerHTML.trim();
	document.forms[0].action = "/if-calendar/calendar/chooseDay/" + day;
	document.forms[0].submit();
}

function insertEvent() {
	window.location.href = "http://localhost:8080/if-calendar/event/create";
}