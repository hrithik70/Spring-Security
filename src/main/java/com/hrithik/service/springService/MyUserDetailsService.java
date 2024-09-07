package com.hrithik.service.springService;

import com.hrithik.dataModel.LogginUserDetails;
import com.hrithik.dataModel.UserDO;
import com.hrithik.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDO user = userRepository.findByUserName(username);
        if(user == null && user.getUserName() == null)
            throw new UsernameNotFoundException("User not Found...");
        return new LogginUserDetails(user);
    }
}
