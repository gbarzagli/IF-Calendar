<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="col-md-5 events-div">
    <h3>Eventos</h3>
    <div class="event-items col-md-12">
        <c:forEach items="${eventList}" var="event">
	        <div class="info-event">
	            <div>
	                <span class="event-title">${ event.name }</span>
	                <span class="event-hour">${ event.eventTime }</span>
	            </div>
	            <div class="event-description">${ event.local }</div>
	            <div class="action-buttons">
	                <a href="<c:url value="/event/delete/${event.id}" />">
	                    <img width="20" height="20" src="<c:url value="/imgs/trash-can.png"/>" />
	                </a>
	                <a href="<c:url value="/event/edit/${event.id}" />">
	                    <img width="20" height="20" src="<c:url value="/imgs/pencil-edit-button.png"/>" />
	                </a>
	            </div>
	        </div>
        </c:forEach>
    </div>
    <button type="button" class="add-event" onclick="insertEvent()">+</button>
</div>