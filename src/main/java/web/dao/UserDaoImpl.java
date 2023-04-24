package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> listUser() {
        return entityManager.createQuery("SELECT u FROM User u", User.class).getResultList();
    }

    @Override
    public void saveUser(User user) {
        entityManager.merge(user);
    }

    public void updateUser(User user) {
        Query query = entityManager.createQuery("UPDATE User u SET u.name = :name, u.surname = :surname, u.age = :age WHERE u.id = :id");
        query.setParameter("name", user.getName());
        query.setParameter("surname", user.getSurname());
        query.setParameter("age", user.getAge());
        query.setParameter("id", user.getId());
        query.executeUpdate();
    }

    @Override
    public User getUser(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void deleteUser(int id) {
        entityManager.remove(getUser(id));
    }
}
