package model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * EntityObject
 * Abstract class to objects that will be persisted
 * 
 * @author Gabriel Barzagli
 */
@MappedSuperclass
public abstract class EntityObject {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    protected Long id;

    public abstract Long getId();
    public abstract void setId(Long id);
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EntityObject other = (EntityObject) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
    
    
}