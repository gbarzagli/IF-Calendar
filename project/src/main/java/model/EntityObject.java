package model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * EntityObject
 * Abstract class to objects that will be persisted
 * 
 * @author Gabriel Barzagli
 */
public abstract class EntityObject {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public Long id;

    public abstract Long getId();
    public abstract void setId(Long id);
}