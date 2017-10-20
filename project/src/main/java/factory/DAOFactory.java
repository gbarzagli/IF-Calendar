package factory;

import dao.GenericDAO;
import dao.HibernateTesteDAO;
import factory.constants.DAOConstants;
import model.Teste;

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
                return HibernateTesteDAO.getInstance();
        }
        return null;
    }
}