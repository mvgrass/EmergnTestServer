package com.mvgrass.Server.Security;

import com.mvgrass.Server.Dao.IUsersDao;
import com.mvgrass.Server.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    IUsersDao dao;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = dao.getUserByLogin(s);

        if(user==null)
            throw new UsernameNotFoundException(s);

        return new MyUserPrincipal(user);
    }
}
