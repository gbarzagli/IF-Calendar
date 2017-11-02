package controller;

import java.util.Date;

import javax.inject.Inject;

import org.omg.CORBA.WrongTransaction;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import component.UserSession;
import dao.CalendarDAO;
import factory.DAOFactory;
import factory.constants.DAOConstants;
import model.Calendar;

@Controller
@Path("/calendar")
public class CalendarController {
	@Inject
	private UserSession userSession;

	@Inject
	private Result result;

	@Path("/create")
	public void create() throws WrongTransaction {
		if(!userSession.isLogged()){
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
}
