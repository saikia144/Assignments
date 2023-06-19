package com.user.crud;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.user.model.User;

public class CrudUser {
	private static SessionFactory sessionFactory = null;
	private static Transaction tx = null;
	private static List<User> uList = null;

	public static List<User> selectAllUser() {

	    try {
	    	Session session = HibernateUtil.getSessionFactory().openSession();
	        tx = session.beginTransaction();

	        //HQL query
	        String hql = "FROM User";
	        Query<User> query = session.createQuery(hql, User.class);

	        uList = query.getResultList();

	        tx.commit();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return uList;
	}

	public static void updateUserDb(User user) {
		//System.out.println(HibernateUtil.getSessionFactory().getCurrentSession());
		Session ses = HibernateUtil.getSessionFactory().openSession();
		tx=ses.beginTransaction();
		ses.update(user);
		tx.commit();
		ses.close();
	}

	public static void deleteUserDb(int id) {
		sessionFactory = HibernateUtil.getSessionFactory();
		Session ses = sessionFactory.openSession();
		tx = ses.beginTransaction();
		User user = ses.get(User.class, id);
		if(user!=null) {
			ses.delete(user);
		}
		tx.commit();
		ses.close();
		sessionFactory.close();
	}
	
	public static void insertUserDb(User user) {
		sessionFactory = HibernateUtil.getSessionFactory();
		Session ses = sessionFactory.openSession();
		tx = ses.beginTransaction();
		ses.save(user);
		tx.commit();
		ses.close();
		sessionFactory.close();
	}
}
