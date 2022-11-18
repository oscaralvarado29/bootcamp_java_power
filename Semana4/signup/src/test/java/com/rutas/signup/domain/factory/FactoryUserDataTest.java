package com.rutas.signup.domain.factory;

import com.rutas.signup.domain.model.User;

public class FactoryUserDataTest {
    public static User getUser(){
        User user = new User();
        user.setName("Juan");
        user.setFamilyName("Perez");
        user.setPhoneNumber("+123456789");
        user.setAddress("Calle 123");
        user.setEmail("oscar.javier_alvarado@outlook.com");
        user.setPassword("Contrasena123*");
        user.setUsername("juan.perez");

        return user;
    }
}
