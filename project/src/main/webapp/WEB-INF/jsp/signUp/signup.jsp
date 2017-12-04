<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="<c:url value="/css/bootstrap.min.css"/>">
    <link rel="stylesheet" href="<c:url value="/css/main.css"/>">
    <link href="http://fonts.googleapis.com/css?family=Roboto:400,100,‌​100italic,300,300ita‌​lic,400italic,500,50‌​0italic,700,700itali‌​c,900italic,900" rel="stylesheet" type="text/css">
    <title>IFCalendar - SignUp</title>
  </head>
  <body class="login-body">
  	<form method="post" action="<c:url value='/signup/insert'/>">
	    <div class="login-page-bg">
	      <div class="container">
	        <div class="row">
	          <div class="login-container col-md-push-4 col-md-4 col-sm-push-4 col-sm-4 col-lg-push-4 col-lg-4">
	            <h3>SIGN UP!</h3>
	            <label for="name">NAME</label>
	            <input type="text" id="name" name="user.name"/>
	            <label for="username">USERNAME</label>
	            <input type="email" name="user.email" id="username"/>
	            <label for="password">PASSWORD</label>
	            <input type="password" name="user.password" id="password"/>
	            <div id="divButtonsLogin" class="divButtonsLogin">
			        <button class="button-primary" id="buttonConfirmSigup">CONFIRM</button>
			        <button type="button" class="button-primary" id="buttonCancel" onclick="cancelSignup()">CANCEL</button>
		        </div>
		        <span class="signup-error"><c:if test="${not empty validation}">
		        <c:out value="${validation}"></c:out></c:if></span>
	          </div>
	        </div>
	      </div>
	    </div>
    </form>
    <script src="<c:url value="/js/jquery-3.2.1.min.js"/>"></script>
    <script src="<c:url value="/js/bootstrap.min.js"/>"></script>
    <script src="<c:url value="/js/main.js"/>"></script>
  </body>
</html>