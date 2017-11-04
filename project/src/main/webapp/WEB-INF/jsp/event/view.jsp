<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="<c:url value="/css/bootstrap.min.css"/>">
<link rel="stylesheet" href="<c:url value="/css/main.css"/>">
<title>IFCalendar</title>
</head>
<body>
   <div class="container">
      <div class="main-container row">
        <h2>EVENTS</h2>
        <ul class="ul-table">
          <li>
            <div><c:out value="${ event.name }"/></div>
            <div><c:out value="${ event.start }"/></div>
            <div><c:out value="${ event.end }"/></div>
            <div><c:out value="${ event.local }"/></div>
          </li>
        </ul>
      </div>
    </div>
</body>
</html>