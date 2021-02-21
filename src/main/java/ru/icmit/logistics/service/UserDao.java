package ru.icmit.logistics.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.icmit.logistics.domain.User;
import ru.icmit.logistics.repository.UserRepository;

@Component
public class UserDao {

    @Autowired
    private UserRepository userRepository;

    public User findByUsername(String username) {
        User user = userRepository.findByName(username);
        return user;
    }
}
