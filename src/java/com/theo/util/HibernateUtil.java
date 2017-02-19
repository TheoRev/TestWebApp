package com.theo.util;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static SessionFactory sessionFactory;

    static {
        try {
            Configuration configuration = new Configuration();
            sessionFactory = configuration.configure("hibernate.cfg.xml").buildSessionFactory(
                    new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build());
        } catch (HibernateException e) {
            System.err.println("ERROR: " + e.getMessage());
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
