package app.service;

import app.model.User;

import java.util.List;

public interface UserService {

    void createTable();
    void dropTable();
    List<User> getAllUsers();
    void delete(User user);
    void setName(User user, String newName);
    void setSurname(User user, String newSurname);
    void setAge(User user, int newAge);
    void setUser(User currentUser, User newUser);
}
