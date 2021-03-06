package com.nutritracker.common.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * The persistent class for the FOOD database table.
 * 
 */
@NamedQueries(value = { @NamedQuery(name="findFoodByDesc", query="select f from FOOD f where f.shortDesc = :desc"), 
		@NamedQuery(name="findFoodLikeDesc", query="select f from FOOD f where lower(f.shortDesc) like :desc"),
		@NamedQuery(name = "findFoodWithCaloriesLessThan", query = "select f from FOOD f where f.calories <= :calories"),
		@NamedQuery(name = "findFoodWithSugarLessThan", query = "select f from FOOD f where f.sugarG <= :sugar") })
@Entity(name = "FOOD")
public class Food extends NutriStats {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "FOOD_ID_GENERATOR", sequenceName = "FOOD_ID_GENERATOR", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "FOOD_ID_GENERATOR")
	private Long id;

	@Column(name = "SHORT_DESC")
	@NotNull(message = "{invalid.description}")
	@Size(max = 255, min = 3)
	private String shortDesc;

	Food() {
		super();
	}

	public Food(String shortDesc, BigDecimal waterG, BigDecimal calories, BigDecimal proteinG, BigDecimal sugarG, BigDecimal carbsG, BigDecimal fiberG, BigDecimal fatSatG,
			BigDecimal fatMonoG, BigDecimal fatPolyG, BigDecimal cholesterolMg, BigDecimal sodiumMg, BigDecimal potassiumMg, BigDecimal calciumMg, BigDecimal ironMg) {
		super(waterG, calories, proteinG, sugarG, carbsG, fiberG, fatSatG, fatMonoG, fatPolyG, cholesterolMg, sodiumMg, potassiumMg, calciumMg, ironMg);
		this.shortDesc = shortDesc;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getShortDesc() {
		return shortDesc;
	}

	public void setShortDesc(String shortDesc) {
		this.shortDesc = shortDesc;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((shortDesc == null) ? 0 : shortDesc.hashCode());
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
		Food other = (Food) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (shortDesc == null) {
			if (other.shortDesc != null)
				return false;
		} else if (!shortDesc.equals(other.shortDesc))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Food [id=").append(id).append(", shortDesc=").append(shortDesc).append(", ").append(super.toString()).append("]");
		return builder.toString();
	}

}