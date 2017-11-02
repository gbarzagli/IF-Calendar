<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>IFCalendar</title>
</head>
<body>
	<form action="" method="post">
		<button onClick="createCalendar()">Create calendar</button>
		<button onClick="listCalendar()">Calendars I can see</button>
		<button onClick="logout()">Logout</button>
	</form>

	<script src="<c:url value="/js/main.js"/>"></script>
</body>
</html>