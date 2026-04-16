package org.example.oenskeskyen.Repository;

import org.example.oenskeskyen.Models.Wish;
import org.example.oenskeskyen.Utility.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class WishRepository {

    public void createWish(Wish wish) throws SQLException {
        Connection database = new ConnectionManager().getConnection();

        try {
            PreparedStatement preparedStatement = database.prepareStatement(
                    "INSERT INTO wishes (title, description, link, icon, user_id) VALUES (?, ?, ?, ?, ?)"
            );

            preparedStatement.setString(1, wish.getTitle());
            preparedStatement.setString(2, wish.getDescription());
            preparedStatement.setString(3, wish.getLink());
            preparedStatement.setString(4, wish.getIcon());
            preparedStatement.setInt(5, wish.getUserId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Could not create wish");
        }
    }

    public List<Wish> getWishByUserId(int userid) throws SQLException {
        List<Wish> wishes = new ArrayList<>();
        Connection database = new ConnectionManager().getConnection();

        PreparedStatement preparedStatement = database.prepareStatement(
                "SELECT  * FROM wishes WHERE user_id = ?"
        );

        preparedStatement.setInt(1, userid);

        ResultSet rs = preparedStatement.executeQuery();

        while (rs.next()) {
            Wish wish = new Wish(
                    rs.getInt("id"),
                    rs.getString("title"),
                    rs.getString("description"),
                    rs.getString("link"),
                    rs.getString("icon"),
                    rs.getInt("user_id")
            );

            wishes.add(wish);
        }

        return wishes;
    }

    public void deleteWish(int wishId) throws SQLException {
        Connection database = new ConnectionManager().getConnection();

        try {
            PreparedStatement preparedStatement = database.prepareStatement(
                    "DELETE FROM wishes WHERE id = ?"
            );

            preparedStatement.setInt(1, wishId);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Could not delete wish");
        }
    }
}
