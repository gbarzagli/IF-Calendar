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
		Calendar calendar = calendarDAO.findByKey(userSession.getCalendar().getId());
		event.setCalendar(calendar);
		eventDAO.insert(event);		
		result.redirectTo(CalendarController.class).view(calendar);
	}
	
	@Path("/{event.id}")
	public void view(Event event) {
	    if (!userSession.isLogged()) {
            result.redirectTo(HomeController.class).index();
        }
	    
	    EventDAO eventDAO = (EventDAO) DAOFactory.getDAO(DAOConstants.EVENT_CLASS);
	    event = eventDAO.findByKey(event.getId());
	    result.include("event", event);
	}
	
	@Path("/edit/{event.id}")
	public void edit(Event event) {
	    if (!userSession.isLogged()) {
            result.redirectTo(HomeController.class).index();
        }
	    
	    EventDAO eventDAO = (EventDAO) DAOFactory.getDAO(DAOConstants.EVENT_CLASS);
	    event = eventDAO.findByKey(event.getId());
	    result.include("event", event);
	}
	
	@Path("/edit/{event.id}/update")
    public void update(Event event) {
        EventDAO eventDAO = (EventDAO) DAOFactory.getDAO(DAOConstants.EVENT_CLASS);
        CalendarDAO calendarDAO = (CalendarDAO) DAOFactory.getDAO(DAOConstants.CALENDAR_CLASS);
        Calendar calendar = calendarDAO.findByKey(userSession.getCalendar().getId());
        event.setCalendar(calendar);
        eventDAO.update(event);
        event = eventDAO.findByKey(event.getId());
        result.redirectTo(CalendarController.class).view(event.getCalendar());
    }
	
	@Path("/delete/{event.id}")
	public void delete(Event event) {
	    EventDAO eventDAO = (EventDAO) DAOFactory.getDAO(DAOConstants.EVENT_CLASS);
	    event = eventDAO.findByKey(event.getId());
	    eventDAO.remove(event.getId());
	    result.redirectTo(CalendarController.class).view(event.getCalendar());
	}
}
