package com.hrithik.controller;

import com.hrithik.dataModel.UserDO;
import com.hrithik.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    ResponseEntity<UserDO> saveUser(@RequestBody UserDO userDO)
    {
        UserDO user = userService.save(userDO);
        return new ResponseEntity<UserDO>(user, HttpStatus.OK);
    }

    @RequestMapping(value = "/getUsers", method = RequestMethod.GET)
    ResponseEntity<List<UserDO>> getUsers()
    {
        List<UserDO> userList = userService.getUserList();
        return new ResponseEntity<List<UserDO>>(userList, HttpStatus.OK);
    }
}
