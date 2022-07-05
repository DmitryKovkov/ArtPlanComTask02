package ro.pcs.tasks02.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import ro.pcs.tasks02.models.User;
import ro.pcs.tasks02.services.UserService;

import java.security.Principal;

@RestController
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/register", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    public User addUser(@RequestBody User user){
        return userService.create(user);
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    public User getUser (Authentication authentication, Principal principal){
        return userService.getUserBylogin(principal.getName());
    }
}
