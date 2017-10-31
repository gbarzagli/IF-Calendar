package model;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class PermissionId {
    @ManyToOne
    @JoinColumn(name="id")
    private User user;
    
    @ManyToOne
    //@JoinColumn(name="id")
    private Calendar calendar;
    
    public Calendar getCalendar() {
        return calendar;
    }
    
    public User getUser() {
        return user;
    }
    
    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }
    
    public void setUser(User user) {
        this.user = user;
    }
}