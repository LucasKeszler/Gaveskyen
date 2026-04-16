package org.example.oenskeskyen.Repository;

import org.example.oenskeskyen.Models.User;
import org.example.oenskeskyen.Utility.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRepository  implements IUserRepository {

    public void createUser(User user) throws SQLException {
        Connection database = new ConnectionManager().getConnection();

        try {
            PreparedStatement preparedStatement = database.prepareStatement(
                    "INSERT INTO users (username, password) VALUES (?, ?)"
            );

            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Could not create user");
        }
    }

    public  User getUserUsername(String username) throws SQLException {
        Connection database = new ConnectionManager().getConnection();
        User user = null;

        PreparedStatement preparedStatement = database.prepareStatement(
                "SELECT * FROM users WHERE username = ?"
        );

        preparedStatement.setString(1, username);

        ResultSet rs = preparedStatement.executeQuery();

        if (rs.next()) {
            user = new User(
                    rs.getInt("id"),
                    rs.getString("username"),
                    rs.getString("password")
            );
        }
        return user;
    }
}
