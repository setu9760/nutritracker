package com.nutritracker.common.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import com.nutritracker.common.annotation.StandardDecimal;

@MappedSuperclass
public class NutriStats implements Serializable, Persistable {

	private static final long serialVersionUID = -7268301450573705617L;
	private static final BigDecimal ZERO = new BigDecimal(0);

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

	NutriStats() {
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

	public NutriStats(BigDecimal waterG, BigDecimal calories, BigDecimal proteinG, BigDecimal sugarG, BigDecimal carbsG, BigDecimal fiberG, BigDecimal fatSatG,
			BigDecimal fatMonoG, BigDecimal fatPolyG, BigDecimal cholesterolMg, BigDecimal sodiumMg, BigDecimal potassiumMg, BigDecimal calciumMg, BigDecimal ironMg) {
		super();
		this.waterG = waterG;
		this.calories = calories;
		this.proteinG = proteinG;
		this.sugarG = sugarG;
		this.carbsG = carbsG;
		this.fiberG = fiberG;
		this.fatSatG = fatSatG;
		this.fatMonoG = fatMonoG;
		this.fatPolyG = fatPolyG;
		this.cholesterolMg = cholesterolMg;
		this.sodiumMg = sodiumMg;
		this.potassiumMg = potassiumMg;
		this.calciumMg = calciumMg;
		this.ironMg = ironMg;
	}

	@Override
	public Serializable getId() {
		return null;
	}

	public BigDecimal getWaterG() {
		return waterG;
	}

	public void setWaterG(BigDecimal waterG) {
		this.waterG = waterG;
	}

	public BigDecimal getCalories() {
		return calories;
	}

	public void setCalories(BigDecimal calories) {
		this.calories = calories;
	}

	public BigDecimal getProteinG() {
		return proteinG;
	}

	public void setProteinG(BigDecimal proteinG) {
		this.proteinG = proteinG;
	}

	public BigDecimal getSugarG() {
		return sugarG;
	}

	public void setSugarG(BigDecimal sugarG) {
		this.sugarG = sugarG;
	}

	public BigDecimal getCarbsG() {
		return carbsG;
	}

	public void setCarbsG(BigDecimal carbsG) {
		this.carbsG = carbsG;
	}

	public BigDecimal getFiberG() {
		return fiberG;
	}

	public void setFiberG(BigDecimal fiberG) {
		this.fiberG = fiberG;
	}

	public BigDecimal getFatSatG() {
		return fatSatG;
	}

	public void setFatSatG(BigDecimal fatSatG) {
		this.fatSatG = fatSatG;
	}

	public BigDecimal getFatMonoG() {
		return fatMonoG;
	}

	public void setFatMonoG(BigDecimal fatMonoG) {
		this.fatMonoG = fatMonoG;
	}

	public BigDecimal getFatPolyG() {
		return fatPolyG;
	}

	public void setFatPolyG(BigDecimal fatPolyG) {
		this.fatPolyG = fatPolyG;
	}

	public BigDecimal getCholesterolMg() {
		return cholesterolMg;
	}

	public void setCholesterolMg(BigDecimal cholesterolMg) {
		this.cholesterolMg = cholesterolMg;
	}

	public BigDecimal getSodiumMg() {
		return sodiumMg;
	}

	public void setSodiumMg(BigDecimal sodiumMg) {
		this.sodiumMg = sodiumMg;
	}

	public BigDecimal getPotassiumMg() {
		return potassiumMg;
	}

	public void setPotassiumMg(BigDecimal potassiumMg) {
		this.potassiumMg = potassiumMg;
	}

	public BigDecimal getCalciumMg() {
		return calciumMg;
	}

	public void setCalciumMg(BigDecimal calciumMg) {
		this.calciumMg = calciumMg;
	}

	public BigDecimal getIronMg() {
		return ironMg;
	}

	public void setIronMg(BigDecimal ironMg) {
		this.ironMg = ironMg;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("NutriStats [waterG=").append(waterG).append(", calories=").append(calories).append(", proteinG=").append(proteinG)
				.append(", sugarG=").append(sugarG).append(", carbsG=").append(carbsG).append(", fiberG=").append(fiberG).append(", fatSatG=").append(fatSatG)
				.append(", fatMonoG=").append(fatMonoG).append(", fatPolyG=").append(fatPolyG).append(", cholesterolMg=").append(cholesterolMg).append(", sodiumMg=")
				.append(sodiumMg).append(", potassiumMg=").append(potassiumMg).append(", calciumMg=").append(calciumMg).append(", ironMg=").append(ironMg).append("]");
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
		result = prime * result + ((ironMg == null) ? 0 : ironMg.hashCode());
		result = prime * result + ((potassiumMg == null) ? 0 : potassiumMg.hashCode());
		result = prime * result + ((proteinG == null) ? 0 : proteinG.hashCode());
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
		NutriStats other = (NutriStats) obj;
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
