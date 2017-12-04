package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import model.Calendar;
import model.User;

public class CalendarDAO extends HibernateGenericDAO<Calendar> {

    public CalendarDAO() {
        super(Calendar.class);
    }

    public Calendar findCalendarByName(String name) {
        Query query = (Query) entityManager.createQuery("from Calendar c where c.name = :name");
        query.setParameter("name", name);
        return (Calendar) query.getSingleResult();
    }

    @SuppressWarnings("unchecked")
    public List<Calendar> findCalendarsByUser(User user) {
        List<Calendar> calendars = new ArrayList<>();
        
        Query queryOwner = (Query) entityManager.createQuery("from Calendar c where c.owner = :owner");
        queryOwner.setParameter("owner", user);
        calendars.addAll((List<Calendar>) queryOwner.getResultList());
        
        return calendars;
    }
}
