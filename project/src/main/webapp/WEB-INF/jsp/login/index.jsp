<%@ page language="java" contentType="text/html; charset=UTF-8"
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
    <title>IFCalendar - Login</title>
  </head>
  <body class="login-body">
  	<form method="post" action="<c:url value='/login/login'/>">
	    <div class="login-page-bg">
	      <div class="container">
	        <div class="row">
	          <div class="login-container col-md-push-4 col-md-4 col-sm-push-4 col-sm-4 col-lg-push-4 col-lg-4">
	            <h3>LOGIN!</h3>
	            <label for="user.email">USERNAME</label>
	            <input type="email" name="user.email" placeholder="example@example.com" id="username"/>
	            <label for="user.password">PASSWORD</label>
	            <input type="password" name="user.password" id="password"/>
	            <div id="divButtonsLogin" class="divButtonsLogin">
		            <button class="button-primary" name="login" value="login">LOGIN</button>
					<button class="button-primary" name="signup" value="signup">SIGNUP</button>
	            </div>
	          </div>
	        </div>
	      </div>
	    </div>
    </form>
    <script src="<c:url value="/js/jquery-3.2.1.min.js"/>"></script>
    <script src="<c:url value="/js/bootstrap.min.js"/>"></script>
  </body>
</html>
