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
import br.com.caelum.vraptor.Result;
import component.UserSession;
import dao.CalendarDAO;
import dao.EventDAO;
import dao.UserDAO;
import factory.DAOFactory;
import factory.constants.DAOConstants;
import model.Calendar;
import model.Event;
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
	}

	@Path("/insert")
	public void insert(String name) {
	    if (name == null || name.trim().isEmpty()) {
	        result.include("message", "You can not create a calendar without name!");
	        result.redirectTo(CalendarController.class).list();
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
		CalendarDAO calendarDAO = (CalendarDAO) DAOFactory.getDAO(DAOConstants.CALENDAR_CLASS);
		List<Calendar> myCalendars = calendarDAO.findCalendarsByUser(userSession.getUser());
		List<Permission> permissionList = userSession.getUser().getPermissions();
		
		List<Calendar> otherCalendars = new ArrayList<>();
		if (permissionList != null) {
			for (Permission permission : permissionList) {
			    otherCalendars.add(permission.getId().getCalendar());
			}
		}

		result.include("myCalendars", myCalendars);
		result.include("otherCalendars", otherCalendars);
	}

	@Path("/{calendar.id}")
	public void view(Calendar calendar) {
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
		boolean canWrite = calendar.getOwner().equals(user);
		
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

        String[][] monthDays = Utils.getMonthDays(month, year);
		
		result.include("canWrite", canWrite);
		result.include("month", monthName);
		result.include("year", year);
		result.include("calendarName", calendar.getName());
		result.include("calendar", monthDays);
		result.include("eventList", eventList);
		result.include("selectedDay", day);
		result.include("showEvents", true);
	}

	@Path("/participants")
	public void participants() {
		CalendarDAO calendarDAO = (CalendarDAO) DAOFactory.getDAO(DAOConstants.CALENDAR_CLASS);
		Calendar calendar = calendarDAO.findByKey(userSession.getCalendar().getId());
		List<Permission> permissionList = calendar.getPermissions();
		List<User> userList = new ArrayList<User>();
		for (Permission permission : permissionList) {
			PermissionId permissionId = permission.getId();
			User user = permissionId.getUser();
			userList.add(user);
		}

		result.include("calendar", calendar);
		result.include("userList", userList);
	}

	@Path("/saveParticipant")
	public void saveParticipant(String email) {
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
			permissionList.add(permission);
			calendar.setPermissions(permissionList);
			calendarDAO.update(calendar);
		}
		// TODO create a else block to inform user that the email is not valid

		result.redirectTo(CalendarController.class).participants();
	}
	
	@Path("/changeMonth/{month}")
    public void changeMonth(int month) {
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
	    userSession.setDay(day);
	    result.redirectTo(CalendarController.class).view(userSession.getCalendar());
	}

	@Path("changePermission")
	public void changePermission() {
	    // TODO create change permission method
	}
}
