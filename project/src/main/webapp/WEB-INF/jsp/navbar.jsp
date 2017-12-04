<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<nav class="navbar navbar-default">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand">IF Calendar</a>
    </div>
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <c:if test="${ not empty calendarName }">
	        <li class="active"><a>${ calendarName }</a></li>
	        <li><a href="<c:url value="/calendar/list" />">MANAGE CALENDARS</a></li>
        </c:if>
        <c:if test="${ empty calendarName }">
            <li class="active"><a href="<c:url value="/calendar/list" />">MANAGE CALENDARS</a></li>
        </c:if>
      </ul>
      <a class="pull-right logout" href="<c:url value="/logout" />">LOGOUT</a>
    </div>
  </div>
</nav>