package com.rutas.conductor.creacion_de_rutas.domain.factory;

import com.rutas.conductor.creacion_de_rutas.domain.model.User;

public class FactoryUserDataTest {
    public static User getUser() {
        User user = new User();
        user.setUserId(1L);
        user.setUserName("Juan");
        user.setUserSurname("Perez");
        user.setUserPhone(123456789L);
        user.setUserAddress("Calle 123");
        user.setUserEmail("oscar.javier_alvarado@outlook.com");
        user.setUserPassword("Contrasena123*");
        return user;
    }
}
