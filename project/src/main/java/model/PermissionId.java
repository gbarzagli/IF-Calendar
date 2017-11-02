package model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class PermissionId implements Serializable {
    private static final long serialVersionUID = -7164817728555613408L;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
    
    @ManyToOne
    @JoinColumn(name = "calendar_id", referencedColumnName = "id")
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