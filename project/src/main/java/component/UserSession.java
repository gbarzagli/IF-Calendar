package component;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;

import model.Calendar;
import model.User;
import utils.Email;

@SessionScoped
public class UserSession implements Serializable {
    private static final long serialVersionUID = 5504691787911763506L;
    
    private User user;
    private Calendar calendar;
    private Email email;
    private int month;
    private int year;
    
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

	public Email getEmail() {
		return email;
	}

	public void setEmail(Email email) {
		this.email = email;
	}	
	
	public int getMonth() {
        return month;
    }
	
	public void setMonth(int month) {
        this.month = month;
    }
	
	public int getYear() {
        return year;
    }
	
	public void setYear(int year) {
        this.year = year;
    }

}
