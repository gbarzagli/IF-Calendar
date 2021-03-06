package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 * HibernateGenericDAO Generic DAO to extend.
 * 
 * @author Gabriel Barzagli
 */
public abstract class HibernateGenericDAO<T> implements GenericDAO<T> {
    
    protected EntityManager entityManager;
    protected final EntityManagerFactory factory;
    protected Class<T> classObject;

    protected HibernateGenericDAO(Class<T> clazz) {
        factory = Persistence.createEntityManagerFactory("calendar");
        entityManager = factory.createEntityManager();
        classObject = clazz;
    }

    @Override
    public void insert(T object) {
        entityManager.getTransaction().begin();
        entityManager.persist(object);
        entityManager.getTransaction().commit();
    }

    @Override
    public void update(T object) {
        entityManager.getTransaction().begin();
        entityManager.merge(object);
        entityManager.getTransaction().commit();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<T> all() {
        Query query = (Query) entityManager.createQuery("from " +  classObject.getSimpleName());
        return (List<T>) query.getResultList();
    }

    @Override
    public T findByKey(Long id) {
        return entityManager.find(classObject, id);
    }

    public void remove(Long id) {
        entityManager.getTransaction().begin();
        T object = entityManager.find(classObject, id);
        entityManager.remove(object);
        entityManager.getTransaction().commit();
    }
}