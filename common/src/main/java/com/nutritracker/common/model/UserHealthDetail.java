package com.nutritracker.common.model;

import java.io.Serializable;
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

import com.nutritracker.common.annotation.StandardDecimal;

/**
 * The persistent class for the USER_HEALTH_DETAILS database table.
 * 
 */
@Entity
@Table(name = "USER_HEALTH_DETAILS")
public class UserHealthDetail implements Serializable, Persistable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "HEALTH_DETAILS_ID_GENERATOR")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "HEALTH_DETAILS_ID_GENERATOR")
	private Long id;

	@Column(name = "BODY_FAT")
	@StandardDecimal
	private BigDecimal bodyFat;

	@Column(name = "BODYWEIGHT_KG")
	@StandardDecimal
	private BigDecimal bodyweightKg;

	@Column(name = "RECORD_TIME")
	@DateTimeFormat(pattern = "dd/MM/yyy hh:mm:ss")
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
	private LocalDate recordTime;

	// bi-directional many-to-one association to Usrr
	@ManyToOne
	@JoinColumn(name = "USERNAME")
	private Usrr usrr;

	public UserHealthDetail() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getBodyFat() {
		return this.bodyFat;
	}

	public void setBodyFat(BigDecimal bodyFat) {
		this.bodyFat = bodyFat;
	}

	public BigDecimal getBodyweightKg() {
		return this.bodyweightKg;
	}

	public void setBodyweightKg(BigDecimal bodyweightKg) {
		this.bodyweightKg = bodyweightKg;
	}

	public LocalDate getRecordTime() {
		return this.recordTime;
	}

	public void setRecordTime(LocalDate recordTime) {
		this.recordTime = recordTime;
	}

	public Usrr getUsrr() {
		return this.usrr;
	}

	public void setUsrr(Usrr usrr) {
		this.usrr = usrr;
	}

}