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
	<div class="container">
      <div class="main-container row">
      	<form action="" method="post">
	        <h2>${calendar.name }</h2>	
	         <div class="input-div">
		         <ul>		          
		            <c:forEach items="${permissionList}" var="permission">
			            <li>
			              <span>${permission.id.user.name} ------ </span>
			              <c:if test="${permission.canWrite}">
			              	 <input type="checkbox" class="check" checked id="${permission.id.user.id}" name="${permission.id.user.id}">
			              </c:if>
			               <c:if test="${!permission.canWrite}">
			              	 <input type="checkbox" class="check" id="${permission.id.user.id}" name="${permission.id.user.id}">
			              </c:if>
			             </li> 
		            </c:forEach>
		        </ul>		        
		        <button onClick="changePermissions()">Change permissions</button>
	        </div>
	         <div class="input-div">
		        <input type="email" name="email" id="email"/>
		        <label for="email"><span>E-mail</span></label>
		        <button onClick="addUser()">Add user</button>
	        </div>	        
	    </form>
      </div>
    </div>
    <script src="<c:url value="/js/calendar.js"/>"></script>
</body>
</html>