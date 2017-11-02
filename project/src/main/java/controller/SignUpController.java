package controller;

import javax.inject.Inject;

import org.omg.CORBA.WrongTransaction;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import model.User;

@Controller
public class SignUpController {

	 @Inject
	 private Result result;
	 
	 @Path("/signup")
	 public void signup() {
		 
	 }
	 
	 @Post("/signUp/insert")
	 public void insert(User user) throws WrongTransaction {
		 System.out.println(user.getName());
		 result.redirectTo(HomeController.class).index(user, null, null);
	 }
}
