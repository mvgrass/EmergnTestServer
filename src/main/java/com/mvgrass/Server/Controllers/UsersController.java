package com.mvgrass.Server.Controllers;

import com.mvgrass.Server.Dao.IUsersDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/users")
public class UsersController {

    @Autowired
    private IUsersDao usersDao;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public void getUsers(HttpServletRequest request, HttpServletResponse response) {

    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public void createUser(HttpServletRequest request, HttpServletResponse response) {

    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public void getUser(HttpServletRequest request, HttpServletResponse response) {

    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public void updateUser(HttpServletRequest request, HttpServletResponse response) {

    }

    @RequestMapping(value = "/", method = RequestMethod.DELETE)
    public void deleteUser(HttpServletRequest request, HttpServletResponse response) {

    }
}
