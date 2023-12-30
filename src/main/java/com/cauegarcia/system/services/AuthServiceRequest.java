package com.cauegarcia.system.services;

import com.cauegarcia.system.entities.User;
import com.cauegarcia.system.services.exceptions.ForbiddenException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceRequest {

    @Autowired
    private UserService userService;

    public void validateSelforAdminRequest(long userId) {
        User mySelf = userService.authenticated();
        if (!mySelf.hasRole("ROLE_ADMIN") && !mySelf.getId().equals(userId)) {
            throw new ForbiddenException("Access denied.");
        }
    }
}
