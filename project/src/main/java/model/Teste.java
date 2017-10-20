package model;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Teste
 */
@Entity
public class Teste extends EntityObject {

    public static final String CLASS_NAME = "Teste";
    
    @Column
    private Integer value;
    
    public Teste () {
    }
    
    @Override
    public Long getId() {
        return id;
    }
    
    @Override
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the value
     */
    public Integer getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(Integer value) {
        this.value = value;
    }

}