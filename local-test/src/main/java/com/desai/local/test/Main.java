package com.desai.local.test;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import org.apache.commons.dbcp.BasicDataSource;
import org.joda.time.DateTimeZone;
import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;

import com.nutritracker.common.model.Food;
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

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("nutritracker");
		EntityManager em = emf.createEntityManager();

		Usrr u = new Usrr();
		u.setUsername("Taaaaaaaaaa");
		u.setEmail("tes£t@abc123.com");
		u.setCountry("GB");
		u.setDob(new LocalDate(1991, 8, 25));
		u.setTimezone(DateTimeZone.getDefault().toString());
		
		u = em.find(Usrr.class, "TestUser");
//		UserHealthDetail uhd = new UserHealthDetail(new BigDecimal(12.5), new BigDecimal(65), u);
//		u.addUserHealthDetail(uhd);
//		uhd.setRecordTime(LocalDateTime.now().minusDays(3));

		UserDailyNutriStat udns = new UserDailyNutriStat(LocalDate.now(), u);
		UserDailyNutriStat udns2 = new UserDailyNutriStat(LocalDate.now().minusDays(4), u);
		UserDailyNutriStat udns3 = new UserDailyNutriStat(LocalDate.now().minusDays(55), u);
		
		UserLoginDetail uld = new UserLoginDetail(u, "password");
		
		em.getTransaction().begin();
//		em.merge(u);
//		em.persist(udns);
//		em.persist(udns2);
//		em.persist(udns3);
//		em.merge(uld);
//		em.merge(uhd);
//		em.createNamedQuery("resetUser").setParameter("username", u.getUsername()).executeUpdate();;
		
		em.getTransaction().commit();

		System.out.println(LocalDate.now().minusDays(3).toString("dd-MMM-yy"));
		
		TypedQuery<Food> tq= em.createNamedQuery("findFoodWithCaloriesLessThan", Food.class);
//		tq.setParameter("date", LocalDate.now().toString("dd-MMM-yy"));
//		tq.setParameter("fromDate", LocalDate.now().minusDays(5).toString("dd-MMM-yy")).setParameter("toDate", LocalDate.now().minusDays(1).toString("dd-MMM-yy"));
		tq.setParameter("calories", new BigDecimal(10));
		System.out.println(tq.getResultList());
//		
		
		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
		Set<ConstraintViolation<Usrr>> violations = validator.validate(u);

		violations = validator.validate(u);
		for (ConstraintViolation<Usrr> constraintViolation : violations) {
			System.out.println(constraintViolation);
		}
		
		System.exit(-1);
	}

}
