package app.service;

import app.model.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();
    void add(User user);
    User getById(int id);
    void deleteById(Integer id);
    void updateUser(User newUser);
}
