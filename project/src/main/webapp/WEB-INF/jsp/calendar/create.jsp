<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="<c:url value="/css/bootstrap.min.css"/>">
<link rel="stylesheet" href="<c:url value="/css/main.css"/>">
<title>IFCalendar</title>
</head>
<body>
	<div class="container">
      <form action="<c:url value="/calendar/insert"/>" method="post" class="main-container row">
        <h2>CREATE SOMETHING</h2>
        <div class="input-div">
          <input type="text" name="name" id="name" required/>
          <label for="name"><span>NAME</span></label>
        </div>        
        <input type="submit" value="CONFIRM"/>
      </form>
    </div>
</body>
</html>