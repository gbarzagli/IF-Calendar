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

    private DAOFactory () {
    }

    @SuppressWarnings("rawtypes")
    public static GenericDAO getDAO(String type) {
        switch (type) {
            case DAOConstants.USER_CLASS:
            	return new UserDAO();
            case DAOConstants.CALENDAR_CLASS:
                return new CalendarDAO();
            case DAOConstants.EVENT_CLASS:
                return new EventDAO();
            default:
                return null;
        }
    }
}