<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="header-main-calendar">
	<select class="calendars-i-can-see col-md-6">
	   <c:forEach items="${ calendars }" var="calendar">
	       <option value="${ calendar.id }">${ calendar.name }</option>
	   </c:forEach>
	</select>
	<button class="col-md-6 col-sm-12 col-xs-12 pull-right btn-p" data-toggle="modal" data-target="#addParticipantModal">
	   Manage participants
	</button>
</div>