package com.mvgrass.Server.Security;


import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Component
public class Guard {
    public boolean checkUser(Authentication authentication, String id){
        return authentication.getName().equals(id);
    }
}
