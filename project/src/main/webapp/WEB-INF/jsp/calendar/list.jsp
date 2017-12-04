<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="<c:url value="/css/bootstrap.min.css"/>">
<link rel="stylesheet" href="<c:url value="/css/main.css"/>">
<link href="http://fonts.googleapis.com/css?family=Roboto:400,100,‌​100italic,300,300ita‌​lic,400italic,500,50‌​0italic,700,700itali‌​c,900italic,900" rel="stylesheet" type="text/css">
<title>IFCalendar</title>
</head>
<body>
    <%@ include file="../navbar.jsp" %>
    <form action="<c:url value="/calendar/insert"/>" method="post">
	<div class="container calendar-container">
		<div class="row calendar-row">
			<div class="header-main-calendar manage-calendars-row">
				<h4 class="col-md-6 col-sm-12 col-xs-12">MANAGE CALENDARS</h4>
				<button type="button" class="col-md-6 col-sm-12 col-xs-12 pull-right btn-p" data-toggle="modal" data-target="#createModal">Create calendar</button>
			</div>
			<div class="manage-calendars-row col-md-12">
			    <h5>My calendars</h5>
				<ul class="calendars-list">
				    <c:forEach items="${ myCalendars }" var="calendar">
				        <li>
				            <a class="col-md-12" href="<c:url value="/calendar/${calendar.id}"/>">${calendar.name}</a>
                        </li>
				    </c:forEach>
				</ul>
			</div>
			<div class="manage-calendars-row col-md-12">
                <h5>Calendars that I participate</h5>
                <ul class="calendars-list">
                    <c:forEach items="${ otherCalendars }" var="calendar">
                        <li>
                            <a class="col-md-12" href="<c:url value="/calendar/${calendar.id}"/>">${calendar.name}</a>
                        </li>
                    </c:forEach>
                </ul>
            </div>
		</div>
	</div>
	
	<!-- MODAL -->
	
      <div id="createModal" class="modal fade" role="dialog">
        <div class="modal-dialog">
          <div class="modal-content">
            <div class="modal-header">
              <button type="button" class="close" data-dismiss="modal">&times;</button>
              <h4 class="modal-title">CREATE CALENDAR</h4>
            </div>
            <div class="modal-body">
              <input type="text" name="name" class="calendar-name" placeholder="Calendar name" />
            </div>
            <button type="submit" class="modal-button conclude">CONCLUIR</button>
          </div>
        </div>
      </div>
      </form>
      
      <script src="<c:url value="/js/jquery-3.2.1.min.js"/>"></script>
      <script src="<c:url value="/js/bootstrap.min.js"/>"></script>

<!-- 	<div class="container"> -->
<!-- 		<div class="main-container row"> -->
<!-- 			<h2>CALENDARS</h2> -->
<!-- 			<ul> -->
<%-- 				<li><c:forEach items="${calendarList}" var="calendar"> --%>
<%-- 						<a href="<c:url value="/calendar/${calendar.id}"/>">${calendar.name}</a> --%>
<!-- 						<br> -->
<%-- 					</c:forEach></li> --%>
<!-- 			</ul> -->
<!-- 		</div> -->
<!-- 	</div> -->
</body>
</html>