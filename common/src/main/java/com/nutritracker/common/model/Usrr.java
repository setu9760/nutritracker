package com.nutritracker.common.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

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
	@NotNull
	private String username;

	@NotNull
	private String country;

	@DateTimeFormat(pattern = "dd/MM/yyy")
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
	private LocalDate dob;

	@NotNull
	private String email;

	@NotNull
	private String timezone;

	@Lob
	private byte[] image;

	// bi-directional many-to-one association to UserHealthDetail
	@OneToMany(mappedBy = "usrr")
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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Usrr [username=").append(username).append(", country=").append(country).append(", dob=")
				.append(dob).append(", email=").append(email).append(", timezone=").append(timezone).append(", image=")
				.append(Arrays.toString(image)).append(", userHealthDetails=").append(userHealthDetails).append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((dob == null) ? 0 : dob.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + Arrays.hashCode(image);
		result = prime * result + ((timezone == null) ? 0 : timezone.hashCode());
		result = prime * result + ((userHealthDetails == null) ? 0 : userHealthDetails.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
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
		Usrr other = (Usrr) obj;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (dob == null) {
			if (other.dob != null)
				return false;
		} else if (!dob.equals(other.dob))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (!Arrays.equals(image, other.image))
			return false;
		if (timezone == null) {
			if (other.timezone != null)
				return false;
		} else if (!timezone.equals(other.timezone))
			return false;
		if (userHealthDetails == null) {
			if (other.userHealthDetails != null)
				return false;
		} else if (!userHealthDetails.equals(other.userHealthDetails))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
}