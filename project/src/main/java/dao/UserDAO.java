package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.User;

public class UserDAO extends HibernateGenericDAO<User> {

    public User findUserByEmail(String email) {
        EntityManager entityManager = factory.createEntityManager();
        Query query = (Query) entityManager.createQuery("from User u where u.email = :email");
        query.setParameter("email", email);
        List results = query.getResultList();
        if (results.size() > 0) return (User) results.get(0);
        return null;
    }

}
