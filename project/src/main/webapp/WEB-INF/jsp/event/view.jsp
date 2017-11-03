<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h1>Event</h1>
    <ul>
        <li><c:out value="${ event.name }"/></li>
        <li><c:out value="${ event.start }"/></li>
        <li><c:out value="${ event.end }"/></li>
        <li><c:out value="${ event.local }"/></li>
    </ul>
</body>
</html>