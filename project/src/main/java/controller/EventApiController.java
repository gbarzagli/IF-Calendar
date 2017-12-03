package controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.inject.Inject;

import br.com.caelum.vraptor.Consumes;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;
import dao.CalendarDAO;
import dao.EventDAO;
import dao.UserDAO;
import factory.DAOFactory;
import factory.constants.DAOConstants;
import model.Calendar;
import model.Event;
import model.EventApi;
import model.User;

@Controller
public class EventApiController {
	
	@Inject
	private Result result;
	
	@Consumes("application/json")
	@Post
	@Path("/newEvent")
	public void newEvent(EventApi eventApi) throws ParseException {
		if(eventApi != null) {
			User user = new User();
			user.setEmail(eventApi.getEmailUser());
			user.setName(eventApi.getNameUser());
			user.setPassword(eventApi.getPasswordUser());
			
			UserDAO userDAO = (UserDAO) DAOFactory.getDAO(DAOConstants.USER_CLASS);
			userDAO.insert(user);
			
			Calendar calendar = new Calendar();
			calendar.setName(eventApi.getNameCalendar());
			calendar.setCreation(new Date());
			calendar.setOwner(user);
			
			CalendarDAO calendarDAO = (CalendarDAO) DAOFactory.getDAO(DAOConstants.CALENDAR_CLASS);
			calendarDAO.insert(calendar);
			
			Event event = new Event();
			event.setName(eventApi.getNameEvent());
			event.setLocal(eventApi.getLocalEvent());
			event.setCalendar(calendar);
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH");
			event.setStart(dateFormat.parse(eventApi.getStartEvent()));
			event.setEnd(dateFormat.parse(eventApi.getEndEvent()));	
			
			EventDAO eventDAO = (EventDAO) DAOFactory.getDAO(DAOConstants.EVENT_CLASS);
			eventDAO.insert(event);
			
			result.use(Results.status()).created();
		}
		else {
			result.use(Results.status()).badRequest("Preencha todos os campos");
		}
	}
}