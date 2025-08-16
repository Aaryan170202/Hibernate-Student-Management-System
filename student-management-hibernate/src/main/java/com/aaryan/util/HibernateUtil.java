package com.aaryan.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static final SessionFactory sessionFactory;

    static {
        try {
        	Configuration config = new Configuration();
    		config.configure("hibernate.cfg.xml");
    		config.addAnnotatedClass(com.aaryan.model.Student.class);    		
    		sessionFactory = config.buildSessionFactory();
    		
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError("Initial SessionFactory creation failed " + ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
