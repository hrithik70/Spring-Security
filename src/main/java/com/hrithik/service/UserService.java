package com.hrithik.service;

import com.hrithik.dataModel.UserDO;
import com.hrithik.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;

    public UserDO save(UserDO userDO) {
        try {
            userDO.setAccountStartDt(LocalDateTime.now());
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(5);
            userDO.setPassword(passwordEncoder.encode(userDO.getPassword()));
            return userRepository.save(userDO);
        } catch (Exception e) {
            LOGGER.info(" **** Error in User Save : [{}] *** ", e.getMessage());
        }
        return null;
    }

    public List<UserDO> getUserList() {
        List<UserDO> users = null;
        try {
            users = userRepository.findAll();
        } catch (Exception e) {
            LOGGER.info(" **** Error in Get User List : [{}] *** ", e.getMessage());
        }
        return users;
    }
}
