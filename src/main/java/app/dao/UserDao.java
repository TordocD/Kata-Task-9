package app.dao;

import app.model.User;

import java.util.List;


public interface UserDao {

    void createTable();
    void dropTable();
    List<User> getAllUsers();
    void add(User user);
    User getById(int id);
    void deleteById(Integer id);
    void updateUser(User newUser);
}
