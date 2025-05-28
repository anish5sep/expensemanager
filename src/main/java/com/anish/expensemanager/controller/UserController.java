package com.anish.expensemanager.controller;

import com.anish.expensemanager.constants.AppConstants;
import com.anish.expensemanager.entities.User;
import com.anish.expensemanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(AppConstants.BASE_URL)
public class UserController {

    @Autowired
    public UserService userService;


//    public List<User> getAllUsers(){
//        return User.get;
//    }

}
