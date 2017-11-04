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
            <input type="text" name="event.name" required/>
            <label for="name"><span>NAME</span></label>
          </div>
          <div class="input-div">
            <input type="text" name="event.local" required/>
            <label for="place"><span>PLACE</span></label>
          </div>
          <div class="input-div">
            <input type="date" name="event.start"/>
            <label for="startDate"><span>STARTING DATE</span></label>
          </div>
          <div class="input-div">
            <input type="date" name="event.end"/>
            <label for="endDate"><span>ENDING DATE</span></label>
          </div>
      		<input type="submit" value="CREATE"/>
      	</form>
      </div>
    </div>
</body>
</html>