package component;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;

import model.User;

@SessionScoped
public class UserSession implements Serializable {
	private User user;

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
}
