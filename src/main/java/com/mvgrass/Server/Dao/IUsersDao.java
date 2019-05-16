package com.mvgrass.Server.Dao;

import com.mvgrass.Server.Model.User;

public interface IUsersDao {
    void createUser(User user);
    User getUserByLogin();
    void updateUser(User user);
    void delete(User user);
}
