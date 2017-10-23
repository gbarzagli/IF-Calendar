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
    
    @Path("/home/logIn")
    @Post
    public void logIn(User user) {
    	result.include("login", user.getLogin());
    }

}
