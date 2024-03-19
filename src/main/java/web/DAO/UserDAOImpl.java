package web.DAO;

import org.springframework.stereotype.Repository;
import web.model.User;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class UserDAOImpl implements UserDAO{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addUser(User user) {
        entityManager.persist(user);
        entityManager.flush();
    }

    @Override
    public void deleteUser(long id) {
        User user = entityManager.find(User.class, id);
        if (user != null){
            entityManager.remove(user);
            entityManager.flush();
        }else {
            throw new NullPointerException("Not found");
        }
    }

    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
        entityManager.flush();
    }
    @Override
    public User findUser(long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public List<User> getUserTable(){
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }

}
