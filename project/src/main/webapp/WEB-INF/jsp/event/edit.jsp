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
            <label for="name"><span>NAME</span></label>
            <input id="name" type="text" name="event.name" value="${event.name}"/>
          </div>
          <div class="input-div">
            <label for="description"><span>DESCRIPTION</span></label>
            <input id="description" type="text" name="event.local" value="${event.local}"/>
          </div>
          <div class="input-div">
            <fmt:formatDate pattern="yyyy-MM-dd" value = "${event.start}" var="startDate" />
            <fmt:formatDate pattern="yyyy-MM-dd" value = "${event.end}" var="endDate" />
            <label for="date"><span>DATE</span></label>
            <input id="date" type="date" name="event.start" value="${startDate}"/>
            <input type="hidden" name="event.end" value="${endDate}" />
          </div>
          <div class="input-div">
            <label for="startTime"><span>STARTING TIME</span></label>
            <input id="startTime" type="time" name="startTime" value="${startTime}"/>
          </div>
          <div class="input-div">
            <fmt:formatDate pattern="yyyy-MM-dd" value = "${event.end}" var="endDate" />
            <label for="endTime"><span>ENDING TIME</span></label>
            <input id="endTime" type="time" name="endTime" value="${endTime}"/>
          </div>
      	  <input type="submit" value="SAVE"/>
      	</form>
      </div>
    </div>
</body>
</html>