package com.theo.services;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestConexion {

    private static TestConexion instance = null;
    private EntityManagerFactory factory = null;

    public static TestConexion getInstance() {
        if (instance == null) {
            instance = new TestConexion();
        }
        return instance;
    }

    public EntityManagerFactory getFactory() {
        try {
            if (factory == null) {
                factory = Persistence.createEntityManagerFactory("TestWebAppPU");
            }
        } catch (Exception e) {
            throw e;
        }
        return factory;
    }

}
