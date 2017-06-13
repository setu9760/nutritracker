package com.nutritracker.common.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Type;
import org.joda.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;


/**
 * The persistent class for the USRR database table.
 * 
 */
@Entity
public class Usrr implements Serializable, Persistable {
	private static final long serialVersionUID = 1L;

	@Id
	private String username;

	private String country;

	@DateTimeFormat(pattern = "dd/MM/yyy")
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
	private LocalDate dob;

	private String email;

	@Lob
	private byte[] image;

	private String timezone;

	//bi-directional many-to-one association to UserHealthDetail
	@OneToMany(mappedBy="usrr")
	private Set<UserHealthDetail> userHealthDetails;

	public Usrr() {
	}
	
	@Override
	public String getId() {
		return getUsername();
	}
	
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public LocalDate getDob() {
		return this.dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public byte[] getImage() {
		return this.image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public String getTimezone() {
		return this.timezone;
	}

	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}

	public Set<UserHealthDetail> getUserHealthDetails() {
		return this.userHealthDetails;
	}

	public void setUserHealthDetails(Set<UserHealthDetail> userHealthDetails) {
		this.userHealthDetails = userHealthDetails;
	}

	public UserHealthDetail addUserHealthDetail(UserHealthDetail userHealthDetail) {
		getUserHealthDetails().add(userHealthDetail);
		userHealthDetail.setUsrr(this);

		return userHealthDetail;
	}

	public UserHealthDetail removeUserHealthDetail(UserHealthDetail userHealthDetail) {
		getUserHealthDetails().remove(userHealthDetail);
		userHealthDetail.setUsrr(null);

		return userHealthDetail;
	}
}