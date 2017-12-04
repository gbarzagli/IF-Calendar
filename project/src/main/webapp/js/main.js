function logout(){
	document.forms[0].action = "/if-calendar/logout"
}

function createCalendar(){
	document.forms[0].action = "/if-calendar/calendar/create"
}

function listCalendar(){
	document.forms[0].action = "/if-calendar/calendar/list"
}
