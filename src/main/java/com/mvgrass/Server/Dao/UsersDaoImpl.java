package com.mvgrass.Server.Dao;

import com.mvgrass.Server.Model.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UsersDaoImpl implements IUsersDao{
    @Override
    public User createUser(User user) {

        return user;
    }

    @Override
    public User getUserByLogin(String login) {
        return  new User("Maxim", new BCryptPasswordEncoder().encode("qwerty1010"), "Maximka",
                "mvgrass@gmail.com");
    }

    @Override
    public User updateUser(User user) {

        return null;
    }

    @Override
    public void delete(String user) {

    }

    @Override
    public List<User> findAllUsers() {
        return null;
    }
}
