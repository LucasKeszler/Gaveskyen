package org.example.oenskeskyen.Repository;

import org.example.oenskeskyen.Models.User;

import java.sql.SQLException;

public interface IUserRepository {

    void createUser(User user) throws SQLException;

    User getUserUsername(String username) throws SQLException;
}
