package br.edu.ifsp.calendar.dao;

import java.sql.SQLException;

import br.edu.ifsp.calendar.model.User;

public interface UserDAO {

    void insert(User user) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException;
    User findByUsername(String username) throws ClassNotFoundException, SQLException;
}
