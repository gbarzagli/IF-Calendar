package dao;

import java.rmi.UnexpectedException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Teste;
import factory.ConnectionFactory;
import factory.constants.ConnectionConstants;

/**
 * TesteDAO
 * 
 */
public class JDBCTesteDAO implements TesteDAO {

    private static TesteDAO instance;

    private JDBCTesteDAO () {
        try {
            Connection conn = ConnectionFactory.getConnection(ConnectionConstants.HSQLDB);
            PreparedStatement statement = conn.prepareStatement("CREATE TABLE Teste(valor int)");
            statement.executeUpdate();
            statement.close();
            conn.close();
		} catch (SQLException | ClassNotFoundException e) {
			throw new UnexpectedException(e.getMessage());
		}
    }

    public static TesteDAO getInstance() {
        if (instance == null) {
            instance = new JDBCTesteDAO();
        }
        return instance; 
    }

    public void insert(Teste teste) {
        try {
            Connection conn = ConnectionFactory.getConnection(ConnectionConstants.HSQLDB);
            PreparedStatement statement = conn.prepareStatement("INSERT INTO Teste VALUES (?)");
            statement.setInt(1, teste.getValue());
            statement.execute();
            statement.close();
            conn.close();
		} catch (SQLException | ClassNotFoundException e) {
			throw new UnexpectedException(e.getMessage());
		}
    }

    public List<Teste> all() {
        List<Teste> list = new ArrayList<>();
        try {
            Connection conn = ConnectionFactory.getConnection(ConnectionConstants.HSQLDB);
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM Teste");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Teste teste = new Teste();
                teste.setValue(resultSet.getInt(1));
                list.add(teste);
            }
            resultSet.close();
            statement.close();
            conn.close();
		} catch (SQLException | ClassNotFoundException e) {
			throw new UnexpectedException(e.getMessage());
        }
        return list;
    }

}