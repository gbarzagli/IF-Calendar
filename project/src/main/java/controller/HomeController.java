package controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import component.UserSession;

@Controller
public class HomeController {

    @Inject
    private UserSession userSession;

    @Inject
    private Result result;
    
    @Path("/main")
    public void main() {
        if (!userSession.isLogged()) {
            result.redirectTo(LoginController.class).index();
        }
    }

    /**
     * Method responsible to the first page of this app.
     */
    @Path("/")
    public void index() {
        if (userSession.getEmail() == null) {
            userSession.setEmail(new utils.Email());
            userSession.getEmail().start();
        }
        
        if (!userSession.isLogged()) {
            result.redirectTo(LoginController.class).index();
        } else {
            result.redirectTo(HomeController.class).main();
        }
    }

//    @Path("/main")
//    public void main() {
//        if (!userSession.isLogged()) {
//            result.redirectTo(LoginController.class).index();
//        }
//        
//        int day = userSession.getDay();
//        int month = userSession.getMonth();
//        int year = userSession.getYear();
//        
//        ResourceBundle monthBundle = ResourceBundle.getBundle("month");
//        String monthName = monthBundle.getString(Integer.toString(month));
//
//        String[][] monthDays = getMonthDays(month, year);
//
//        CalendarDAO calendarDAO = (CalendarDAO) DAOFactory.getDAO(DAOConstants.CALENDAR_CLASS);
//        List<Calendar> calendars = calendarDAO.findCalendarsByUser(userSession.getUser());
//        
//        if(calendars.isEmpty()) {
//            result.redirectTo(CalendarController.class).create();
//        }
//        
//        java.util.Calendar date = java.util.Calendar.getInstance();
//        date.set(year, month, day);
//        List<Event> events = new ArrayList<Event>();
//        for (Calendar calendar : calendars) {
//            events.addAll(calendar.getEvents());
//        }
//
//        result.include("month", monthName);
//        result.include("calendar", monthDays);
//        result.include("eventList", events);
//        result.include("calendars", calendars);
//        result.include("selectedDay", day);
//        result.include("showEvents", true);
//    }
//
//    /**
//     * Method responsible to the first page of this app.
//     * @throws EmailException 
//     */
//    @Path("/")
//    public void index() {        
//        if(userSession.getEmail() == null){
//            userSession.setEmail(new utils.Email());
//            userSession.getEmail().start();
//        }
//        
//        if (!userSession.isLogged()) {
//            result.redirectTo(LoginController.class).index();
//        } else {
//            LocalDate localDate = LocalDate.now();
//            Month month = localDate.getMonth();
//            int monthInt = month.getValue();
//            int year = localDate.getYear();
//            
//            userSession.setDay(0);
//            userSession.setMonth(monthInt);
//            userSession.setYear(year);
//
//            result.redirectTo(HomeController.class).main();
//        }
//    }
}
