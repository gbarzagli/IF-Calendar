<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>IFCalendar</title>
</head>
<body>
	<h1>${calendar.name}</h1>
	
	<form action="" method="post">		
		<button onClick="addEvent()">Add event</button>
		<ul>
			<c:forEach items="${eventList}" var="event">
				<li> ${event.start} <a href="<c:url value="/event/${event.id}"/>">${event.name}</a> <button onclick="edit(${event.id})">Edit</button><button onclick="remove(${event.id})">Delete</button></li>
			</c:forEach>
		</ul>
	</form>
	
	<script src="<c:url value="/js/calendar.js"/>"></script>
</body>
</html>