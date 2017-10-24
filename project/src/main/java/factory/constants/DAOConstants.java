package factory.constants;

import model.Teste;
import model.User;

/**
 * DAOConstants
 */
public class DAOConstants {
    public static final String JDBC = "jdbc";
    public static final String JPA = "jpa";

    public static final String TESTE_CLASS = Teste.CLASS_NAME;
    public static final String USER_CLASS = User.CLASS_NAME;

    private DAOConstants () {}
}