<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>IFCalendar</title>
	<link rel="stylesheet" href="<c:url value="/css/bootstrap.min.css"/>">
	<link rel="stylesheet" href="<c:url value="/css/main.css"/>">
</head>
<body>
	 <div class="container">
      <div class="main-container row">
        <h2>SIGN UP</h2>
        <form method="post" action="<c:url value='/signup/insert'/>">
            <div class="input-div">
              <input type="text" id="name" name="user.name"/>
              <label for="name"><span>NAME</span></label>
            </div>
            <div class="input-div">
              <input type="email" id="username" name="user.email"/>
              <label for="username"><span>E-MAIL</span></label>
            </div>
            <div class="input-div">
              <input type="password" id="password" name="user.password"/>
              <label for="password"><span>PASSWORD</span></label>
            </div>
        		<button class="button-primary">CONFIRM</button>
        		<span class="signup-error"><c:if test="${not empty validation}"><c:out value="${validation}"></c:out></c:if></span>
  	     </form>
       </div>
    </div>
	
	<script src="<c:url value="/js/jquery-3.2.1.min.js"/>"></script>
    <script src="<c:url value="/js/bootstrap.min.js"/>"></script>
</body>
</html>