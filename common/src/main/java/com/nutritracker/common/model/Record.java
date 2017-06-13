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


/**
 * The persistent class for the "RECORD" database table.
 * 
 */
@Entity
@Table(name="RECORD")
public class Record implements Serializable, Persistable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="RECORD_ID_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="RECORD_ID_GENERATOR")
	private Long id;

	@Column(name="F_ID")
	private Long fId;

	@Column(name="SERVING_SIZE")
	private BigDecimal servingSize;

	@Column(name="SERVING_UNIT")
	private String servingUnit;

	@Column(name="TIME")
	@DateTimeFormat(pattern = "dd/MM/yyy hh:mm:ss")
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
	private LocalDate time;

	//bi-directional many-to-one association to Usrr
	@ManyToOne
	@JoinColumn(name="USERNAME")
	private Usrr usrr;

	public Record() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getFId() {
		return this.fId;
	}

	public void setFId(Long fId) {
		this.fId = fId;
	}

	public BigDecimal getServingSize() {
		return this.servingSize;
	}

	public void setServingSize(BigDecimal servingSize) {
		this.servingSize = servingSize;
	}

	public String getServingUnit() {
		return this.servingUnit;
	}

	public void setServingUnit(String servingUnit) {
		this.servingUnit = servingUnit;
	}

	public LocalDate getTime() {
		return this.time;
	}

	public void setTime(LocalDate time) {
		this.time = time;
	}

	public Usrr getUsrr() {
		return this.usrr;
	}

	public void setUsrr(Usrr usrr) {
		this.usrr = usrr;
	}

}