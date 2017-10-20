<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Calendar</title>

<script type="text/javascript">
function register() {
	document.forms[0].action = "register";
	document.forms[0].submit;
}
</script>
</head>
<body>
    <c:out value="${ message }"></c:out>
    <form action="login" method="POST">
        <p><input type="text" name="username" alt="Username"></p>
        <p><input type="password" name="password" alt="Password"></p>
        <p><button>Sign in</button><button onclick="register()">Sign up</button></p>
    </form>
</body>
</html>