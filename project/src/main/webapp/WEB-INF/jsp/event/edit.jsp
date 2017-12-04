<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="<c:url value="/css/bootstrap.min.css"/>">
<link rel="stylesheet" href="<c:url value="/css/main.css"/>">
<link href="http://fonts.googleapis.com/css?family=Roboto:400,100,‌​100italic,300,300ita‌​lic,400italic,500,50‌​0italic,700,700itali‌​c,900italic,900" rel="stylesheet" type="text/css">
<title>IFCalendar</title>
</head>
<body>
	 <%@ include file="../navbar.jsp" %>
	<form action="<c:url value="/event/edit/${event.id}/update"/>" method="post">
    <div class="modal-dialog ">
        <div class="modal-content">
            <div class="modal-header ">
                <h4 class="modal-title participants-title">EDIT EVENT</h4>
            </div>
            <div class="modal-body participant-list">
					<div class="input-div add-participant-div">
						<label for="name"><span>NAME</span></label>
						<input type="text" name="event.name" required  value="${event.name}" />
					</div>
					<div class="input-div add-participant-div">
						<label for="description"><span>DESCRIPTION</span></label> 
						<input type="text" name="event.local" required value="${event.local}" />
					</div>
					<div class="input-div add-participant-div">
			            <fmt:formatDate pattern="yyyy-MM-dd" value = "${event.start}" var="startDate" />
			            <fmt:formatDate pattern="yyyy-MM-dd" value = "${event.end}" var="endDate" />
			            <label for="date"><span>DATE</span></label>
			            <input id="date" type="date" name="event.start" value="${startDate}"/>
			            <input type="hidden" name="event.end" value="${endDate}" />
		            </div>
					<div class="input-div add-participant-div">
						<label for="startTime"><span>STARTING TIME</span></label>
						<input type="time" name="startTime" value="${startTime}" />
					</div>
					<div class="input-div add-participant-div">
						<label for="endTime"><span>ENDING TIME</span></label>
						<input type="time" name="endTime" value="${endTime}" />
					</div>
            </div>
            <button class="modal-button">SAVE</button>
        </div>
    </div>
    </form>
    <script src="<c:url value="/js/jquery-3.2.1.min.js"/>"></script>
    <script src="<c:url value="/js/bootstrap.min.js"/>"></script>
</body>
</html>