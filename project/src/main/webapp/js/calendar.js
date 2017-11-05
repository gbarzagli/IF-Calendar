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