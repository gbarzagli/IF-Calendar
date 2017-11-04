<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>IF Calendar</title>
<link rel="stylesheet" href="<c:url value="/css/bootstrap.min.css"/>">
<link rel="stylesheet" href="<c:url value="/css/main.css"/>">
</head>
<body>
	<form method="post" action="<c:url value='/login/login'/>">
		<div class="container">
      <div class="main-container row">
        <h2>LOGIN</h2>
        <div class="input-div">
          <input type="text" name="user.email" id="username"/>
          <label for="user.email"><span>USERNAME</span></label>
        </div>
        <div class="input-div">
          <input type="password" name="user.password" id="password"/>
          <label for="user.password"><span>PASSWORD</span></label>
        </div>
        <button name="login" value="login">LOGIN</button>
		<button name="signup" value="signup">SIGNUP</button>
      </div>
    </div>
	</form>
	<script src="<c:url value="/js/jquery-3.2.1.min.js"/>"></script>
	<script src="<c:url value="/js/bootstrap.min.js"/>"></script>
</body>
</html>