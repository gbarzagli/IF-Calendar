package dao;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import model.Calendar;
import model.Event;

public class EventDAO extends HibernateGenericDAO<Event> {
    
    public EventDAO() {
        super(Event.class);
    }
    
    public Event findEventByName(String name) {
        Query query = (Query) entityManager.createQuery("from Event e where e.name = :name");
        query.setParameter("name", name);
        return (Event) query.getSingleResult();
    }
    
    @SuppressWarnings("unchecked")
    public List<Event> findEventsByCalendar(Calendar calendar) {
        Query query = (Query) entityManager.createQuery("from Event e where e.calendar = :calendar");
        query.setParameter("calendar", calendar);
        return (List<Event>) query.getResultList();
    }
    
    @SuppressWarnings("unchecked")
    public List<Event> findEventsByCalendarAndDate(Calendar calendar, Date date) {
        List<Event> events = new ArrayList<>();
        Query query = (Query) entityManager.createQuery("from Event e where e.calendar = :calendar");
        query.setParameter("calendar", calendar);
        
        LocalDateTime dateTime = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
        
        List<Event> list = (List<Event>) query.getResultList();
        for (Event event : list) {
            LocalDateTime start = LocalDateTime.ofInstant(event.getStart().toInstant(), ZoneId.systemDefault());
            if (dateTime.getDayOfMonth() == start.getDayOfMonth() 
                    && dateTime.getMonth().getValue() == start.getMonth().getValue() 
                    && dateTime.getYear() == start.getYear()) {
                events.add(event);
            }
        }
        
        return events;
    }
    
}
