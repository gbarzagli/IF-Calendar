package controller;

import javax.inject.Inject;

import org.omg.CORBA.WrongTransaction;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import dao.UserDAO;
import model.User;

@Controller
public class HomeController {

    @Inject
    private Result result;
    
    @Path("/login")
    public void login(User user) {
    	result.include("login", user.getEmail());
    }
    
    /**
     * Method responsible to the first page of this app.
     * @throws WrongTransaction 
     */
    @Path("/")
    public void index(User user, String signup, String login) throws WrongTransaction {
        if(login != null) {
        	if(user != null && user.getEmail() != null && user.getPassword() != null && !user.getEmail().trim().isEmpty() && !user.getPassword().trim().isEmpty()) {
        		UserDAO userDAO = new UserDAO();
        		User userLogged = userDAO.findUserByEmail(user.getEmail());
        		if(userLogged != null) {
        			result.redirectTo(HomeController.class).login(user);
        		}
        		else {
        			result.include("validation", "Wrong login or password");
        			result.redirectTo(HomeController.class).index(user, null, null);
        		}
        	}
        }else if(signup != null) {
        	result.redirectTo(SignUpController.class).signup();
        }
    }
}
