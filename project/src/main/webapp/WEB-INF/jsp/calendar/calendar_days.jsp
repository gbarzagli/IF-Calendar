<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="col-md-7 calendar-div">
    <div class="calendar-header">
        <a href="<c:url value="/calendar/changeMonth/-1"/>" class="col-md-4 col-xs-4 col-sm-4">
            <img src="<c:url value="/imgs/move-to-forward.png"/>" width="22" height="22" />
        </a>
        <span class="month-calendar col-md-4 col-xs-4 col-sm-4">${ month }</span>
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
                                <c:if test="${ calendar[line][column] ne '' }">
                                    <div onclick="">
                                        ${ calendar[line][column] }
                                    </div>
                                </c:if>
                            </td>
                        </c:forEach>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</div>