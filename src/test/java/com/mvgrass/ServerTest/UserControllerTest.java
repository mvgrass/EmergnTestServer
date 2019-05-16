package com.mvgrass.ServerTest;

import com.mvgrass.Server.Application;
import com.mvgrass.Server.Dao.IUsersDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class UserControllerTest {

    @Autowired
    IUsersDao dao;

    @Test
    public void daoWiring(){
        Assert.notNull(dao,"ll");
    }
}
