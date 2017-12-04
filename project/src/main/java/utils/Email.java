package utils;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

import dao.EventDAO;
import factory.DAOFactory;
import factory.constants.DAOConstants;
import model.Event;
import model.Permission;
import model.PermissionId;
import model.User;

public class Email extends Thread{
	
	public void run(){
		while(true){
			try {
				EventDAO eventDAO = (EventDAO) DAOFactory.getDAO(DAOConstants.EVENT_CLASS);
				List<Event> listEvents = eventDAO.all();
				
				if(listEvents != null && listEvents.size() > 0){
					for (Event event : listEvents) {
						if(!event.isSent()){
							event.setSent(true);
							eventDAO.update(event);
							long timeToStart = event.getStart().getTime() - new Date().getTime();
							if(TimeUnit.MILLISECONDS.toMinutes(timeToStart) < 60 && TimeUnit.MILLISECONDS.toMinutes(timeToStart) > 0){
							    startingEvent(event.getCalendar().getOwner().getEmail(), event.getName(),  String.valueOf(TimeUnit.MILLISECONDS.toMinutes(timeToStart)));								
								List<Permission> permissionList = event.getCalendar().getPermissions();
								for (Permission permission : permissionList) {
									PermissionId permissionId = permission.getId();
									User user = permissionId.getUser();
									startingEvent(user.getEmail(), event.getName(), String.valueOf(TimeUnit.MILLISECONDS.toMinutes(timeToStart)));									
								}
							}
						}
					}
				}
				
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	private void startingEvent(String emailSend, String event, String minutes){
	    String subject = "Event is about to start!";
	    String message = "Your event \"" + event + "\" is about to start in: " + minutes + " minutes!";
	    send(emailSend, subject, message);
	}
	
	public void send(String emailSend, String subject, String message){
        SimpleEmail email = new SimpleEmail();
        email.setHostName("smtp.googlemail.com");
        email.setSmtpPort(465);
        email.setAuthenticator(new DefaultAuthenticator("ifspcalendar@gmail.com", "ifcalendar1234"));
        email.setSSLOnConnect(true);
        try {
            email.setFrom("ifspcalendar@gmail.com");
            email.setSubject(subject);
            email.setMsg(message);
            email.addTo(emailSend);
            email.send();
        } catch (EmailException e) {
            e.printStackTrace();
        }
    }
}
