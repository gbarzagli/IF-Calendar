package controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
	public void insert(String name, String invitedUser) {
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
		List<Permission> permissionList = userSession.getUser().getPermissions();

		if (permissionList != null) {
			for (Permission permission : permissionList) {
				calendarList.add(permission.getId().getCalendar());
			}
		}

		result.include("calendarList", calendarList);
	}

	@Path("/{calendar.id}")
	public void view(Calendar calendar) {
		CalendarDAO calendarDAO = (CalendarDAO) DAOFactory.getDAO(DAOConstants.CALENDAR_CLASS);
		UserDAO userDAO = (UserDAO) DAOFactory.getDAO(DAOConstants.USER_CLASS);
		EventDAO eventDAO = (EventDAO) DAOFactory.getDAO(DAOConstants.EVENT_CLASS);
		
		User user = userDAO.findByKey(userSession.getUser().getId());		
		calendar = calendarDAO.findByKey(calendar.getId());
		
		int day = userSession.getDay();
		int month = userSession.getMonth();
		int year = userSession.getYear();
		
		List<Event> eventList = eventDAO.findEventsByCalendar(calendar);
		userSession.setCalendar(calendar);
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
		result.include("canWrite", canWrite);
		result.include("calendar", calendar);
		result.include("eventList", eventList);
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

	@Path("changePermission")
	public void changePermission() {
	    // TODO create change permission method
	}
}
