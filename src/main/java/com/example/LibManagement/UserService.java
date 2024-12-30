//5
package com.example.LibManagement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(User user){
        return userRepository.save(user);
    }
    public List<User> fetchAllUsers() {
        return userRepository.findAll();
    }
    public Optional<User> getAccount(Long id){
        return userRepository.findById(id);
    }
}
