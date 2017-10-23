package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

/**
 * HibernateGenericDAO
 * Generic DAO to extend.
 * 
 * @author Gabriel Barzagli 
 */
public abstract class HibernateGenericDAO<T> implements GenericDAO<T> {

    private EntityManagerFactory factory;
    private Class<T> classObject;

    protected HibernateGenericDAO() {
        factory = Persistence.createEntityManagerFactory("manager");
    }

	@Override
	public void insert(T object) {
		EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(object);
        entityManager.getTransaction().commit();
	}

	@Override
	public void update(T object) {
		EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(object);
        entityManager.getTransaction().commit();
	}

	@Override
	public List<T> all() {
		EntityManager entityManager = factory.createEntityManager();
        CriteriaQuery<T> criteria = entityManager.getCriteriaBuilder().createQuery(classObject);
        Query query = (Query) entityManager.createQuery(criteria);
        return (List<T>) query.getResultList();
	}

	@Override
	public T findByKey(Long id) {
		EntityManager entityManager = factory.createEntityManager();
        return entityManager.find(classObject, id);
	}

    
}