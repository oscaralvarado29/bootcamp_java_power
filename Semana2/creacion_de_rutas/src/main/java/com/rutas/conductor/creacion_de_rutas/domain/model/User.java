package com.rutas.conductor.creacion_de_rutas.domain.model;

public class User {

    private Long userId;
    private String userName;
    private String userSurname;
    private Long userPhone;
    private String userAddress;
    private String userEmail;
    private String userPassword;

    public User(){}
    public User(Long userId, String userName, String userSurname, Long userPhone, String userAddress, String userEmail, String userPassword) {
        this.userId = userId;
        this.userName = userName;
        this.userSurname = userSurname;
        this.userPhone = userPhone;
        this.userAddress = userAddress;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserSurname() {
        return userSurname;
    }

    public void setUserSurname(String userSurname) {
        this.userSurname = userSurname;
    }

    public Long getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(Long userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}

