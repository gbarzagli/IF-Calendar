package controller;

import static utils.Utils.encrypt;

import javax.inject.Inject;

import org.apache.commons.validator.routines.EmailValidator;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import dao.UserDAO;
import model.User;

@Controller
@Path("/signup")
public class SignUpController {

    @Inject
    private Result result;

    @Path("/")
    public void signup() {
        // Method only to load jsp
    }

    @Post("/insert")
    public void insert(User user) {
        if (user != null && user.getName() != null && user.getEmail() != null && user.getPassword() != null && !user.getName().trim().isEmpty() && !user.getEmail().trim().isEmpty()
                && !user.getPassword().trim().isEmpty()) {
            EmailValidator validator = EmailValidator.getInstance();

            if (validator.isValid(user.getEmail())) {
                UserDAO userDAO = new UserDAO();
                User userExist = userDAO.findUserByEmail(user.getEmail());

                if (userExist != null) {
                    result.include("validation", "E-mail already registred");
                    result.redirectTo(SignUpController.class).signup();
                } else {
                    user.setEmail(user.getEmail());
                    user.setPassword(encrypt(user.getPassword()));
                    userDAO.insert(user);
                    result.redirectTo(HomeController.class).index();
                }
            } else {
                result.include("validation", "Try a valid e-mail");
                result.redirectTo(SignUpController.class).signup();
            }
        } else {
            result.include("validation", "Complete all fields!");
            result.redirectTo(SignUpController.class).signup();
        }
    }
}
