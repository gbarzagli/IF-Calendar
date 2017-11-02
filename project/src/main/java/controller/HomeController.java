package controller;

import javax.inject.Inject;

import org.omg.CORBA.WrongTransaction;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import component.UserSession;
import model.User;

@Controller
public class HomeController {

	@Inject
	private UserSession userSession;

	@Inject
	private Result result;

	@Path("/main")
	public void main(User user) {
		
	}

	/**
	 * Method responsible to the first page of this app.
	 * 
	 * @throws WrongTransaction
	 */
	@Path("/")
	public void index() throws WrongTransaction {
		if (!userSession.isLogged()) {
			result.redirectTo(LoginController.class).index();
		}
		else{
			result.redirectTo(HomeController.class).main(userSession.getUser());
		}
	}
}
