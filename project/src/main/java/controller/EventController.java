package controller;

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
@Path("/event")
public class EventController {
	@Inject
	private UserSession userSession;

	@Inject
	private Result result;
	
	@Path("/create")
	public void create(){
		if (!userSession.isLogged()) {
			result.redirectTo(HomeController.class).index();
		}
	}
	
	@Path("/insert")
	public void insert(Event event) throws WrongTransaction {
		EventDAO eventDAO = (EventDAO) DAOFactory.getDAO(DAOConstants.EVENT_CLASS);
		CalendarDAO calendarDAO = (CalendarDAO) DAOFactory.getDAO(DAOConstants.CALENDAR_CLASS);
		System.out.println("AQUI!!!" + userSession.getCalendar().getId());
		Calendar calendar = calendarDAO.findByKey(userSession.getCalendar().getId());
		event.setCalendar(calendar);
		eventDAO.insert(event);		
		result.redirectTo(HomeController.class).index();
	}
}
