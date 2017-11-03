<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>IFCalendar</title>
</head>
<body>
	<h1>Calendars</h1>
	<c:forEach items="${calendarList}" var="calendar">
		<a href="<c:url value="/calendar/${calendar.id}"/>">${calendar.name}</a> </br>
	</c:forEach>
</body>
</html>