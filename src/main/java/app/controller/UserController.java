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
        return "users";
    }

    @PostMapping(value = "/users/add")
    public String addUser(ModelMap model,
                          @RequestParam(name = "name") String name,
                          @RequestParam(name = "surname") String surname,
                          @RequestParam(name = "age") int age) {
        User user = new User(name, surname, age);
        userService.add(user);

        return "redirect:/users";
    }

    @PostMapping(value = "/users/delete")
    public String deleteUser(ModelMap model,
                             @RequestParam(name = "idOfDeleted") int id) {
        User user = userService.getById(id);
        userService.delete(user);

        return "redirect:/users";
    }

    @PostMapping(value = "/users/setUser")
    public String setUser(ModelMap model,
                          @RequestParam(name = "id") int id,
                          @RequestParam(name = "newName", required = false) String name,
                          @RequestParam(name = "newSurname", required = false) String surname,
                          @RequestParam(name = "newAge", required = false) Integer age) {
        User currentUser = userService.getById(id);
        User newUser = new User(name, surname, age);
        userService.setUser(currentUser, newUser);

        return "redirect:/users";
    }

}
