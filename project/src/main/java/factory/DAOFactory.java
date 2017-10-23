package factory;

import dao.GenericDAO;
import dao.TesteDAO;
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

    public static GenericDAO getDAO(String type) {
        switch (type) {
            case DAOConstants.TESTE_CLASS:
                return new TesteDAO();
        }
        return null;
    }
}