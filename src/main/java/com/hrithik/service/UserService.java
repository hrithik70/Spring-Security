package com.hrithik.service;

import com.hrithik.dataModel.UserDO;
import com.hrithik.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserDO save(UserDO userDO) {
        try{
            userDO.setAccountStartDt(LocalDateTime.now());
            return userRepository.save(userDO);
        }catch (Exception e)
        {
           e.printStackTrace();
        }
        return null;
    }

    public List<UserDO> getUserList() {
        List<UserDO> users = null;
        try
        {
            users = userRepository.findAll();
        }catch (Exception e)
        {
           e.printStackTrace();
        }
        return users;
    }
}
