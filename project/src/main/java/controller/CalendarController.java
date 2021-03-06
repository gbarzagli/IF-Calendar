package controller;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import component.UserSession;
import dao.CalendarDAO;
import dao.EventDAO;
import dao.UserDAO;
import factory.DAOFactory;
import factory.constants.DAOConstants;
import model.Calendar;
import model.Event;
import model.MonthDays;
import model.Permission;
import model.PermissionId;
import model.User;
import utils.Utils;

@Controller
@Path("/calendar")
public class CalendarController {
	@Inject
	private UserSession userSession;

	@Inject
	private Result result;

	@Path("/create")
	public void create() {
		if (!userSession.isLogged()) {
			result.redirectTo(HomeController.class).index();
		}
		
		result.include("userName", userSession.getUser().getName());
	}

	@Path("/insert")
	public void insert(String name) {
	    if (!userSession.isLogged()) {
            result.redirectTo(HomeController.class).index();
        }
	    
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
	    if (!userSession.isLogged()) {
            result.redirectTo(HomeController.class).index();
        }
	    
		CalendarDAO calendarDAO = (CalendarDAO) DAOFactory.getDAO(DAOConstants.CALENDAR_CLASS);
		List<Calendar> myCalendars = calendarDAO.findCalendarsByUser(userSession.getUser());
		List<Permission> permissionList = userSession.getUser().getPermissions();
		
		List<Calendar> otherCalendars = new ArrayList<>();
		if (permissionList != null) {
			for (Permission permission : permissionList) {
			    otherCalendars.add(permission.getId().getCalendar());
			}
		}

		result.include("userName", userSession.getUser().getName());
		result.include("myCalendars", myCalendars);
		result.include("otherCalendars", otherCalendars);
	}

	@Path("/{calendar.id}")
	public void view(Calendar calendar) {
	    if (!userSession.isLogged()) {
            result.redirectTo(HomeController.class).index();
        }
	    
		CalendarDAO calendarDAO = (CalendarDAO) DAOFactory.getDAO(DAOConstants.CALENDAR_CLASS);
		UserDAO userDAO = (UserDAO) DAOFactory.getDAO(DAOConstants.USER_CLASS);
		EventDAO eventDAO = (EventDAO) DAOFactory.getDAO(DAOConstants.EVENT_CLASS);
		
		User user = userDAO.findByKey(userSession.getUser().getId());		
		calendar = calendarDAO.findByKey(calendar.getId());
		userSession.setCalendar(calendar);
		
		int day = userSession.getDay();
		int month = userSession.getMonth();
		int year = userSession.getYear();
		
		LocalDate localDate = LocalDate.of(year, month, day);
		Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
		
		List<Event> eventList = eventDAO.findEventsByCalendarAndDate(calendar, date);
		boolean isOwner = calendar.getOwner().equals(user);
		boolean canWrite = isOwner;
		
		if (!canWrite) {
			List<Permission> permissionList = calendar.getPermissions();
			for (Permission permission : permissionList) {
				if (permission.getId().getUser().equals(user)) {
					canWrite = permission.canWrite();
					break;
				}
			}
		}
		
        ResourceBundle monthBundle = ResourceBundle.getBundle("month");
        String monthName = monthBundle.getString(Integer.toString(month));

        MonthDays[][] monthDays = Utils.getMonthDays(calendar, month, year);
		
		result.include("canWrite", canWrite);
		result.include("isOwner", isOwner);
		result.include("month", monthName);
		result.include("year", year);
		result.include("calendar", calendar);
		result.include("calendarName", calendar.getName());
		result.include("userName", userSession.getUser().getName());
		result.include("monthDays", monthDays);
		result.include("eventList", eventList);
		result.include("selectedDay", day);
		result.include("showEvents", true);
	}

	@Path("/participants")
	public void participants() {
	    if (!userSession.isLogged()) {
            result.redirectTo(HomeController.class).index();
        }
	    
		CalendarDAO calendarDAO = (CalendarDAO) DAOFactory.getDAO(DAOConstants.CALENDAR_CLASS);
		Calendar calendar = calendarDAO.findByKey(userSession.getCalendar().getId());
		List<Permission> permissionList = calendar.getPermissions();
		

		result.include("userName", userSession.getUser().getName());
		result.include("calendarName", calendar.getName());
		result.include("calendar", calendar);
		result.include("permissionList", permissionList);
	}

	@Path("/saveParticipant")
	public void saveParticipant(String email) {
	    if (!userSession.isLogged()) {
            result.redirectTo(HomeController.class).index();
        }
	    
		UserDAO userDAO = (UserDAO) DAOFactory.getDAO(DAOConstants.USER_CLASS);
		CalendarDAO calendarDAO = (CalendarDAO) DAOFactory.getDAO(DAOConstants.CALENDAR_CLASS);
		Calendar calendar = calendarDAO.findByKey(userSession.getCalendar().getId());

		User user = userDAO.findUserByEmail(email);

		if (user != null) {
			PermissionId permissionId = new PermissionId();
			permissionId.setCalendar(calendar);
			permissionId.setUser(user);
			Permission permission = new Permission();
			permission.setId(permissionId);
			permission.setCanWrite(false);
			List<Permission> permissionList = calendar.getPermissions();
			if (permissionList == null) {
			    permissionList = new ArrayList<>();
			}
			permissionList.add(permission);
			calendar.setPermissions(permissionList);
			calendarDAO.update(calendar);
		}

		result.redirectTo(CalendarController.class).participants();
	}
	
	@Path("/changeMonth/{month}")
    public void changeMonth(int month) {
	    if (!userSession.isLogged()) {
            result.redirectTo(HomeController.class).index();
        }
	    
        int currentMonth = userSession.getMonth();
        int currentYear = userSession.getYear();
        
        int newYear = currentYear;
        int newMonth = currentMonth + month;
        
        if (newMonth < 1) {
            newMonth = 12;
            newYear--;
        } else if (newMonth > 12) {
            newMonth = 1;
            newYear++;
        }
        
        userSession.setMonth(newMonth);
        userSession.setYear(newYear);
        
        result.redirectTo(CalendarController.class).view(userSession.getCalendar());
    }
	
	@Path("/chooseDay/{day}")
	public void chooseDay(int day) {
	    if (!userSession.isLogged()) {
            result.redirectTo(HomeController.class).index();
        }
	    
	    userSession.setDay(day);
	    result.redirectTo(CalendarController.class).view(userSession.getCalendar());
	}

	@Path("/changePermission/{values}")
	@Post
	public void changePermission(String values) {
	    if (!userSession.isLogged()) {
            result.redirectTo(HomeController.class).index();
        }
	    
		String[] listValues = values.split(",");
		CalendarDAO calendarDAO = (CalendarDAO) DAOFactory.getDAO(DAOConstants.CALENDAR_CLASS);
		Calendar calendar = calendarDAO.findByKey(userSession.getCalendar().getId());
		
		for (Permission permission : calendar.getPermissions()) {
			for(int i=0; i<listValues.length; i+=2){
				if(permission.getId().getUser().getId() == Long.parseLong(listValues[i])){
					permission.setCanWrite(Boolean.parseBoolean(listValues[i+1]));
				}
			}
			
		}
		calendarDAO.update(calendar);
		
		result.redirectTo(CalendarController.class).participants();
	}
}
