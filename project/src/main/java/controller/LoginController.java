package controller;

import static utils.Utils.encrypt;

import java.time.LocalDate;
import java.time.Month;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import component.UserSession;
import dao.UserDAO;
import model.User;

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
    public void logout() {
        if (userSession.isLogged()) {
            userSession.logout();
        }
        result.redirectTo(HomeController.class).index();
    }

    @Path("/auth")
    public void login(User user) {
        if (user != null && (user.getEmail() != null && !user.getEmail().trim().isEmpty()) && (user.getPassword() != null && !user.getPassword().trim().isEmpty())) {
        	UserDAO userDAO = new UserDAO();                
            User userLogged = userDAO.findUserByEmail(user.getEmail());                
            if (userLogged != null && userLogged.getPassword().equals(encrypt(user.getPassword()))) {
                userSession.login(userLogged);
                
                LocalDate localDate = LocalDate.now();
                Month month = localDate.getMonth();
                
                int day = localDate.getDayOfMonth();
                int monthInt = month.getValue();
                int year = localDate.getYear();

                userSession.setDay(day);
                userSession.setMonth(monthInt);
                userSession.setYear(year);
                
                result.include("userName", userLogged.getName());
                result.redirectTo(CalendarController.class).list();
            } else {
                result.include("validation", "Wrong login or password");
                result.redirectTo(LoginController.class).index();
            }
        } else {
            result.include("validation", "Fill all fields!");
            result.redirectTo(LoginController.class).index();
        }
    }
}
