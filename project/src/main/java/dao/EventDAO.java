package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Calendar;
import model.Event;

public class EventDAO extends HibernateGenericDAO<Event> {
    
    public EventDAO() {
        super(Event.class);
    }
    
    public Event findEventByName(String name) {
        EntityManager entityManager = factory.createEntityManager();
        Query query = (Query) entityManager.createQuery("from Event e where e.name = :name");
        query.setParameter("name", name);
        return (Event) query.getSingleResult();
    }
    
    @SuppressWarnings("unchecked")
    public List<Event> findEventsByCalendar(Calendar calendar) {
        EntityManager entityManager = factory.createEntityManager();
        Query query = (Query) entityManager.createQuery("from Event e where e.calendar = :calendar");
        query.setParameter("calendar", calendar);
        return (List<Event>) query.getResultList();
    }
}
