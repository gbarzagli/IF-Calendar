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
  
	<form method="post" action="<c:url value='/home/login'/>">
		<div class="login-page-bg">
	    	<div class="container">
	    		<div class="row">
					<div class="login-container col-md-push-4 col-md-4 col-sm-push-4 col-sm-4 col-lg-push-4 col-lg-4">
	            		<h3>Faça seu login!</h3>
	            		<label for="username">Usuário</label>
	            		<input type="email" placeholder="example@example.com" id="username" name="user.login"/>
	            		<label for="password">Senha</label>
	            		<input type="password" id="password" name="user.password"/>
	            		<button class="button-primary">LOGIN</button>
	          		</div>
	        	</div>
	      	</div>
	    </div>
	</form>
	
	<script src="<c:url value="/js/jquery-3.2.1.min.js"/>"></script>
    <script src="<c:url value="/js/bootstrap.min.js"/>"></script>
</body>
</html>