<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
	<head>
	    <meta charset="utf-8">
	    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	    <link rel="stylesheet" href="<c:url value="/css/bootstrap.min.css"/>">
	    <link rel="stylesheet" href="<c:url value="/css/main.css"/>">
	    <link href="http://fonts.googleapis.com/css?family=Roboto:400,100,‌​100italic,300,300ita‌​lic,400italic,500,50‌​0italic,700,700itali‌​c,900italic,900" rel="stylesheet" type="text/css">
	    
	    <title>IFCalendar</title>
	</head>
	
	<body>
	    <%@ include file="../navbar.jsp" %>
	    <div class="container calendar-container">
	        <div class="row calendar-row">
	            <div class="header-main-calendar">
	                <div class="col-md-6 col-sm-12 col-xs-12 pull-right div-p">&nbsp;</div>
	                <c:if test="${ canWrite }">
					    <button class="col-md-6 col-sm-12 col-xs-12 pull-right btn-p">
					       Manage participants
					    </button>
				    </c:if>
				    <c:if test="${ !canWrite }">
                        <div class="col-md-6 col-sm-12 col-xs-12 pull-right div-p">&nbsp;</div>
                    </c:if>
				</div>
	            <%@ include file="calendar_days.jsp" %>
	            <c:if test="${ showEvents eq true }">
	               <%@ include file="event_panel.jsp" %>
	            </c:if>
	        </div>
	    </div>
	
	    <script src="<c:url value="/js/jquery-3.2.1.min.js"/>"></script>
	    <script src="<c:url value="/js/bootstrap.min.js"/>"></script>
	    <script src="<c:url value="/js/calendar.js"/>"></script>
	</body>
</html>