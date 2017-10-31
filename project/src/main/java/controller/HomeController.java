package controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import dao.UserDAO;
import factory.DAOFactory;
import factory.constants.DAOConstants;
import model.User;

@Controller
public class HomeController {

    @Inject
    private Result result;
    
    @Path("/home/login")
    @Post
    public void login(User user) {
    	if(user != null && !user.getEmail().trim().isEmpty() && !user.getPassword().trim().isEmpty()) {
    		
        	result.include("login", user.getEmail());
    	}
    }
    
    /**
     * Method responsible to the first page of this app.
     */
    @Path("/")
    public void index() {
        // Redirect to first page of this app.
//        User user = new User();
//        user.setName("user");
//        user.setEmail("user@user.com");
//        user.setPassword("null");
//        UserDAO userDAO = (UserDAO) DAOFactory.getDAO(DAOConstants.USER_CLASS);
//        userDAO.insert(user);
    }
}
