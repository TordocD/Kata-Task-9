package app.controller;

import app.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import app.service.UserService;

@Controller
public class UserController {

    private final ModelMap modelMap = new ModelMap();


    private final UserService userService;

    @Autowired
    public UserController (UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/users")
    public String getAllUsers(ModelMap model) {
        model.addAttribute("users", userService.getAllUsers());
        model.addAttribute("newUser", new User());
        model.addAttribute("deletedUser", new User());

        return "users";
    }

    @PostMapping(value = "/users/add")
    public String addUser(@ModelAttribute User newUser) {
        userService.add(newUser);
        return "redirect:/users";

    }

    @PostMapping(value = "/users/delete")
    public String deleteUser(@ModelAttribute User deletedUser) {
        userService.deleteById(deletedUser.getId());

        return "redirect:/users";
    }

    @PostMapping(value = "/users/setUser")
    public String setUser(@ModelAttribute User newUser) {
        User currentUser = userService.getById(newUser.getId());
        if (!newUser.getName().equals("")) {
            currentUser.setName(newUser.getName());
        }
        if (!newUser.getSurname().equals("")) {
            currentUser.setSurname(newUser.getSurname());
        }
        if (newUser.getAge() != null) {
            currentUser.setAge(newUser.getAge());
        }
        userService.setUser(currentUser);

        return "redirect:/users";
    }

}
