package dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;

import model.User;

public class UserDAO extends HibernateGenericDAO<User> {

    public UserDAO() {
        super(User.class);
    }
    
    public User findUserByEmail(String email) {
        EntityManager entityManager = factory.createEntityManager();
        Query query = (Query) entityManager.createQuery("from User u where u.email = :email");
        query.setParameter("email", email);
        User user;
        try {
            user = (User) query.getSingleResult();
        } catch (NoResultException | NonUniqueResultException e) {
            return null;
        }
        return user;
    }

}
