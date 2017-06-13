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
import javax.validation.constraints.Size;

import com.nutritracker.common.annotation.StandardDecimal;

/**
 * The persistent class for the FOOD database table.
 * 
 */
@Entity
public class Food implements Serializable, Persistable {

	private static final long serialVersionUID = 1L;
	private static final BigDecimal ZERO = new BigDecimal(0);

	@Id
	@SequenceGenerator(name = "FOOD_ID_GENERATOR", sequenceName = "FOOD_ID_GENERATOR", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "FOOD_ID_GENERATOR")
	private Long id;

	@Column(name = "SHORT_DESC")
	@NotNull(message = "{invalid.description}")
	@Size(max = 255, min = 3)
	private String shortDesc;

	@Column(name = "WATER_G")
	@StandardDecimal
	private BigDecimal waterG;

	@StandardDecimal
	private BigDecimal calories;

	@Column(name = "PROTEIN_G")
	@StandardDecimal
	private BigDecimal proteinG;

	@Column(name = "SUGAR_G")
	@StandardDecimal
	private BigDecimal sugarG;

	@Column(name = "CARBS_G")
	@StandardDecimal
	private BigDecimal carbsG;

	@Column(name = "FIBER_G")
	@StandardDecimal
	private BigDecimal fiberG;

	@Column(name = "FAT_SAT_G")
	@StandardDecimal
	private BigDecimal fatSatG;

	@Column(name = "FAT_MONO_G")
	@StandardDecimal
	private BigDecimal fatMonoG;

	@Column(name = "FAT_POLY_G")
	@StandardDecimal
	private BigDecimal fatPolyG;

	@Column(name = "CHOLESTEROL_MG")
	@StandardDecimal
	private BigDecimal cholesterolMg;

	@Column(name = "SODIUM_MG")
	@StandardDecimal
	private BigDecimal sodiumMg;

	@Column(name = "POTASSIUM_MG")
	@StandardDecimal
	private BigDecimal potassiumMg;

	@Column(name = "CALCIUM_MG")
	@StandardDecimal
	private BigDecimal calciumMg;

	@Column(name = "IRON_MG")
	@StandardDecimal
	private BigDecimal ironMg;

	public Food() {
		super();
		waterG = ZERO;
		calories = ZERO;
		proteinG = ZERO;
		sugarG = ZERO;
		carbsG = ZERO;
		fiberG = ZERO;
		fatSatG = ZERO;
		fatMonoG = ZERO;
		fatPolyG = ZERO;
		cholesterolMg = ZERO;
		sodiumMg = ZERO;
		potassiumMg = ZERO;
		calciumMg = ZERO;
		ironMg = ZERO;
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
		builder.append("Food [id=").append(id).append(", calciumMg=").append(calciumMg).append(", calories=")
				.append(calories).append(", carbsG=").append(carbsG).append(", cholesterolMg=").append(cholesterolMg)
				.append(", fatMonoG=").append(fatMonoG).append(", fatPolyG=").append(fatPolyG).append(", fatSatG=")
				.append(fatSatG).append(", fiberG=").append(fiberG).append(", ironMg=").append(ironMg)
				.append(", potassiumMg=").append(potassiumMg).append(", proteinG=").append(proteinG)
				.append(", shortDesc=").append(shortDesc).append(", sodiumMg=").append(sodiumMg).append(", sugarG=")
				.append(sugarG).append(", waterG=").append(waterG).append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((calciumMg == null) ? 0 : calciumMg.hashCode());
		result = prime * result + ((calories == null) ? 0 : calories.hashCode());
		result = prime * result + ((carbsG == null) ? 0 : carbsG.hashCode());
		result = prime * result + ((cholesterolMg == null) ? 0 : cholesterolMg.hashCode());
		result = prime * result + ((fatMonoG == null) ? 0 : fatMonoG.hashCode());
		result = prime * result + ((fatPolyG == null) ? 0 : fatPolyG.hashCode());
		result = prime * result + ((fatSatG == null) ? 0 : fatSatG.hashCode());
		result = prime * result + ((fiberG == null) ? 0 : fiberG.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((ironMg == null) ? 0 : ironMg.hashCode());
		result = prime * result + ((potassiumMg == null) ? 0 : potassiumMg.hashCode());
		result = prime * result + ((proteinG == null) ? 0 : proteinG.hashCode());
		result = prime * result + ((shortDesc == null) ? 0 : shortDesc.hashCode());
		result = prime * result + ((sodiumMg == null) ? 0 : sodiumMg.hashCode());
		result = prime * result + ((sugarG == null) ? 0 : sugarG.hashCode());
		result = prime * result + ((waterG == null) ? 0 : waterG.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Food other = (Food) obj;
		if (calciumMg == null) {
			if (other.calciumMg != null)
				return false;
		} else if (!calciumMg.equals(other.calciumMg))
			return false;
		if (calories == null) {
			if (other.calories != null)
				return false;
		} else if (!calories.equals(other.calories))
			return false;
		if (carbsG == null) {
			if (other.carbsG != null)
				return false;
		} else if (!carbsG.equals(other.carbsG))
			return false;
		if (cholesterolMg == null) {
			if (other.cholesterolMg != null)
				return false;
		} else if (!cholesterolMg.equals(other.cholesterolMg))
			return false;
		if (fatMonoG == null) {
			if (other.fatMonoG != null)
				return false;
		} else if (!fatMonoG.equals(other.fatMonoG))
			return false;
		if (fatPolyG == null) {
			if (other.fatPolyG != null)
				return false;
		} else if (!fatPolyG.equals(other.fatPolyG))
			return false;
		if (fatSatG == null) {
			if (other.fatSatG != null)
				return false;
		} else if (!fatSatG.equals(other.fatSatG))
			return false;
		if (fiberG == null) {
			if (other.fiberG != null)
				return false;
		} else if (!fiberG.equals(other.fiberG))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (ironMg == null) {
			if (other.ironMg != null)
				return false;
		} else if (!ironMg.equals(other.ironMg))
			return false;
		if (potassiumMg == null) {
			if (other.potassiumMg != null)
				return false;
		} else if (!potassiumMg.equals(other.potassiumMg))
			return false;
		if (proteinG == null) {
			if (other.proteinG != null)
				return false;
		} else if (!proteinG.equals(other.proteinG))
			return false;
		if (shortDesc == null) {
			if (other.shortDesc != null)
				return false;
		} else if (!shortDesc.equals(other.shortDesc))
			return false;
		if (sodiumMg == null) {
			if (other.sodiumMg != null)
				return false;
		} else if (!sodiumMg.equals(other.sodiumMg))
			return false;
		if (sugarG == null) {
			if (other.sugarG != null)
				return false;
		} else if (!sugarG.equals(other.sugarG))
			return false;
		if (waterG == null) {
			if (other.waterG != null)
				return false;
		} else if (!waterG.equals(other.waterG))
			return false;
		return true;
	}

}