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
 * The persistent class for the USER_DAILY_NUTRI_STATS database table.
 * 
 */
@Entity
@Table(name="USER_DAILY_NUTRI_STATS")
public class UserDailyNutriStat implements Serializable, Persistable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="DAILY_NUTRI_STATS_ID_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="DAILY_NUTRI_STATS_ID_GENERATOR")
	private Long id;

	@Column(name="CALCIUM_MG")
	private BigDecimal calciumMg;

	private BigDecimal calories;

	@Column(name="CARBS_G")
	private BigDecimal carbsG;

	@Column(name="CHOLESTEROL_mg")
	private BigDecimal CHOLESTEROL_mg;

	@Column(name="DATE")
	@DateTimeFormat(pattern = "dd/MM/yyy")
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
	private LocalDate date;

	@Column(name="FAT_MONO_G")
	private BigDecimal fatMonoG;

	@Column(name="FAT_POLY_G")
	private BigDecimal fatPolyG;

	@Column(name="FAT_SAT_G")
	private BigDecimal fatSatG;

	@Column(name="FIBER_G")
	private BigDecimal fiberG;

	@Column(name="IRON_MG")
	private BigDecimal ironMg;

	@Column(name="POTASSIUM_MG")
	private BigDecimal potassiumMg;

	@Column(name="PROTEIN_G")
	private BigDecimal proteinG;

	@Column(name="SHORT_DESC")
	private String shortDesc;

	@Column(name="SODIUM_MG")
	private BigDecimal sodiumMg;

	@Column(name="SUGAR_G")
	private BigDecimal sugarG;

	@Column(name="WATER_G")
	private BigDecimal waterG;

	//bi-directional many-to-one association to Usrr
	@ManyToOne
	@JoinColumn(name="USERNAME")
	private Usrr usrr;

	public UserDailyNutriStat() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getCalciumMg() {
		return this.calciumMg;
	}

	public void setCalciumMg(BigDecimal calciumMg) {
		this.calciumMg = calciumMg;
	}

	public BigDecimal getCalories() {
		return this.calories;
	}

	public void setCalories(BigDecimal calories) {
		this.calories = calories;
	}

	public BigDecimal getCarbsG() {
		return this.carbsG;
	}

	public void setCarbsG(BigDecimal carbsG) {
		this.carbsG = carbsG;
	}

	public BigDecimal getCHOLESTEROL_mg() {
		return this.CHOLESTEROL_mg;
	}

	public void setCHOLESTEROL_mg(BigDecimal CHOLESTEROL_mg) {
		this.CHOLESTEROL_mg = CHOLESTEROL_mg;
	}

	public LocalDate getDate() {
		return this.date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public BigDecimal getFatMonoG() {
		return this.fatMonoG;
	}

	public void setFatMonoG(BigDecimal fatMonoG) {
		this.fatMonoG = fatMonoG;
	}

	public BigDecimal getFatPolyG() {
		return this.fatPolyG;
	}

	public void setFatPolyG(BigDecimal fatPolyG) {
		this.fatPolyG = fatPolyG;
	}

	public BigDecimal getFatSatG() {
		return this.fatSatG;
	}

	public void setFatSatG(BigDecimal fatSatG) {
		this.fatSatG = fatSatG;
	}

	public BigDecimal getFiberG() {
		return this.fiberG;
	}

	public void setFiberG(BigDecimal fiberG) {
		this.fiberG = fiberG;
	}

	public BigDecimal getIronMg() {
		return this.ironMg;
	}

	public void setIronMg(BigDecimal ironMg) {
		this.ironMg = ironMg;
	}

	public BigDecimal getPotassiumMg() {
		return this.potassiumMg;
	}

	public void setPotassiumMg(BigDecimal potassiumMg) {
		this.potassiumMg = potassiumMg;
	}

	public BigDecimal getProteinG() {
		return this.proteinG;
	}

	public void setProteinG(BigDecimal proteinG) {
		this.proteinG = proteinG;
	}

	public String getShortDesc() {
		return this.shortDesc;
	}

	public void setShortDesc(String shortDesc) {
		this.shortDesc = shortDesc;
	}

	public BigDecimal getSodiumMg() {
		return this.sodiumMg;
	}

	public void setSodiumMg(BigDecimal sodiumMg) {
		this.sodiumMg = sodiumMg;
	}

	public BigDecimal getSugarG() {
		return this.sugarG;
	}

	public void setSugarG(BigDecimal sugarG) {
		this.sugarG = sugarG;
	}

	public BigDecimal getWaterG() {
		return this.waterG;
	}

	public void setWaterG(BigDecimal waterG) {
		this.waterG = waterG;
	}

	public Usrr getUsrr() {
		return this.usrr;
	}

	public void setUsrr(Usrr usrr) {
		this.usrr = usrr;
	}

}