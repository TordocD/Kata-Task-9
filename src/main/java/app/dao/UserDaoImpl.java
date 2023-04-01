package app.dao;

import app.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {


    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void createTable() {
        entityManager.createNativeQuery("CREATE TABLE IF NOT EXISTS user(" +
                "id INT PRIMARY KEY AUTO_INCREMENT," +
                "name VARCHAR(25)," +
                "surname VARCHAR(25)," +
                "age INT);");
    }

    @Override
    public void dropTable() {
        entityManager.createNativeQuery("DROP TABLE IF EXISTS user");

    }

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("FROM User", User.class).getResultList();

    }

    @Override
    public void delete(User user) {
        entityManager.remove(user);
    }

    @Override
    public void setName(User user, String newName) {
        user.setUserName(newName);
        entityManager.merge(user);
    }

    @Override
    public void setSurname(User user, String newSurname) {
        user.setSurname(newSurname);
        entityManager.merge(user);
    }

    @Override
    public void setAge(User user, int newAge) {
        user.setAge(newAge);
        entityManager.merge(user);
    }

    @Override
    public void setUser(User currentUser, User newUser) {
        currentUser.setUserName(newUser.getName());
        currentUser.setSurname(newUser.getSurname());
        currentUser.setAge(newUser.getAge());
        entityManager.merge(currentUser);
    }
}
