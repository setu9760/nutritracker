package com.nutritracker.common.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;
import org.joda.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;

import com.nutritracker.common.model.enums.SignOnStatus;
import com.nutritracker.common.utils.BooleanToStringConverter;

/**
 * The persistent class for the USER_LOGIN_DETAILS database table.
 * 
 */
@Entity
@Table(name = "USER_LOGIN_DETAILS")
public class UserLoginDetail implements Serializable, Persistable {
	private static final long serialVersionUID = 1L;

	
	@Id
	@Column(name = "USERNAME")
	@NotNull
	private String username;

	@Column(name = "IS_LOCKED")
	@Convert(converter=BooleanToStringConverter.class)
	private Boolean isLocked = false;

	@Column(name = "LAST_LOGIN")
	@DateTimeFormat(pattern = "dd/MM/yyy hh:mm:ss")
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
	private LocalDate lastLogin;

	private String password;

	@Enumerated(EnumType.STRING)
	@Column(name = "SIGN_ON_STATUS")
	private SignOnStatus signOnStatus;

	// bi-directional one-to-one association to Usrr
	@OneToOne
	@JoinColumn(name = "USERNAME")
	private Usrr usrr;

	public UserLoginDetail() {
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

	public Boolean getIsLocked() {
		return this.isLocked;
	}

	public void setIsLocked(Boolean isLocked) {
		this.isLocked = isLocked;
	}

	public LocalDate getLastLogin() {
		return this.lastLogin;
	}

	public void setLastLogin(LocalDate lastLogin) {
		this.lastLogin = lastLogin;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public SignOnStatus getSignOnStatus() {
		return this.signOnStatus;
	}

	public void setSignOnStatus(SignOnStatus signOnStatus) {
		this.signOnStatus = signOnStatus;
	}

	public Usrr getUsrr() {
		return this.usrr;
	}

	public void setUsrr(Usrr usrr) {
		this.usrr = usrr;
		this.username = usrr.getUsername();
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UserLoginDetail [username=").append(username).append(", isLocked=").append(isLocked)
				.append(", lastLogin=").append(lastLogin).append(", password=").append("[ENCRYPTED]")
				.append(", signOnStatus=").append(signOnStatus).append(", usrr=").append(usrr).append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((isLocked == null) ? 0 : isLocked.hashCode());
		result = prime * result + ((signOnStatus == null) ? 0 : signOnStatus.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
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
		UserLoginDetail other = (UserLoginDetail) obj;
		if (isLocked == null) {
			if (other.isLocked != null)
				return false;
		} else if (!isLocked.equals(other.isLocked))
			return false;
		if (signOnStatus == null) {
			if (other.signOnStatus != null)
				return false;
		} else if (!signOnStatus.equals(other.signOnStatus))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		if (usrr == null) {
			if (other.usrr != null)
				return false;
		} else if (!usrr.equals(other.usrr))
			return false;
		return true;
	}

}