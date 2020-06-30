package ooc.project.entities;

import ooc.project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
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

    public List<User> getUserByUsername(String username){
        return null;//edit later.
    }
}