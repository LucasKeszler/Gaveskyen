package org.example.oenskeskyen.Services;

import org.example.oenskeskyen.Models.User;
import org.example.oenskeskyen.Repository.UserRepository;

import java.sql.SQLException;

public class UserService {

    private UserRepository userRepository = new UserRepository();

    public void registerUser(String username, String password) {
        try {

            User existingUser = userRepository.getUserUsername(username);

            if(existingUser != null) {
                System.out.println("Bruger findes allerede");
                return;
            }

            User user = new User(username, password);
            userRepository.createUser(user);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public User login(String username, String password) {
        try {
            User user = userRepository.getUserUsername(username);

            if (user != null && user.getPassword().equals(password)) {
                return user;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public User getUserUsername(String username) {
        try {
            return userRepository.getUserUsername(username);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
