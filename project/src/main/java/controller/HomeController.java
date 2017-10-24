package controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import dao.UserDAO;
import model.User;

@Controller
public class HomeController {

    @Inject
    private Result result;
    
    @Path("/home/login")
    @Post
    public void login(User user) {
    	if(user != null && !user.getLogin().trim().isEmpty() && !user.getPassword().trim().isEmpty()) {
    		UserDAO userDAO = new UserDAO();
        	userDAO.insert(user);
        	result.include("login", user.getLogin());
    	}
    }
    
    @Path("/")
    public void index() {
    	
    }

}
