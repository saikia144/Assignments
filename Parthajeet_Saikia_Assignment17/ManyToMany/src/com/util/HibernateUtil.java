package com.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static SessionFactory sessionFactory;
	
	public static SessionFactory getSessionFactory() {
		sessionFactory = new Configuration().configure("user-cfg.xml").buildSessionFactory();
        return sessionFactory;
    }
}
