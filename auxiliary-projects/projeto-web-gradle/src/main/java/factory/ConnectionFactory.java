package factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.hsqldb.jdbc.JDBCDriver;
import factory.constants.ConnectionConstants;

/**
 * name
 */
public class ConnectionFactory {

    private ConnectionFactory () {}

    public static Connection getConnection(String database) throws SQLException, ClassNotFoundException {
        switch (database) {
            case ConnectionConstants.HSQLDB:
                Class.forName(JDBCDriver.class.getName());
                return DriverManager.getConnection("jdbc:hsqldb:mem:banco-em-memoria", "", "");
            case ConnectionConstants.MYSQL:
                break;
            default:
                break;
        }
        return null;
    }
}