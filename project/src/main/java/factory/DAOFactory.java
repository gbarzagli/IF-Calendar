package factory;

import dao.CalendarDAO;
import dao.EventDAO;
import dao.GenericDAO;
import dao.UserDAO;
import factory.constants.DAOConstants;

/**
 * DAOFactory
 * Factory to create a Data Access Object.
 * 
 * @author Gabriel Barzagli
 */
public class DAOFactory {
    
    private static UserDAO USERDAO;
    private static CalendarDAO CALENDARDAO;
    private static EventDAO EVENTDAO;

    private DAOFactory () {
    }

    @SuppressWarnings("rawtypes")
    public static GenericDAO getDAO(String type) {
        switch (type) {
            case DAOConstants.USER_CLASS:
                if (USERDAO == null) {
                    USERDAO = new UserDAO();
                }
            	return USERDAO;
            case DAOConstants.CALENDAR_CLASS:
                if (CALENDARDAO == null) {
                    CALENDARDAO = new CalendarDAO();
                }
                return CALENDARDAO;
            case DAOConstants.EVENT_CLASS:
                if (EVENTDAO == null) {
                    EVENTDAO = new EventDAO();
                }
                return EVENTDAO;
            default:
                return null;
        }
    }
}