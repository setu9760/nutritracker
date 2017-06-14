package com.desai.local.test;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.attribute.UserDefinedFileAttributeView;
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
import com.nutritracker.common.model.UserHealthDetail;
import com.nutritracker.common.model.UserLoginDetail;
import com.nutritracker.common.model.Usrr;
import com.nutritracker.common.model.enums.SignOnStatus;

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
		u.setUsername("TestUser");
		u.setEmail("test@abc123.com");
		u.setCountry("GB");
		u.setDob(new LocalDate(1991, 8, 25));
		u.setTimezone(DateTimeZone.getDefault().toString());
		
		UserHealthDetail uhd = new UserHealthDetail();
		uhd.setBodyFat(new BigDecimal(12.5));
		uhd.setBodyweightKg(new BigDecimal(65));
		u.addUserHealthDetail(uhd);
		uhd.setRecordTime(LocalDateTime.now().minusDays(3));

		UserLoginDetail uld = new UserLoginDetail();
		uld.setUsrr(u);
		uld.setSignOnStatus(SignOnStatus.LOGGED_OUT);
		uld.setPassword("password");
		uld.setIsLocked(false);
		
		em.getTransaction().begin();
//		em.merge(u);
//		em.merge(uld);
//		em.merge(uhd);
		
		em.getTransaction().commit();

		System.out.println(LocalDate.now().minusDays(3).toString("dd-MMM-yy"));
		
		TypedQuery<UserHealthDetail> tq= em.createNamedQuery("getStatsForMonth", UserHealthDetail.class);
		tq.setParameter("fromDate", LocalDate.now().minusDays(3).toString("dd-MMM-yy")).setParameter("toDate", LocalDate.now().minusDays(2).toString("dd-MMM-yy"));
		System.out.println(tq.getResultList());
//		Food f = new Food();
//		f.setShortDesc("AB");
//		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
//		Set<ConstraintViolation<Food>> violations = validator.validate(f);
//
//		violations = validator.validate(f);
//		for (ConstraintViolation<Food> constraintViolation : violations) {
//			System.out.println(constraintViolation);
//		}
		
		System.exit(-1);
	}

}
