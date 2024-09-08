package com.hrithik.service.springService;

import com.hrithik.constant.UserConstants;
import com.hrithik.dataModel.UserDO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class LogginUserDetails implements UserDetails {

    private static final Logger LOGGER = LoggerFactory.getLogger(LogginUserDetails.class);

    private final UserDO userDO;

    public LogginUserDetails(UserDO user)
    {
        this.userDO= user;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority("USER"));
    }

    @Override
    public String getPassword() {
        return userDO.getPassword();
    }

    @Override
    public String getUsername() {
        return userDO.getUserName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return checkAccountExpiry(userDO);
    }

    @Override
    public boolean isAccountNonLocked() {
        return checkAccountLocked(userDO);
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return checkAccountExpiry(userDO);
    }

    @Override
    public boolean isEnabled() {
        return checkAccountEnable(userDO);
    }

    public boolean checkAccountExpiry(UserDO userDO) {
        if (userDO.getAccountStartDt() != null)
            return userDO.getAccountStartDt().isBefore(userDO.getAccountExpiryDt());
        LOGGER.info("******** User Account Expiry : [{}] ********** " ,userDO.getAccountStartDt().isBefore(userDO.getAccountExpiryDt()));
        return false;
    }

    public boolean checkAccountLocked(UserDO userDO)
    {
        LOGGER.info("****** User Account Locked : [{}] ******* " ,userDO.getAccountLocked());
        return !userDO.getAccountLocked();
    }

    public boolean checkAccountEnable(UserDO userDO)
    {
        LOGGER.info("******** User Account Enable : [{}] ********* " , userDO.getAccountStatus());
        return userDO.getAccountStatus().equalsIgnoreCase(UserConstants.ACTIVE);
    }
}
