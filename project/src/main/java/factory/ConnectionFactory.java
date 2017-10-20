package factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.hsqldb.jdbc.JDBCDriver;
import factory.constants.ConnectionConstants;

/**
 * ConnectionFactory
 * Factory to create a connection to Database
 * 
 * @author Gabriel Barzagli
 */
public class ConnectionFactory {

    private ConnectionFactory () {}

    public static Connection getConnection(String database) throws SQLException, ClassNotFoundException {
        
        switch (database) {
            case ConnectionConstants.HSQLDB:
                Class.forName(JDBCDriver.class.getName());
                return DriverManager.getConnection("jdbc:hsqldb:mem:calendar", "", "");
            case ConnectionConstants.MYSQL:
                Class.forName("com.mysql.jdbc.Driver");
                return DriverManager.getConnection("jdbc:mysql://localhost:3306/calendar");
        }
        return null;
    }
}