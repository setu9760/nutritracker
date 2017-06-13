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
 * The persistent class for the "RECORD" database table.
 * 
 */
@Entity
@Table(name = "RECORD")
public class Record implements Serializable, Persistable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "RECORD_ID_GENERATOR")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RECORD_ID_GENERATOR")
	private Long id;

	@Column(name = "F_ID")
	private Long fId;

	@Column(name = "SERVING_SIZE")
	@StandardDecimal
	private BigDecimal servingSize;

	@Column(name = "SERVING_UNIT")
	private String servingUnit;

	@Column(name = "TIME")
	@DateTimeFormat(pattern = "dd/MM/yyy hh:mm:ss")
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
	private LocalDate time;

	// bi-directional many-to-one association to Usrr
	@ManyToOne
	@JoinColumn(name = "USERNAME")
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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Record [id=").append(id).append(", fId=").append(fId).append(", servingSize=")
				.append(servingSize).append(", servingUnit=").append(servingUnit).append(", time=").append(time)
				.append(", usrr=").append(usrr).append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fId == null) ? 0 : fId.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((servingSize == null) ? 0 : servingSize.hashCode());
		result = prime * result + ((servingUnit == null) ? 0 : servingUnit.hashCode());
		result = prime * result + ((time == null) ? 0 : time.hashCode());
		result = prime * result + ((usrr == null) ? 0 : usrr.hashCode());
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
		Record other = (Record) obj;
		if (fId == null) {
			if (other.fId != null)
				return false;
		} else if (!fId.equals(other.fId))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (servingSize == null) {
			if (other.servingSize != null)
				return false;
		} else if (!servingSize.equals(other.servingSize))
			return false;
		if (servingUnit == null) {
			if (other.servingUnit != null)
				return false;
		} else if (!servingUnit.equals(other.servingUnit))
			return false;
		if (time == null) {
			if (other.time != null)
				return false;
		} else if (!time.equals(other.time))
			return false;
		if (usrr == null) {
			if (other.usrr != null)
				return false;
		} else if (!usrr.equals(other.usrr))
			return false;
		return true;
	}

}