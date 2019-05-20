package com.mvgrass.Server.Controllers;

import com.mvgrass.Server.Dao.IUsersDao;
import com.mvgrass.Server.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UsersController {

    @Autowired
    private IUsersDao usersDao;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<User> getUsers() {
        return usersDao.findAllUsers();

    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public User createUser(@RequestBody User user) {
        return usersDao.createUser(user);
    }

    @RequestMapping(value = "/{login}", method = RequestMethod.GET)
    public User getUser(@PathVariable String login) {
        return usersDao.getUserByLogin(login);
    }

    @RequestMapping(value = "/{login}", method = RequestMethod.PUT)
    public User updateUser(@PathVariable String login, @RequestBody User user) {
        return usersDao.updateUser(user);
    }

    @RequestMapping(value = "/{login}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable String login) {
        usersDao.delete(login);
    }
}
