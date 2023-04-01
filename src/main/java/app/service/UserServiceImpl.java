package app.service;

import app.dao.UserDao;
import app.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void createTable() {
        userDao.createTable();
    }

    @Override
    public void dropTable() {
        userDao.dropTable();
    }

    @Override
    @Transactional
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    @Transactional
    public void delete(User user) {
        userDao.delete(user);
    }

    @Override
    @Transactional
    public void setName(User user, String newName) {
        userDao.setName(user, newName);
    }

    @Override
    @Transactional
    public void setSurname(User user, String newSurname) {
        userDao.setSurname(user, newSurname);
    }

    @Override
    @Transactional
    public void setAge(User user, int newAge) {
        userDao.setAge(user, newAge);
    }

    @Override
    @Transactional
    public void setUser(User currentUser, User newUser) {
        userDao.setUser(currentUser, newUser);
    }
}
