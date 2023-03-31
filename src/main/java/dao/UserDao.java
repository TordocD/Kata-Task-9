package dao;

import model.User;

import java.util.List;

public interface UserDao {

    void createTable();
    void dropTable();
    List<User> getAllUsers();
    void delete(User user);
    void setName(User user, String newName);
    void setSurname(User user, String newSurname);
    void setAge(User user, int newAge);
    void setUser(User currentUser, User newUser);
}
