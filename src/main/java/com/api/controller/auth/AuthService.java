package com.api.controller.auth;

import org.apache.catalina.User;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    public boolean isAdmin(User user) {
        return true;
    }

}
