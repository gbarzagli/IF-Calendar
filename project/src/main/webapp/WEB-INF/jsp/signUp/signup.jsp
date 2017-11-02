<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Insert title here</title>

	<link rel="stylesheet" href="<c:url value="/css/bootstrap.min.css"/>">
    <link rel="stylesheet" href="<c:url value="/css/signup.css"/>">
</head>
<body>
	<form method="post" action="<c:url value='/signUp/insert'/>">
		<div class="signup-page-bg">
	    	<div class="container">
	    		<div class="row">
					<div class="signup-container col-md-push-4 col-md-4 col-sm-push-4 col-sm-4 col-lg-push-4 col-lg-4">
	            		<h3>SignUp!</h3>
	            		<label for="name">Name</label>
	            		<input type="text" id="name" name="user.name"/>
	            		<label for="username">email</label>
	            		<input type="email" placeholder="example@example.com" id="username" name="user.email"/>
	            		<label for="password">Password</label>
	            		<input type="password" id="password" name="user.password"/>
	            		<button class="button-primary">SIGNUP</button>
	            		<span class="signup-error"><c:if test="${not empty validation}"><c:out value="${validation}"></c:out></c:if></span>
	          		</div>
	        	</div>
	      	</div>
	    </div>
	</form>
	
	<script src="<c:url value="/js/jquery-3.2.1.min.js"/>"></script>
    <script src="<c:url value="/js/bootstrap.min.js"/>"></script>
</body>
</html>