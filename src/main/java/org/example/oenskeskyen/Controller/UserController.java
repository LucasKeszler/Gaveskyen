package org.example.oenskeskyen.Controller;

import jakarta.servlet.http.HttpSession;
import org.example.oenskeskyen.Models.User;
import org.example.oenskeskyen.Services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    private UserService userService = new UserService();

    @GetMapping("/register")
    public ModelAndView showRegisterPage() {
        return new ModelAndView("register");
    }

    @PostMapping("/register")
    public ModelAndView registerUser(@RequestParam String username,
                                     @RequestParam String password) {

        userService.registerUser(username, password);
        return new ModelAndView("redirect:/login");
    }

    @GetMapping("/login")
    public ModelAndView showLoginPage() {
        return new ModelAndView("login");
    }

    @PostMapping("/login")
    public ModelAndView loginUser(@RequestParam String username,
                                  @RequestParam String password,
                                  HttpSession session) {

        User user = userService.login(username, password);

        if (user != null) {
            session.setAttribute("user", user);
            return new ModelAndView("redirect:/wishlist");
        }

        ModelAndView mav = new ModelAndView("login");
        mav.addObject("error", "Forkert login");
        return mav;
    }

    @GetMapping("/logout")
    public ModelAndView logout(HttpSession session) {
        session.invalidate();
        return new ModelAndView("redirect:/login");
    }
}