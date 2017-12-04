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
    @Path("")
    public void index() {
        if (userSession.getEmail() == null) {
            userSession.setEmail(new utils.Email());
            userSession.getEmail().start();
        }

        if (!userSession.isLogged()) {
            result.redirectTo(LoginController.class).index();
        } else {
            result.redirectTo(CalendarController.class).list();
        }
    }
}
