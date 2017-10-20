package factory;

import dao.HibernateTesteDAO;
import dao.JDBCTesteDAO;
import dao.TesteDAO;
import factory.constants.DAOConstants;

/**
 * DAOFactory
 */
public class DAOFactory {

    private DAOFactory () {
    }

    public static TesteDAO getDAO(String type) {
        switch (type) {
            case DAOConstants.JDBC:
                return JDBCTesteDAO.getInstance();
            case DAOConstants.JPA:
                return HibernateTesteDAO.getInstance();
        }
        return null;
    }
}