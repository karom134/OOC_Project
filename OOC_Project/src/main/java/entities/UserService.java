package entities;

import org.springframework.beans.factory.annotation.Autowired;
import repository.UserRepository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    public void addUser(User user) {
        userRepository.save(user);
    }

    public void deleteUser(Integer integer) {
        userRepository.deleteById(integer);
    }
}
