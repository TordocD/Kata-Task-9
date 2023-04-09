package app.controller;

import app.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import app.service.UserService;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController (UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/users")
    public String getAllUsers(ModelMap model) {
        model.addAttribute("users", userService.getAllUsers());
        model.addAttribute("user", new User());

        return "users";
    }

    @PostMapping(value = "/users/add")
    public String addUser(@ModelAttribute User user) {
        userService.add(user);
        return "redirect:/users";

    }

    @PostMapping(value = "/users/delete")
    public String deleteUser(@ModelAttribute User user) {
        userService.deleteById(user.getId());

        return "redirect:/users";
    }

    @PostMapping(value = "/users/setUser")
    public String setUser(@ModelAttribute User user) {
        userService.setUser(user);

        return "redirect:/users";
    }
}
