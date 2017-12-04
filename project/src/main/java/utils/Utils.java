package utils;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Year;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;

import dao.EventDAO;
import factory.DAOFactory;
import factory.constants.DAOConstants;
import model.Calendar;
import model.Event;
import model.MonthDays;

public class Utils {
	
	public static String encrypt(String text) {
		return DigestUtils.md5Hex(text);
	}
	
	public static MonthDays[][] getMonthDays(Calendar calendar, int month, int year) {
	    MonthDays[][] days = {
            {new MonthDays("", false),new MonthDays("", false),new MonthDays("", false),new MonthDays("", false),new MonthDays("", false),new MonthDays("", false),new MonthDays("", false)},
            {new MonthDays("", false),new MonthDays("", false),new MonthDays("", false),new MonthDays("", false),new MonthDays("", false),new MonthDays("", false),new MonthDays("", false)},
            {new MonthDays("", false),new MonthDays("", false),new MonthDays("", false),new MonthDays("", false),new MonthDays("", false),new MonthDays("", false),new MonthDays("", false)},
            {new MonthDays("", false),new MonthDays("", false),new MonthDays("", false),new MonthDays("", false),new MonthDays("", false),new MonthDays("", false),new MonthDays("", false)},
            {new MonthDays("", false),new MonthDays("", false),new MonthDays("", false),new MonthDays("", false),new MonthDays("", false),new MonthDays("", false),new MonthDays("", false)},
            {new MonthDays("", false),new MonthDays("", false),new MonthDays("", false),new MonthDays("", false),new MonthDays("", false),new MonthDays("", false),new MonthDays("", false)}
	    };
	    
	    LocalDate firstDay = LocalDate.of(year, month, 1);
	    DayOfWeek dayOfWeek = firstDay.getDayOfWeek();
	    int column = dayOfWeek.getValue();
	    int line = 0;
	    
	    boolean isLeap = Year.isLeap(year);
	    int length = firstDay.getMonth().length(isLeap);
	    
	    for (int i = 1; i <= length; i++) {
	        if (column == 7) {
	            column = 0;
	            line++;
	        }
	        
	        LocalDateTime day = LocalDateTime.of(year, month, i, 0, 0);
	        Date date = Date.from(day.toInstant(ZoneOffset.ofHours(-3)));
	        
	        EventDAO eventDAO = (EventDAO) DAOFactory.getDAO(DAOConstants.EVENT_CLASS);
	        List<Event> events = eventDAO.findEventsByCalendarAndDate(calendar, date);
	        boolean hasEvent = !events.isEmpty();
	        
	        days[line][column].setDay(Integer.toString(i));
	        days[line][column].setHasEvent(hasEvent);
	        column++;
	    }
	    
	    return days;
	}
	
}
