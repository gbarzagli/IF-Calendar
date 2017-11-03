package component;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;

import model.Calendar;
import model.User;

@SessionScoped
public class UserSession implements Serializable {
    private static final long serialVersionUID = 5504691787911763506L;
    
    private User user;
    private Calendar calendar;
    
	public void login(User user) {
		this.user = user;
	}

	public User getUser() {
		return user;
	}

	public void logout() {
		user = null;
	}

	public boolean isLogged() {
		return user != null;
	}
	
	public void setCalendar(Calendar calendar){
		this.calendar = calendar;
	}
	
	public Calendar getCalendar(){
		return calendar;
	}
}
