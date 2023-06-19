package com.jcg.hibernate.manytoone.mapping;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class AppMain {

	private static SessionFactory buildSessionFactory() {

		SessionFactory sessionFactoryObj = new Configuration().configure("user-cfg.xml").buildSessionFactory();
		return sessionFactoryObj;
	}

	public static void main(String[] args) {
		Session sessionObj = null;

		System.out.println("\n.......Hibernate Many To One Mapping Example.......\n");
		try {
			// Getting Session Object From SessionFactory.
			sessionObj = buildSessionFactory().openSession();

			sessionObj.beginTransaction();

			Department department = new Department("Technology", "Sector 18, Gurugram");

			Employee employee1 = new Employee("Rahul", department);
			Employee employee2 = new Employee("Virat", department);

			sessionObj.save(employee1);
			sessionObj.save(employee2);

			// Committing The Transactions To The Database.
			sessionObj.getTransaction().commit();

			System.out.println("\n.......Records Saved Successfully To The Database.......\n");
		} catch(HibernateException hibernateException) {
			if(sessionObj != null && 
					sessionObj.getTransaction() != null) {
				System.out.println("\n.......Transaction Is Being Rolled Back.......");
				sessionObj.getTransaction().rollback();
			}
			hibernateException.printStackTrace();
		} finally {
			if(sessionObj != null) {
				sessionObj.close();
			}
		}
	}
}
