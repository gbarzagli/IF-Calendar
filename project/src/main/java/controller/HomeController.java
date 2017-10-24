package controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import model.User;

@Controller
public class HomeController {

    @Inject
    private Result result;
    
    @Path("/login")
    @Post
    public void login(User user) {
    	result.include("login", user.getLogin());
    }
    
    /**
     * Method responsible to the first page of this app.
     */
    @Path("/")
    public void index() {
    }
}
