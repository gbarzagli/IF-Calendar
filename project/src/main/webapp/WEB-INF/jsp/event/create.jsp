<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>IFCalendar</title>
</head>
<body>
	<form action="<c:url value="/event/insert"/>" method="post">
		<label for="name">Name: </label> </br>
		<input type="text" name="event.name"/></br></br>
		<label for="place">Place: </label></br>
		<input type="text" name="event.local"/></br></br>
		<label for="startDate">Starting date: </label></br>
		<input type="date" name="event.start"/></br></br>
		<label for="endDate">Ending date: </label></br>
		<input type="date" name="event.end"/></br></br>
		<input type="submit" value="Create"/>
	</form>
</body>
</html>