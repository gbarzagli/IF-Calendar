<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="<c:url value="/css/bootstrap.min.css"/>">
<link rel="stylesheet" href="<c:url value="/css/main.css"/>">
<title>IFCalendar</title>
</head>
<body>
	<div class="container">
			<form action="" method="post" class="main-container display-button-list">
        <h2>MENU</h2>
				<button onClick="createCalendar()">Create calendar</button>
				<button onClick="listCalendar()">Calendars I can see</button>
				<button onClick="logout()" class="logout-button">Logout</button>
			</form>
		</div>
	<script src="<c:url value="/js/main.js"/>"></script>
</body>
</html>