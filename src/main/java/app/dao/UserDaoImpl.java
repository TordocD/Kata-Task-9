package app.dao;

import app.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {


    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void createTable() {
        entityManager.createNativeQuery("CREATE TABLE IF NOT EXISTS user(" +
                "id INT PRIMARY KEY AUTO_INCREMENT, " +
                "name VARCHAR(25), " +
                "surname VARCHAR(25), " +
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
    public User getById(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void add(User user) {
        entityManager.persist(user);
    }

    @Override
    public void deleteById(Integer id) {
        Query query = entityManager.createQuery("DELETE User WHERE id= :id");
        query.setParameter("id", id);
        query.executeUpdate();
    }

    @Override
    public void setUser(User newUser) {
        entityManager.merge(newUser);
    }
}
