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

    protected final EntityManagerFactory factory;
    protected Class<T> classObject;

    protected HibernateGenericDAO() {
        factory = Persistence.createEntityManagerFactory("calendar");
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
    @SuppressWarnings("unchecked")
    public List<T> all() {
        EntityManager entityManager = factory.createEntityManager();
        Query query = (Query) entityManager.createQuery("from User");
        return (List<T>) query.getResultList();
    }

    @Override
    public T findByKey(Long id) {
        EntityManager entityManager = factory.createEntityManager();
        return entityManager.find(classObject, id);
    }

    public void remove(T object) {
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.remove(object);
        entityManager.getTransaction().commit();
    }
}