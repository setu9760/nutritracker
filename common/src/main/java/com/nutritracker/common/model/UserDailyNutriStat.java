package com.nutritracker.common.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.joda.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * The persistent class for the USER_DAILY_NUTRI_STATS database table.
 * 
 */
@Entity
@Table(name = "USER_DAILY_NUTRI_STATS")
public class UserDailyNutriStat extends NutriStats {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "DAILY_NUTRI_STATS_ID_GENERATOR", sequenceName = "DAILY_NUTRI_STATS_ID_GENERATOR", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DAILY_NUTRI_STATS_ID_GENERATOR")
	private Long id;

	@Column(name = "DATE")
	@DateTimeFormat(pattern = "dd/MM/yyy")
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
	private LocalDate date;

	// bi-directional many-to-one association to Usrr
	@ManyToOne
	@JoinColumn(name = "USERNAME")
	private Usrr usrr;

	UserDailyNutriStat() {
		super();
		this.date = LocalDate.now();
	}

	public UserDailyNutriStat(String shortDesc, BigDecimal waterG, BigDecimal calories, BigDecimal proteinG, BigDecimal sugarG, BigDecimal carbsG, BigDecimal fiberG,
			BigDecimal fatSatG, BigDecimal fatMonoG, BigDecimal fatPolyG, BigDecimal cholesterolMg, BigDecimal sodiumMg, BigDecimal potassiumMg, BigDecimal calciumMg,
			BigDecimal ironMg, LocalDate date, Usrr usrr) {
		super(shortDesc, waterG, calories, proteinG, sugarG, carbsG, fiberG, fatSatG, fatMonoG, fatPolyG, cholesterolMg, sodiumMg, potassiumMg, calciumMg, ironMg);
		this.date = date;
		this.usrr = usrr;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDate() {
		return this.date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Usrr getUsrr() {
		return this.usrr;
	}

	public void setUsrr(Usrr usrr) {
		this.usrr = usrr;
	}
}