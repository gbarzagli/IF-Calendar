<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>IF Calendar</title>
</head>
<body>
	<form method="post" action="<c:url value='/home/logIn'/>">
		<div style="display: flex; align-items: center; justify-content: center;">
			<div style="display: flex; flex-direction: column; width: 250px; justify-content: center; align-items: center;">
				<h1>IF CALENDAR</h1>
				<div style="margin-top: 40px;">
					<span>Login: </span>
					<input name="user.login">
				</div>
				<div style="margin-top: 5px;">
					<span>Password: </span>
					<input name="user.password">
				</div>
				<input style="margin-top: 30px; width: 70px;" type="submit" value="Log In">
			</div>
		</div>
	</form>
</body>
</html>