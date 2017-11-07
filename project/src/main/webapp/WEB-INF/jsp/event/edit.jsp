<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
        <h2>EDIT EVENT</h2>
        <form action="<c:url value="/event/edit/${event.id}/update"/>" method="post">
          <div class="input-div">
            <input type="text" name="event.name" value="${event.name}"/>
            <label for="name"><span>NAME</span></label>
          </div>
          <div class="input-div">
            <input type="text" name="event.local" value="${event.local}"/>
            <label for="place"><span>PLACE</span></label>
          </div>
          <div class="input-div">
            <fmt:formatDate pattern="yyyy-MM-dd" value = "${event.start}" var="startDate" />
            <input type="date" name="event.start" value="${startDate}"/>
            <label for="startDate"><span>STARTING DATE</span></label>
          </div>
          <div class="input-div">
            <fmt:formatDate pattern="yyyy-MM-dd" value = "${event.end}" var="endDate" />
            <input type="date" name="event.end" value="${endDate}"/>
            <label for="endDate"><span>ENDING DATE</span></label>
          </div>
      		<input type="submit" value="SAVE"/>
      	</form>
      </div>
    </div>
</body>
</html>