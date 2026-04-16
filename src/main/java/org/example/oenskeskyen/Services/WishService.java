package org.example.oenskeskyen.Services;

import org.example.oenskeskyen.Models.Wish;
import org.example.oenskeskyen.Repository.WishRepository;

import java.sql.SQLException;
import java.util.List;

public class WishService {

    private WishRepository wishRepository = new WishRepository();

    public void createWish(String title, String description, String link, String icon, int userid) {
        try {
            Wish wish = new Wish(title, description, link, icon, userid);

            wishRepository.createWish(wish);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Wish> getWishesUser(int userId) {
        try{
            return wishRepository.getWishByUserId(userId);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void deleteWish(int wishId, int userId) {
        try {
            wishRepository.deleteWish(wishId);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
