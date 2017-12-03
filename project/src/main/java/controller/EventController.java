package controller;

import java.util.Date;

import javax.inject.Inject;

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
	public void insert(Event event, String startTime, String endTime) {
		EventDAO eventDAO = (EventDAO) DAOFactory.getDAO(DAOConstants.EVENT_CLASS);
		CalendarDAO calendarDAO = (CalendarDAO) DAOFactory.getDAO(DAOConstants.CALENDAR_CLASS);
		Calendar calendar = calendarDAO.findByKey(userSession.getCalendar().getId());
		event.setCalendar(calendar);
		event.setSent(false);
		userSession.setYear(2017);
		userSession.setMonth(12);
		userSession.setDay(3);
		
		java.util.Calendar startDate = java.util.Calendar.getInstance();
		java.util.Calendar endDate = java.util.Calendar.getInstance();
		
		String[] composedStartTime = startTime.split(":");
		String[] composedEndTime = startTime.split(":");
		
		int startingHour = Integer.parseInt(composedStartTime[0]);
		int startingMinutes = Integer.parseInt(composedStartTime[1]);
		
		int endingHour = Integer.parseInt(composedEndTime[0]);
		int endingMinutes = Integer.parseInt(composedEndTime[1]);
		
		startDate.set(userSession.getYear(), userSession.getMonth(), userSession.getDay(), startingHour, startingMinutes);
		endDate.set(userSession.getYear(), userSession.getMonth(), userSession.getDay(), endingHour, endingMinutes);
		
		event.setStart(startDate.getTime());
		event.setEnd(endDate.getTime());
		
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
	    result.redirectTo(HomeController.class).main();
	}
}
