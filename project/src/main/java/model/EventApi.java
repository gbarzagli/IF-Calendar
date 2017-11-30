package model;

import java.util.Date;

public class EventApi extends EntityObject {
	
	private String nameCalendar;
    
    private Date creationCalendar;
	
	private String emailUser;

	private String passwordUser;
	
	private String nameUser;
	
    private String nameEvent;

	private String localEvent;

    private String startEvent;

    private String endEvent;

	public String getNameCalendar() {
		return nameCalendar;
	}

	public void setNameCalendar(String nameCalendar) {
		this.nameCalendar = nameCalendar;
	}

	public Date getCreationCalendar() {
		return creationCalendar;
	}

	public void setCreationCalendar(Date creationCalendar) {
		this.creationCalendar = creationCalendar;
	}

	public String getEmailUser() {
		return emailUser;
	}

	public void setEmailUser(String emailUser) {
		this.emailUser = emailUser;
	}

	public String getPasswordUser() {
		return passwordUser;
	}

	public void setPasswordUser(String passwordUser) {
		this.passwordUser = passwordUser;
	}

	public String getNameUser() {
		return nameUser;
	}

	public void setNameUser(String nameUser) {
		this.nameUser = nameUser;
	}

	public String getNameEvent() {
		return nameEvent;
	}

	public void setNameEvent(String nameEvent) {
		this.nameEvent = nameEvent;
	}

	public String getLocalEvent() {
		return localEvent;
	}

	public void setLocalEvent(String localEvent) {
		this.localEvent = localEvent;
	}

	public String getStartEvent() {
		return startEvent;
	}

	public void setStartEvent(String startEvent) {
		this.startEvent = startEvent;
	}

	public String getEndEvent() {
		return endEvent;
	}

	public void setEndEvent(String endEvent) {
		this.endEvent = endEvent;
	}

	@Override
	public Long getId() {
		return null;
	}

	@Override
	public void setId(Long id) {
		
	}
}
