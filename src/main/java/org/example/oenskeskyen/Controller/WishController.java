package org.example.oenskeskyen.Controller;

import jakarta.servlet.http.HttpSession;
import org.example.oenskeskyen.Models.User;
import org.example.oenskeskyen.Services.WishService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WishController {

    private WishService wishService = new WishService();

    @GetMapping("/wishlist")
    public ModelAndView showWishlist(HttpSession session) {

        User user = (User) session.getAttribute("user");

        if (user == null) {
            return new ModelAndView("redirect:/login");
        }

        ModelAndView mav = new ModelAndView("wishlist");
        mav.addObject("wishes", wishService.getWishesUser(user.getId()));

        return mav;
    }

    @GetMapping("/add-wish")
    public ModelAndView showAddWishPage(HttpSession session) {

        User user = (User) session.getAttribute("user");

        if (user == null) {
            return new ModelAndView("redirect:/login");
        }

        return new ModelAndView("add-wish");
    }

    @PostMapping("/add-wish")
    public ModelAndView addWish(@RequestParam String title,
                                @RequestParam String description,
                                @RequestParam String link,
                                @RequestParam String icon,
                                HttpSession session) {

        User user = (User) session.getAttribute("user");

        if (user == null) {
            return new ModelAndView("redirect:/login");
        }

        wishService.createWish(title, description, link, icon, user.getId());

        return new ModelAndView("redirect:/wishlist");
    }

    @GetMapping("/delete-wish")
    public ModelAndView deleteWish(@RequestParam int id,
                                   HttpSession session) {

        User user = (User) session.getAttribute("user");

        if (user == null) {
            return new ModelAndView("redirect:/login");
        }

        wishService.deleteWish(id, user.getId());

        return new ModelAndView("redirect:/wishlist");
    }
}