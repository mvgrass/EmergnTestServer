package com.mvgrass.Server.Controllers;

import com.mvgrass.Server.Dao.IUsersDao;
import com.mvgrass.Server.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/users")
public class UsersController {

    @Autowired
    private IUsersDao usersDao;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<User> getUsers(HttpServletRequest request) {
        String login = request.getParameter("login");
        String name = request.getParameter("name");
        String email = request.getParameter("email");

        if(login!=null||name!=null||email!=null)
            return usersDao.findAllUsers(login, name, email);
        else
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
        return usersDao.updateUser(login, user);
    }

    @RequestMapping(value = "/{login}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteUser(@PathVariable String login) {
        usersDao.delete(login);
    }
}
