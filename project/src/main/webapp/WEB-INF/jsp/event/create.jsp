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
        <h2>CREATE EVENT</h2>
        <form action="<c:url value="/event/insert"/>" method="post">
          <div class="input-div">
            <label for="name"><span>NAME</span></label>
            <input type="text" name="event.name" required/>
          </div>
          <div class="input-div">
            <label for="description"><span>DESCRIPTION</span></label>
            <input type="text" name="event.local" required/>
          </div>
          <div class="input-div">
            <label for="startTime"><span>STARTING TIME</span></label>
            <input type="time" name="startTime"/>
          </div>
          <div class="input-div">
            <label for="endTime"><span>ENDING TIME</span></label>
            <input type="time" name="endTime"/>
          </div>
      		<input type="submit" value="CREATE"/>
      	</form>
      </div>
    </div>
</body>
</html>