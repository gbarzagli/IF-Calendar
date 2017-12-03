<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="col-md-5 events-div">
    <h3>Eventos</h3>
    <div class="event-items col-md-12">
        <c:if test="${ not empty eventList }">
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
        </c:if>
        <c:if test="${ empty eventList }">
	        <form action="<c:url value="/event/insert" />">
	            <div class="info-event">
		            <div>
		                <span class="event-title">
		                    <input type="text" name="name" class="add-event-day" id="nme" required autocomplete="off" />
		                    <label for="name">
		                        <span>Nome do evento</span>
		                    </label>
		                </span>
		                <span class="event-hour">
		                    <select name="startHour">
		                        <option value="0">00:00</option>
		                        <option value="1">01:00</option>
		                        <option value="2">02:00</option>
		                        <option value="3">03:00</option>
		                        <option value="4">04:00</option>
		                        <option value="5">05:00</option>
		                        <option value="6">06:00</option>
		                        <option value="7">07:00</option>
		                        <option value="8">08:00</option>
		                        <option value="9">09:00</option>
		                        <option value="10">10:00</option>
		                        <option value="11">11:00</option>
		                        <option value="12">12:00</option>
		                        <option value="13">13:00</option>
		                        <option value="14">14:00</option>
		                        <option value="15">15:00</option>
		                        <option value="16">16:00</option>
		                        <option value="17">17:00</option>
		                        <option value="18">18:00</option>
		                        <option value="19">19:00</option>
		                        <option value="20">20:00</option>
		                        <option value="21">21:00</option>
		                        <option value="22">22:00</option>
		                        <option value="23">23:00</option>
		                    </select>
		                    até
		                    <select name="endHour">
		                        <option value="0">00:00</option>
		                        <option value="1">01:00</option>
		                        <option value="2">02:00</option>
		                        <option value="3">03:00</option>
		                        <option value="4">04:00</option>
		                        <option value="5">05:00</option>
		                        <option value="6">06:00</option>
		                        <option value="7">07:00</option>
		                        <option value="8">08:00</option>
		                        <option value="9">09:00</option>
		                        <option value="10">10:00</option>
		                        <option value="11">11:00</option>
		                        <option value="12">12:00</option>
		                        <option value="13">13:00</option>
		                        <option value="14">14:00</option>
		                        <option value="15">15:00</option>
		                        <option value="16">16:00</option>
		                        <option value="17">17:00</option>
		                        <option value="18">18:00</option>
		                        <option value="19">19:00</option>
		                        <option value="20">20:00</option>
		                        <option value="21">21:00</option>
		                        <option value="22">22:00</option>
		                        <option value="23">23:00</option>
		                    </select>
		                </span>
		            </div>
		            <div class="event-description">
		                <textarea name="descp" rows="2" class="add-event-day" id="dscrp" required autocomplete="off"></textarea>
		                <label for="dscrp">
		                    <span>Descrição</span>
		                </label>
		            </div>
		            <div class="action-buttons">
		                <button>
		                    <img width="20" height="20" src="<c:url value="/imgs/check-mark.png"/>" />
		                </button>
		                <button>
		                    <img width="20" height="20" src="<c:url value="/imgs/trash-can.png"/>" />
		                </button>
		                <button>
		                    <img width="20" height="20" src="<c:url value="/imgs/pencil-edit-button.png"/>" />
		                </button>
		            </div>
	            </div>
	        </form>
        </c:if>
    </div>
    <button class="add-event">+</button>
</div>