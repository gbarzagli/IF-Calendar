package dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.User;

public class UserDAO extends HibernateGenericDAO<User> {

    public User findUserByEmail(String email) {
        EntityManager entityManager = factory.createEntityManager();
        Query query = (Query) entityManager.createQuery("from User u where u.email = ?");
        query.setParameter(1, email);
        return (User) query.getSingleResult();
    }

}
