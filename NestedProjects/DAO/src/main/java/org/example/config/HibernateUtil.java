package org.example.config;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateUtil {

	public static final SessionFactory sessionFactory;
	private static final ServiceRegistry serviceRegistry;
	private static Session sess=null;
	static {
		Configuration conf = new Configuration();
		conf.configure();
		serviceRegistry = new ServiceRegistryBuilder().applySettings(conf.getProperties()).buildServiceRegistry();
		try {
			sessionFactory = conf.buildSessionFactory(serviceRegistry);
		} catch (Exception e) {
			System.err.println("Initial SessionFactory creation failed." + e);
			throw new ExceptionInInitializerError(e);
		}
	}

	public static Session getSession(){
		
		try {
            sess = sessionFactory.getCurrentSession();
        } catch (org.hibernate.HibernateException he) {
            sess = sessionFactory.openSession();
        }
		if(!sess.getTransaction().isActive())
			sess.beginTransaction();
		return sess;
	}

	public static void commit(){
		if(sess.getTransaction().isActive())
			sess.getTransaction().commit();
	}

	public static void save(Object o){
		getSession().saveOrUpdate(o);
		commit();
	}
}
