package com.mvgrass.Server.Dao;

import com.mvgrass.Server.Model.User;

import java.util.List;

public interface IUsersDao {
    User createUser(User user);
    User getUserByLogin(String login);
    User updateUser(User user);
    void delete(String user);
    List<User> findAllUsers();
}
