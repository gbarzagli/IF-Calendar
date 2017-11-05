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
		            <c:forEach items="${userList}" var="user">
			            <li>
			              <span>${user.name} ------ </span> 
			              <input type="checkbox" id="${user.id}" name="${user.id}">
			             </li> 
		            </c:forEach>
		        </ul>		        
		        <button onClick="">Change permissions</button>
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