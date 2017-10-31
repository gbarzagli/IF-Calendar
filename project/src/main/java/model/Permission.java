package model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Permission {
    
    @EmbeddedId
    private PermissionId id;
    
    @Column
    private boolean write;
    
    public PermissionId getId() {
        return id;
    }

    public void setId(PermissionId id) {
        this.id = id;
    }

    public boolean canWrite() {
        return write;
    }

    public void setWrite(boolean write) {
        this.write = write;
    }
    
}


