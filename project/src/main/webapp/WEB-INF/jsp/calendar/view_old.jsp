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
      <div class="main-container row">
        <h2>${calendar.name}</h2>
      	<form action="" method="post">
      		<c:if test="${canWrite}">   
	          	<button onClick="manageParticipants()">Manage participants</button>
	      		<button onClick="addEvent()">Add event</button>
      		</c:if>
      		<ul class="ul-table">
      		<c:forEach items="${eventList}" var="event">
	      		<li>
	                <div>
	                  ${event.start}
	                </div>
	                <div>
	                  <a href="<c:url value="/event/${event.id}"/>"> -  ${event.name}</a>
	                </div>
	                <c:if test="${canWrite}"> 
		                <div>
		                  <button onclick="edit(${event.id})">Edit</button>
		                  <button onclick="remove(${event.id})">Delete</button>
		                </div>
	                </c:if>
	              </li>
      		</c:forEach>
      		</ul>
      	</form>
      </div>
    </div>	
	<script src="<c:url value="/js/calendar.js"/>"></script>
</body>
</html>