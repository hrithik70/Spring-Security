package com.hrithik.dataModel;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "USER")
public class UserDO {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String userName;
    private String password;
    private LocalDateTime accountStartDt;
    private LocalDateTime accountExpiryDt;
    private Boolean isAccountLocked;
    private String accountStatus;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getAccountStartDt() {
        return accountStartDt;
    }

    public void setAccountStartDt(LocalDateTime accountStartDt) {
        this.accountStartDt = accountStartDt;
    }

    public LocalDateTime getAccountExpiryDt() {
        return accountExpiryDt;
    }

    public void setAccountExpiryDt(LocalDateTime accountExpiryDt) {
        this.accountExpiryDt = accountExpiryDt;
    }

    public Boolean getAccountLocked() {
        return isAccountLocked;
    }

    public void setAccountLocked(Boolean accountLocked) {
        isAccountLocked = accountLocked;
    }

    public String getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }
}
