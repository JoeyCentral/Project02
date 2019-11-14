package com.revature.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.revature.models.User;


public class HibernateUtil {

	public static SessionFactory sessionFactory;
	
	public static void configureHibernate() {
		
		Configuration configuration = new Configuration()
				.configure()
				.addAnnotatedClass(User.class)
				.setProperty("hibernate.connection.username", System.getenv("DT_USER"))
				.setProperty("hibernate.connection.password", System.getenv("DT_PASS"));
		
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		
	}
}
