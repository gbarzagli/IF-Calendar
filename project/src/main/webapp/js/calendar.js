function addEvent() {
	document.forms[0].action = "/if-calendar/event/create";
}

function remove(id) {
	document.forms[0].action = "/if-calendar/event/delete/" + id;
}

function edit(id) {
	document.forms[0].action = "/if-calendar/event/edit/" + id;
}