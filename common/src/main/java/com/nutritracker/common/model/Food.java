package com.nutritracker.common.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;


/**
 * The persistent class for the FOOD database table.
 * 
 */
@Entity
public class Food implements Serializable, Persistable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="FOOD_ID_GENERATOR")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="FOOD_ID_GENERATOR")
	private Long id;

	@Column(name="CALCIUM_MG")
	private BigDecimal calciumMg;

	private BigDecimal calories;

	@Column(name="CARBS_G")
	private BigDecimal carbsG;

	@Column(name="CHOLESTEROL_MG")
	private BigDecimal cholesterolMg;

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
	@NotNull(message = "${invalid.description}")
	private String shortDesc;

	@Column(name="SODIUM_MG")
	private BigDecimal sodiumMg;

	@Column(name="SUGAR_G")
	private BigDecimal sugarG;

	@Column(name="WATER_G")
	private BigDecimal waterG;

	public Food() {
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

	public BigDecimal getCholesterolMg() {
		return this.cholesterolMg;
	}

	public void setCholesterolMg(BigDecimal cholesterolMg) {
		this.cholesterolMg = cholesterolMg;
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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Food [id=").append(id).append(", calciumMg=")
				.append(calciumMg).append(", calories=").append(calories)
				.append(", carbsG=").append(carbsG).append(", cholesterolMg=")
				.append(cholesterolMg).append(", fatMonoG=").append(fatMonoG)
				.append(", fatPolyG=").append(fatPolyG).append(", fatSatG=")
				.append(fatSatG).append(", fiberG=").append(fiberG)
				.append(", ironMg=").append(ironMg).append(", potassiumMg=")
				.append(potassiumMg).append(", proteinG=").append(proteinG)
				.append(", shortDesc=").append(shortDesc).append(", sodiumMg=")
				.append(sodiumMg).append(", sugarG=").append(sugarG)
				.append(", waterG=").append(waterG).append("]");
		return builder.toString();
	}

	
	
}