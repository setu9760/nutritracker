package com.nutritracker.common.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.joda.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * The persistent class for the USER_DAILY_NUTRI_STATS database table.
 * 
 */
@NamedQueries(value = {
		@NamedQuery(name = "getDailyStatsForDate", query = "select udns from UserDailyNutriStat udns where to_char(udns.date, 'DD-MON-YY') = upper(:date)"),
		@NamedQuery(name = "getStatsForMonth", query = "select udns from UserDailyNutriStat udns where to_char(udns.date) >= to_char(upper(:fromDate)) and to_char(udns.date) < to_char(upper(:toDate))") })
@Entity
@Table(name = "USER_DAILY_NUTRI_STATS")
public class UserDailyNutriStat extends NutriStats {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "DAILY_NUTRI_STATS_ID_GENERATOR", sequenceName = "DAILY_NUTRI_STATS_ID_GENERATOR", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DAILY_NUTRI_STATS_ID_GENERATOR")
	private Long id;

	@Column(name = "\"DATE\"")
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

	public UserDailyNutriStat(LocalDate date, Usrr usrr) {
		super();
		this.date = date;
		this.usrr = usrr;
	}

	public UserDailyNutriStat(BigDecimal waterG, BigDecimal calories, BigDecimal proteinG, BigDecimal sugarG, BigDecimal carbsG, BigDecimal fiberG, BigDecimal fatSatG,
			BigDecimal fatMonoG, BigDecimal fatPolyG, BigDecimal cholesterolMg, BigDecimal sodiumMg, BigDecimal potassiumMg, BigDecimal calciumMg, BigDecimal ironMg,
			LocalDate date, Usrr usrr) {
		super(waterG, calories, proteinG, sugarG, carbsG, fiberG, fatSatG, fatMonoG, fatPolyG, cholesterolMg, sodiumMg, potassiumMg, calciumMg, ironMg);
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

	public Usrr getUsrr() {
		return this.usrr;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UserDailyNutriStat [id=").append(id).append(", date=").append(date).append(", usrr=").append(usrr.getUsername()).append(", ").append(super.toString()).append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((usrr == null) ? 0 : usrr.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserDailyNutriStat other = (UserDailyNutriStat) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (usrr == null) {
			if (other.usrr != null)
				return false;
		} else if (!usrr.equals(other.usrr))
			return false;
		return true;
	}

}