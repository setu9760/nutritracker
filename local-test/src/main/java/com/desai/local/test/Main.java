package com.desai.local.test;

import java.io.IOException;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import org.apache.commons.dbcp.BasicDataSource;
import org.joda.time.DateTimeZone;
import org.joda.time.LocalDate;

import com.nutritracker.common.model.Food;
import com.nutritracker.common.model.Usrr;

public class Main {

	public static void main(String[] args) throws IOException {
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		ds.setUrl("jdbc:oracle:thin:@localhost:1521:nutritrcr");
		ds.setUsername("U1");
		ds.setPassword("password");

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("nutritracker");
		EntityManager em = emf.createEntityManager();

		em.find(Food.class, new Long(9790));

		Usrr u = new Usrr();
		u.setUsername("TestUser");
		u.setEmail("test@abc.com");
		u.setCountry("GB");
		u.setDob(new LocalDate(1991, 8, 25));
		u.setTimezone(DateTimeZone.getDefault().toString());

		em.getTransaction().begin();
		em.merge(u);
		em.getTransaction().commit();

		Food f = new Food();
		f.setShortDesc("AB");
		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
		Set<ConstraintViolation<Food>> violations = validator.validate(f);

		violations = validator.validate(f);
		for (ConstraintViolation<Food> constraintViolation : violations) {
			System.out.println(constraintViolation);
		}
		
		System.exit(-1);
	}

}
