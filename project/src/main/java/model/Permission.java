package model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Permission {
    
    @EmbeddedId
    private PermissionId id;
    
    @Column
    private boolean canWrite;
    
    public PermissionId getId() {
        return id;
    }

    public void setId(PermissionId id) {
        this.id = id;
    }

    public boolean canWrite() {
        return canWrite;
    }

    public void setCanWrite(boolean write) {
        this.canWrite = write;
    }
    
}


