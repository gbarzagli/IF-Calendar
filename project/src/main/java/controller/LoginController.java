package controller;

import javax.inject.Inject;

import org.omg.CORBA.WrongTransaction;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import component.UserSession;
import dao.UserDAO;
import model.User;
import static utils.Utils.encrypt;

@Controller
public class LoginController {

    @Inject
    private UserSession userSession;

    @Inject
    private Result result;

    @Path("/login")
    public void index() {
        if (userSession.isLogged()) {
            result.redirectTo(HomeController.class).index();
        }
    }

    @Path("/logout")
    public void logout() throws WrongTransaction {
        if (userSession.isLogged()) {
            userSession.logout();
        }
        result.redirectTo(HomeController.class).index();
    }

    @Path("/login/login")
    public void login(User user, String signup, String login) {
        if (login != null) {
            if (user != null && !user.getEmail().trim().isEmpty() && !user.getPassword().trim().isEmpty()) {                
            	UserDAO userDAO = new UserDAO();                
                User userLogged = userDAO.findUserByEmail(user.getEmail());                
                if (userLogged != null && userLogged.getPassword().equals(encrypt(user.getPassword()))) {
                    userSession.login(userLogged);
                    result.redirectTo(HomeController.class).main(user);
                } else {
                    result.include("validation", "Wrong login or password");
                    result.redirectTo(LoginController.class).index();
                }
            }
        } else if (signup != null) {
            result.redirectTo(SignUpController.class).signup();
        }
    }
}
