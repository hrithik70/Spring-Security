package com.hrithik.dataModel;

import com.hrithik.constant.UserConstants;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class LogginUserDetails implements UserDetails {

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
        return false;
    }

    public boolean checkAccountLocked(UserDO userDO)
    {
        return !userDO.getAccountLocked();
    }

    public boolean checkAccountEnable(UserDO userDO)
    {
        return userDO.getAccountStatus().equalsIgnoreCase(UserConstants.ACTIVE);
    }
}
