package controller;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.List;

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
import model.Permission;
import model.PermissionId;
import model.User;
import utils.Email;

@Controller
@Path("/event")
public class EventController {
    @Inject
    private UserSession userSession;

    @Inject
    private Result result;

    @Path("/create")
    public void create() {
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

        java.util.Calendar startDate = java.util.Calendar.getInstance();
        java.util.Calendar endDate = java.util.Calendar.getInstance();

        String[] composedStartTime = startTime.split(":");
        String[] composedEndTime = endTime.split(":");

        int startingHour = Integer.parseInt(composedStartTime[0]);
        int startingMinutes = Integer.parseInt(composedStartTime[1]);

        int endingHour = Integer.parseInt(composedEndTime[0]);
        int endingMinutes = Integer.parseInt(composedEndTime[1]);

        startDate.set(userSession.getYear(), userSession.getMonth() - 1, userSession.getDay(), startingHour, startingMinutes);
        endDate.set(userSession.getYear(), userSession.getMonth() - 1, userSession.getDay(), endingHour, endingMinutes);

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
        
        LocalDateTime startDateTime = LocalDateTime.ofInstant(event.getStart().toInstant(), ZoneId.systemDefault());
        LocalDateTime endDateTime = LocalDateTime.ofInstant(event.getEnd().toInstant(), ZoneId.systemDefault());
        
        LocalTime startTime = startDateTime.toLocalTime();
        LocalTime endTime = endDateTime.toLocalTime();
        
        result.include("startTime", startTime.toString());
        result.include("endTime", endTime.toString());
        result.include("event", event);
    }

    @Path("/edit/{event.id}/update")
    public void update(Event event, String startTime, String endTime) {
        EventDAO eventDAO = (EventDAO) DAOFactory.getDAO(DAOConstants.EVENT_CLASS);
        CalendarDAO calendarDAO = (CalendarDAO) DAOFactory.getDAO(DAOConstants.CALENDAR_CLASS);
        Calendar calendar = calendarDAO.findByKey(userSession.getCalendar().getId());
        event.setCalendar(calendar);

        java.util.Calendar startDate = java.util.Calendar.getInstance();
        java.util.Calendar endDate = java.util.Calendar.getInstance();

        String[] composedStartTime = startTime.split(":");
        String[] composedEndTime = endTime.split(":");

        int startingHour = Integer.parseInt(composedStartTime[0]);
        int startingMinutes = Integer.parseInt(composedStartTime[1]);

        int endingHour = Integer.parseInt(composedEndTime[0]);
        int endingMinutes = Integer.parseInt(composedEndTime[1]);

        startDate.setTime(event.getStart());
        endDate.setTime(event.getEnd());
        
        startDate.set(java.util.Calendar.HOUR, startingHour);
        startDate.set(java.util.Calendar.MINUTE, startingMinutes);
        
        endDate.set(java.util.Calendar.HOUR, endingHour);
        endDate.set(java.util.Calendar.MINUTE, endingMinutes);
        
        event.setStart(startDate.getTime());
        event.setEnd(endDate.getTime());
        
        eventDAO.update(event);
        result.redirectTo(CalendarController.class).view(calendar);
    }

    @Path("/delete/{event.id}")
    public void delete(Event event) {
        EventDAO eventDAO = (EventDAO) DAOFactory.getDAO(DAOConstants.EVENT_CLASS);
        event = eventDAO.findByKey(event.getId());
        
        Email email = new Email();
        String owner = event.getCalendar().getOwner().getEmail();
        String subject = "Event canceled!";
        String message = "The event " + event.getName() + " was canceled... :(";
        
        email.send(owner, subject, message);
        List<Permission> permissionList = event.getCalendar().getPermissions();
        for (Permission permission : permissionList) {
            PermissionId permissionId = permission.getId();
            User user = permissionId.getUser();
            email.send(user.getEmail(), subject, message);                                  
        }
        
        eventDAO.remove(event.getId());
        result.redirectTo(CalendarController.class).view(userSession.getCalendar());
    }
}
