package ru.icmit.logistics.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.icmit.logistics.domain.User;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        System.out.println("UserDetailsServiceImpl: loadUserByUsername");
        User user = userDao.findByUsername(username);

        if (user != null) {
            List<String> roles = new ArrayList<>();
            //TODO здесь надо правильно вытащить роли из пользователя
            roles.add("ADMIN");
            return new LoggedInUser(user, roles);
        } else {
            throw new UsernameNotFoundException(username);
        }
    }
}
