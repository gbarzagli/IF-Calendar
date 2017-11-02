<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>IFCalendar</title>
</head>
<body>
	<form action="<c:url value="/calendar/insert"/>" method="post">
		<label for="name">Name: </label> </br>
		<input type="text" name="name"/></br></br>
		<label for="invitedUser">Invite user: </label></br>
		<input type="text" name="invitedUser"/></br></br>
		<input type="submit" value="Create"/>
	</form>
</body>
</html>