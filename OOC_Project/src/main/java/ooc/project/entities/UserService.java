package ooc.project.entities;

import ooc.project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.sql.ResultSet;
import java.util.List;

@Service
public class UserService {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUser() {
       List<User> user = userRepository.findAll();
       return user;
    }

    public void addUser(User user) {
        userRepository.save(user);
    }


    public User getUserByUsername(String username) {
       TypedQuery<User> query = entityManager.createQuery("select c from User c where c.username = ?1", User.class);
       query.setParameter(1,username);
        if (query.getResultList().size() > 0) {
            return query.getResultList().get(0);
        } else {
            return null;
        }
    }
}