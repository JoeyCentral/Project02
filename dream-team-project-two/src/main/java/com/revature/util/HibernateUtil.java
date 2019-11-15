package com.revature.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.revature.models.Backgrounds;
import com.revature.models.CharClass;
import com.revature.models.Characters;
import com.revature.models.CustomRolls;
import com.revature.models.Features;
import com.revature.models.JoinFeats;
import com.revature.models.JoinSpells;
import com.revature.models.Proficiencies;
import com.revature.models.Race;
import com.revature.models.Spells;
import com.revature.models.Spellsources;
import com.revature.models.Users;


public class HibernateUtil {

	public static SessionFactory sessionFactory;
	
	public static void configureHibernate() {
		
		Configuration configuration = new Configuration()
				.configure()
				.addAnnotatedClass(Users.class)
				.addAnnotatedClass(Proficiencies.class)
				.addAnnotatedClass(Backgrounds.class)
				.addAnnotatedClass(Race.class)
				.addAnnotatedClass(CharClass.class)
				.addAnnotatedClass(Characters.class)
				.addAnnotatedClass(Features.class)
				.addAnnotatedClass(Spells.class)
				.addAnnotatedClass(Spellsources.class)
				.addAnnotatedClass(JoinFeats.class)
				.addAnnotatedClass(JoinSpells.class)
				.addAnnotatedClass(CustomRolls.class)
				.setProperty("hibernate.connection.username", System.getenv("DT_USER"))
				.setProperty("hibernate.connection.password", System.getenv("DT_PASS"));
		
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		
	}
}
