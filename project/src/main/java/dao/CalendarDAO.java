package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Calendar;
import model.User;

public class CalendarDAO extends HibernateGenericDAO<Calendar> {

    public CalendarDAO() {
        super(Calendar.class);
    }

    public Calendar findCalendarByName(String name) {
        EntityManager entityManager = factory.createEntityManager();
        Query query = (Query) entityManager.createQuery("from Calendar c where c.name = :name");
        query.setParameter("name", name);
        return (Calendar) query.getSingleResult();
    }

    @SuppressWarnings("unchecked")
    public List<Calendar> findCalendarsByUser(User user) {
        EntityManager entityManager = factory.createEntityManager();
        Query query = (Query) entityManager.createQuery("from Calendar c where c.owner = :owner");
        query.setParameter("owner", user);
        return (List<Calendar>) query.getResultList();
    }
}
