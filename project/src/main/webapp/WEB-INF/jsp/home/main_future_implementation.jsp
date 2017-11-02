<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="<c:url value="/css/bootstrap.min.css"/>">
<link rel="stylesheet" href="<c:url value="/css/main.css"/>">
<link
	href='http://fonts.googleapis.com/css?family=Roboto:400,100,‌​100italic,300,300ita‌​lic,400italic,500,50‌​0italic,700,700itali‌​c,900italic,900'
	rel='stylesheet' type='text/css'>
<script src="<c:url value="/js/jquery-3.2.1.min.js"/>"></script>
<script src="<c:url value="/js/bootstrap.min.js"/>"></script>
<title>IFCalendar</title>
</head>
<body>
	<div class="container calendar-container">
		<div class="row calendar-row">
			<div class="col-md-7 calendar-div">
				<div class="calendar-header">
					<a href="#" class="col-md-4 col-xs-4 col-sm-4"><img
						src="<c:url value="/imgs/move-to-forward.png"/>" width="22"
						height="22" /></a> <span
						class="month-calendar col-md-4 col-xs-4 col-sm-4">Outubro</span> <a
						href="#" class="col-md-4 col-xs-4 col-sm-4"><img
						src="<c:url value="/imgs/move-to-next.png"/>" width="22"
						height="22" /></a>
				</div>
				<div class="calendar-body container">
					<table class="table table-calendar">
						<thead>
							<tr>
								<th>D</th>
								<th>S</th>
								<th>T</th>
								<th>Q</th>
								<th>Q</th>
								<th>S</th>
								<th>S</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td><div></div></td>
								<td><div>1</div></td>
								<td><div>2</div></td>
								<td><div>3</div></td>
								<td><div>4</div></td>
								<td><div>5</div></td>
								<td><div>6</div></td>
							</tr>
							<tr>
								<td><div>7</div></td>
								<td><div>8</div></td>
								<td><div>9</div></td>
								<td><div>10</div></td>
								<td><div>11</div></td>
								<td><div>12</div></td>
								<td><div>13</div></td>
							</tr>
							<tr>
								<td><div>14</div></td>
								<td><div>15</div></td>
								<td><div>16</div></td>
								<td><div>17</div></td>
								<td><div>18</div></td>
								<td><div>19</div></td>
								<td><div>20</div></td>
							</tr>
							<tr>
								<td><div>21</div></td>
								<td><div>22</div></td>
								<td><div>23</div></td>
								<td><div>24</div></td>
								<td><div>25</div></td>
								<td><div>26</div></td>
								<td><div>27</div></td>
							</tr>
							<tr>
								<td><div>28</div></td>
								<td><div>29</div></td>
								<td><div>30</div></td>
								<td><div>31</div></td>
								<td><div></div></td>
								<td><div></div></td>
								<td><div></div></td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
			<div class="col-md-5 events-div">
				<h3>Eventos</h3>
				<div class="event-items col-md-12">
					<div class="info-event">
						<div>
							<span class="event-title">Nome</span> <span class="event-hour">14:00
								- 14:30</span>
						</div>
						<div class="event-description">descrição descrição
							descriçãodescrição descrição descrição descrição descrição
							descrição</div>
						<div class="action-buttons">
							<button>
								<img width="20" height="20"
									src="<c:url value="/imgs/trash-can.png"/>" />
							</button>
							<button>
								<img width="20" height="20"
									src="<c:url value="/imgs/pencil-edit-button.png"/>" />
							</button>
						</div>
					</div>
					<div class="info-event">
						<div>
							<span class="event-title"> <!-- <input type="text" placeholder="Nome"/> -->
								<input type="text" name="name" class="add-event-day" id="nme"
								required autocomplete="off" /> <label for="name"><span>Nome
										do evento</span></label>
							</span> <span class="event-hour"> <select>
									<option value="">14:30</option>
									<option value="">15:00</option>
									<option value="">15:30</option>
									<option value="">16:00</option>
							</select> até <select>
									<option value="">14:30</option>
									<option value="">15:00</option>
									<option value="">15:30</option>
									<option value="">16:00</option>
							</select>
							</span>
						</div>
						<div class="event-description">
							<!-- <textarea type="text" placeholder="descrição"></textarea> -->
							<textarea name="descp" rows="2" class="add-event-day" id="dscrp"
								required autocomplete="off"></textarea>
							<label for="dscrp"><span>Descrição</span></label>
						</div>
						<div class="action-buttons">
							<button>
								<img width="20" height="20"
									src="<c:url value="/imgs/check-mark.png"/>" />
							</button>
							<button>
								<img width="20" height="20"
									src="<c:url value="/imgs/trash-can.png"/>" />
							</button>
							<button>
								<img width="20" height="20"
									src="<c:url value="/imgs/pencil-edit-button.png"/>" />
							</button>
						</div>
					</div>
				</div>
				<button class="add-event">+</button>
			</div>
		</div>
	</div>
</body>
</html>