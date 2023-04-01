package app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import app.service.UserService;

@Controller
@RequestMapping(value = "/")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController (UserService userService) {
        this.userService = userService;
    }



    @GetMapping(value = "/users")
    public String getAllUsers(ModelMap model) {
        return "users";
    }

    @PostMapping(value = "/users/get")
    public String addUser(ModelMap model) {
        return "users";
    }

    @DeleteMapping(value = "/users/delete")
    public String deleteUser(ModelMap model) {
        return "users";
    }

    @PutMapping(value = "/users/setUser")
    public String setUser(ModelMap model) {
        return "users";
    }

    @PatchMapping(value = "/users/setUsersName")
    public String setUsersName(ModelMap model) {
        return "users";
    }

    @PatchMapping(value = "/users/setUsersSurname")
    public String setUsersSurname(ModelMap model) {
        return "users";
    }

    @PatchMapping(value = "/users/setUsersAge")
    public String setUsersAge(ModelMap model) {
        return "users";
    }
}
