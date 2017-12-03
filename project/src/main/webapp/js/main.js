function logout(){
	document.forms[0].action = "/if-calendar/logout"
}

function createCalendar(){
	document.forms[0].action = "/if-calendar/calendar/create"
}

function listCalendar(){
	document.forms[0].action = "/if-calendar/calendar/list"
}

function changeCalendar(id) {
	var form = document.calendarChooser;
	form.action = "/if-calendar/calendar/" + id;
	form.submit();
}