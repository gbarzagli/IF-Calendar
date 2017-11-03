package controller;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.omg.CORBA.WrongTransaction;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import component.UserSession;
import dao.CalendarDAO;
import dao.EventDAO;
import factory.DAOFactory;
import factory.constants.DAOConstants;
import model.Calendar;
import model.Event;

@Controller
@Path("/calendar")
public class CalendarController {
	@Inject
	private UserSession userSession;

	@Inject
	private Result result;

	@Path("/create")
	public void create() throws WrongTransaction {
		if (!userSession.isLogged()) {
			result.redirectTo(HomeController.class).index();
		}
	}

	@Path("/insert")
	public void insert(String name, String invitedUser) throws WrongTransaction {
		CalendarDAO calendarDAO = (CalendarDAO) DAOFactory.getDAO(DAOConstants.CALENDAR_CLASS);
		Calendar calendar = new Calendar();
		calendar.setName(name);
		calendar.setOwner(userSession.getUser());
		calendar.setCreation(new Date());
		calendarDAO.insert(calendar);

		result.redirectTo(HomeController.class).index();
	}

	@Path("/list")
	public void list() {
		CalendarDAO calendarDAO = (CalendarDAO) DAOFactory.getDAO(DAOConstants.CALENDAR_CLASS);
		List<Calendar> calendarList = calendarDAO.findCalendarsByUser(userSession.getUser());
		result.include("calendarList", calendarList);
	}
	
	@Path("/{calendar.id}")
	  public void view(Calendar calendar) {
		EventDAO eventDAO = (EventDAO) DAOFactory.getDAO(DAOConstants.EVENT_CLASS);
		List<Event> eventList = eventDAO.findEventsByCalendar(calendar);
		userSession.setCalendar(calendar);
		result.include("eventList", eventList);
	  }
}
