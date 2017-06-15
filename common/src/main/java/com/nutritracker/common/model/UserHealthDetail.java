package com.nutritracker.common.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.joda.time.LocalDateTime;
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
	@SequenceGenerator(name = "HEALTH_DETAILS_ID_GENERATOR", sequenceName = "HEALTH_DETAILS_ID_GENERATOR", allocationSize = 1)
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
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime")
	private LocalDateTime recordTime = LocalDateTime.now();

	// bi-directional many-to-one association to Usrr
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USERNAME")
	private Usrr usrr;

	UserHealthDetail() {
	}

	public UserHealthDetail(BigDecimal bodyFat, BigDecimal bodyweightKg) {
		this(bodyFat, bodyweightKg, LocalDateTime.now(), null);
	}
	
	public UserHealthDetail(BigDecimal bodyFat, BigDecimal bodyweightKg, Usrr usrr) {
		this(bodyFat, bodyweightKg, LocalDateTime.now(), usrr);
	}

	public UserHealthDetail(BigDecimal bodyFat, BigDecimal bodyweightKg, LocalDateTime recordTime, Usrr usrr) {
		super();
		this.bodyFat = bodyFat;
		this.bodyweightKg = bodyweightKg;
		this.recordTime = recordTime;
		this.usrr = usrr;
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

	public BigDecimal getBodyweightKg() {
		return this.bodyweightKg;
	}

	public LocalDateTime getRecordTime() {
		return this.recordTime;
	}

	public void setRecordTime(LocalDateTime recordTime) {
		this.recordTime = recordTime;
	}

	public Usrr getUsrr() {
		return this.usrr;
	}
	
	void setUsrr(Usrr usrr) {
		this.usrr = usrr;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UserHealthDetail [id=").append(id).append(", bodyFat=").append(bodyFat).append(", bodyweightKg=").append(bodyweightKg).append(", recordTime=")
				.append(recordTime).append(", usrr=").append(usrr.getUsername()).append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bodyFat == null) ? 0 : bodyFat.hashCode());
		result = prime * result + ((bodyweightKg == null) ? 0 : bodyweightKg.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((recordTime == null) ? 0 : recordTime.hashCode());
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
		UserHealthDetail other = (UserHealthDetail) obj;
		if (bodyFat == null) {
			if (other.bodyFat != null)
				return false;
		} else if (!bodyFat.equals(other.bodyFat))
			return false;
		if (bodyweightKg == null) {
			if (other.bodyweightKg != null)
				return false;
		} else if (!bodyweightKg.equals(other.bodyweightKg))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (recordTime == null) {
			if (other.recordTime != null)
				return false;
		} else if (!recordTime.equals(other.recordTime))
			return false;
		if (usrr == null) {
			if (other.usrr != null)
				return false;
		} else if (!usrr.equals(other.usrr))
			return false;
		return true;
	}

}