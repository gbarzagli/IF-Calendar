package controller;

import static utils.Utils.getMonthDays;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.inject.Inject;

import org.apache.commons.mail.EmailException;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import component.UserSession;
import dao.CalendarDAO;
import factory.DAOFactory;
import factory.constants.DAOConstants;
import model.Calendar;
import model.Event;
import model.User;

@Controller
public class HomeController {

    @Inject
    private UserSession userSession;

    @Inject
    private Result result;

    @Path("/main")
    public void main(User user, int day, int month, int year) {
        if (!userSession.isLogged()) {
            result.redirectTo(LoginController.class).index();
        }
        
        ResourceBundle monthBundle = ResourceBundle.getBundle("month");
        String monthName = monthBundle.getString(Integer.toString(month));

        String[][] monthDays = getMonthDays(month, year);

        CalendarDAO calendarDAO = (CalendarDAO) DAOFactory.getDAO(DAOConstants.CALENDAR_CLASS);
        List<Calendar> calendars = calendarDAO.findCalendarsByUser(userSession.getUser());
        
        java.util.Calendar date = java.util.Calendar.getInstance();
        date.set(year, month, day);
        List<Event> events = new ArrayList<Event>();
        for (Calendar calendar : calendars) {
            events.addAll(calendar.getEvents());
        }

        result.include("month", monthName);
        result.include("calendar", monthDays);
        result.include("eventList", events);
        result.include("calendars", calendars);
        result.include("showEvents", true);
        result.include("selectedDay", day);
    }

    /**
     * Method responsible to the first page of this app.
     * @throws EmailException 
     */
    @Path("/")
    public void index() {        
        if (!userSession.isLogged()) {
            result.redirectTo(LoginController.class).index();
        } else {
            LocalDate localDate = LocalDate.now();
            Month month = localDate.getMonth();
            int monthInt = month.getValue();
            int year = localDate.getYear();

            result.redirectTo(HomeController.class).main(userSession.getUser(), -1, monthInt, year);
        }
    }
}
