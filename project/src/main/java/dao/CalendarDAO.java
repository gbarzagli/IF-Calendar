package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Calendar;
import model.User;

public class CalendarDAO extends HibernateGenericDAO<Calendar> {

    public Calendar findCalendarByName(String name) {
        EntityManager entityManager = factory.createEntityManager();
        Query query = (Query) entityManager.createQuery("from Calendar c where c.name = ?");
        query.setParameter(1, name);
        return (Calendar) query.getSingleResult();
    }

    @SuppressWarnings("unchecked")
    public List<Calendar> findCalendarsByUser(User user) {
        EntityManager entityManager = factory.createEntityManager();
        Query query = (Query) entityManager.createQuery("from Calendar c where c.owner = ?");
        query.setParameter(1, user);
        return (List<Calendar>) query.getResultList();
    }
}
