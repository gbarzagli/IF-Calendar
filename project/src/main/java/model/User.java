package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class User extends EntityObject {

    public static final String CLASS_NAME = "User";

    @Column(unique = true)
    private String email;
    @Column
    private String password;

    @Column
    public String name;
    
    @OneToMany(mappedBy = "owner", targetEntity = Calendar.class, cascade = CascadeType.ALL)
    private List<Calendar> calendars;
    
    @OneToMany(mappedBy = "id.user", targetEntity = Permission.class, cascade = CascadeType.ALL)
    private List<Permission> permissions;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public List<Calendar> getCalendars() {
        return calendars;
    }
    
    public void setCalendars(List<Calendar> calendars) {
        this.calendars = calendars;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }
}
