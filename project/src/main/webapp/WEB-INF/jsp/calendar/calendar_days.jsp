<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<form action="">
<div class="col-md-7 calendar-div">
    <div class="calendar-header">
        <a href="<c:url value="/calendar/changeMonth/-1"/>" class="col-md-4 col-xs-4 col-sm-4">
            <img src="<c:url value="/imgs/move-to-forward.png"/>" width="22" height="22" />
        </a>
        <div class="month-calendar col-md-4 col-xs-4 col-sm-4">
            <p>${ year }</p>
            <p>${ month }</p>
        </div>
        <a href="<c:url value="/calendar/changeMonth/1"/>" class="col-md-4 col-xs-4 col-sm-4">
            <img src="<c:url value="/imgs/move-to-next.png"/>" width="22" height="22" />
        </a>
    </div>
    <div class="calendar-body container">
        <table class="table table-calendar">
            <thead>
                <tr>
                    <th>D</th>
                    <th>S</th>
                    <th>T</th>
                    <th>Q</th>
                    <th>Q</th>
                    <th>S</th>
                    <th>S</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach begin="0" end="5" var="line">
                    <tr>
                        <c:forEach begin="0" end="6" var="column">
                            <td>
                                <c:if test="${ not empty monthDays[line][column].day }">
                                    <c:if test="${ monthDays[line][column].day eq selectedDay }">
	                                    <div onclick="chooseDay(this)" class="selected-day">
	                                        ${ monthDays[line][column].day }
	                                    </div>
	                                </c:if>
	                                <c:if test="${ monthDays[line][column].day ne selectedDay }">
	                                   <c:if test="${ monthDays[line][column].hasEvent }">
		                                   <div onclick="chooseDay(this)">
	                                            <a>${ monthDays[line][column].day }</a>
	                                       </div>
                                       </c:if>
                                       <c:if test="${ !monthDays[line][column].hasEvent }">
		                                   <div onclick="chooseDay(this)">
	                                            ${ monthDays[line][column].day }
	                                       </div>
                                       </c:if>
	                                </c:if>
                                </c:if>
                            </td>
                        </c:forEach>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</form>