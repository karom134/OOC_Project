package ooc.project.entities;

import ooc.project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
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

    public void deleteUser(Integer integer) {
        userRepository.deleteById(integer);
    }

    public List<User> getUserByUsername(String username) {
        TypedQuery query = entityManager.createQuery("select c from User c where c.username = ?1", User.class);
        query.setParameter(1,username);
        return query.getResultList();
    }
}