<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="<c:url value="/css/bootstrap.min.css"/>">
<link rel="stylesheet" href="<c:url value="/css/main.css"/>">
<title>IFCalendar</title>
</head>
<body>
    <%@ include file="../navbar.jsp" %>
    <form action="" method="post">
    <div class="modal-dialog ">
        <div class="modal-content">
            <div class="modal-header ">
                <h4 class="modal-title participants-title">MANAGE PARTICIPANTS</h4>
            </div>
            <div class="modal-body participant-list">
                <ul>
                    <c:forEach items="${permissionList}" var="permission">
                        <li>
                            <div class="col-md-8 col-xs-8 col-sm-8">${permission.id.user.name}</div>
                            <div class="col-md-4 col-xs-4 col-sm-4 pull-right">
		                        <c:if test="${permission.canWrite}">
		                            <label class="switch" onclick="checkPermission(${permission.id.user.id})">
										<input type="checkbox" class="check" checked id="${permission.id.user.id}" name="${permission.id.user.id}">
										<span class="slider round"></span>
									</label>
								</c:if>
								<c:if test="${!permission.canWrite}">
							        <label class="switch" onclick="checkPermission(${permission.id.user.id})">
										<input type="checkbox" class="check" id="${permission.id.user.id}" name="${permission.id.user.id}">
										<span class="slider round"></span>
									</label>
								</c:if>
								Write
							</div>
                        </li>
                    </c:forEach>
                </ul>
                <div class="add-participant-div col-md-12">
                    <input class="col-md-8 col-xs-8 col-sm-8" placeholder="Type user's e-mail" name="email" type="text" />
                    <button class="col-md-4 col-xs-4 col-sm-4 pull-right" onClick="addUser()">ADD USER</button>
                </div>
            </div>
            <button class="modal-button" onClick="changePermissions()">CHANGE PERMISSIONS</button>
        </div>
    </div>
    </form>
    <script src="<c:url value="/js/calendar.js"/>"></script>
</body>
</html>