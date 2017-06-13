package com.nutritracker.common.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.joda.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;


/**
 * The persistent class for the USER_LOGIN_DETAILS database table.
 * 
 */
@Entity
@Table(name="USER_LOGIN_DETAILS")
public class UserLoginDetail implements Serializable, Persistable {
	private static final long serialVersionUID = 1L;

	@Id
	private String username;

	@Column(name="IS_LOCKED")
	private String isLocked;

	@Column(name="LAST_LOGIN")
	@DateTimeFormat(pattern = "dd/MM/yyy hh:mm:ss")
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
	private LocalDate lastLogin;

	private String password;

	@Column(name="SIGN_ON_STATUS")
	private String signOnStatus;

	//bi-directional one-to-one association to Usrr
	@OneToOne
	@JoinColumn(name="USERNAME")
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

	public String getIsLocked() {
		return this.isLocked;
	}

	public void setIsLocked(String isLocked) {
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

	public String getSignOnStatus() {
		return this.signOnStatus;
	}

	public void setSignOnStatus(String signOnStatus) {
		this.signOnStatus = signOnStatus;
	}

	public Usrr getUsrr() {
		return this.usrr;
	}

	public void setUsrr(Usrr usrr) {
		this.usrr = usrr;
	}

}