package com.desai.local.test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaDelete;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.Criteria;
import org.hibernate.LockMode;
import org.joda.time.DateTimeZone;
import org.joda.time.LocalDate;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;

import com.nutritracker.common.model.Food;
import com.nutritracker.common.model.Record;
import com.nutritracker.common.model.UserDailyNutriStat;
import com.nutritracker.common.model.UserHealthDetail;
import com.nutritracker.common.model.UserLoginDetail;
import com.nutritracker.common.model.Usrr;

public class Main {

	public static void main(String[] args) throws IOException {
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		ds.setUrl("jdbc:oracle:thin:@localhost:1521:nutritrcr");
		ds.setUsername("U1");
		ds.setPassword("password");
		
//		final Map<String, String> properties = new HashMap<String, String>();
//		properties.put("javax.persistence.jdbc.driver", "oracle.jdbc.driver.OracleDriver");
//		properties.put("javax.persistence.jdbc.url", "jdbc:oracle:thin:@localhost:1521:nutritrcr");
//		properties.put("javax.persistence.jdbc.user", "U1");
//		properties.put("javax.persistence.jdbc.password", "password");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("nutritracker");
		EntityManager em = emf.createEntityManager();
		
		em.find(Food.class,  new Long(1163));
		
		Usrr u = new Usrr();
		u.setUsername("TestUser");
		u.setEmail("test@abc.com");
		u.setCountry("GB");
		u.setDob(new LocalDate(1991, 8, 25));
		u.setTimezone(DateTimeZone.getDefault().toString());
		
		em.getTransaction().begin();
		em.merge(u);
		em.getTransaction().commit();
		
		Usrr u2 = new Usrr();
		u2.setUsername("TestUser");
		u2.setEmail("test@abc.com");
		u2.setCountry("GB");
		u2.setDob(new LocalDate(1991, 8, 25));
		u2.setTimezone(DateTimeZone.getDefault().toString());
		
		em.getTransaction().begin();
		em.remove(u2);
		em.getTransaction().commit();
		
//		Properties props = new Properties();
//		props.setProperty("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
//		props.setProperty("hibernate.show_sql", "true");
//		props.setProperty("hibernate.connection.autocommit", "true");
		
//		LocalSessionFactoryBean sf = new LocalSessionFactoryBean();
//		sf.setDataSource(ds);
//		sf.setHibernateProperties(props);
//		sf.setAnnotatedClasses(Food.class, Record.class, UserDailyNutriStat.class, UserHealthDetail.class, UserLoginDetail.class, Usrr.class);
//		sf.afterPropertiesSet();
//		
//		HibernateTemplate ht = new HibernateTemplate(sf.getObject());
//		ht.setCheckWriteOperations(false);
//		
//		Food f =	ht.get(Food.class, new Long(1163), LockMode.READ);
//		System.out.println(f);
//		
//		Usrr u = new Usrr();
//		u.setUsername("TestUser");
//		u.setEmail("test@abc.com");
//		u.setCountry("GB");
//		u.setDob(new LocalDate(1991, 8, 25));
//		ht.getSessionFactory().getCurrentSession().beginTransaction();
//		ht.save(u);
//		ht.getSessionFactory().getCurrentSession().getTransaction().commit();
		
		}
	
}
