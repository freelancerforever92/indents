package com.models;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="BRANCH_COUNTER")
public class Counters {

	private int counterId;
	private String counterCaption;
	private String counterNumber;
	private String counterLegacy;
	private int counterLoginUser;
	private String branchCode;
	private int activeCounterFlag;
	private Date createdOn;
	private Date updatedOn;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="COUNTER_PK")
	public int getCounterId() {
		return counterId;
	}
	public void setCounterId(int counterId) {
		this.counterId = counterId;
	}
	
	@Column(name="COUNTER")
	public String getCounterCaption() {
		return counterCaption;
	}
	public void setCounterCaption(String counterCaption) {
		this.counterCaption = counterCaption;
	}
	
	
	@Column(name="COUNTER_NO")
	public String getCounterNumber() {
		return counterNumber;
	}
	public void setCounterNumber(String counterNumber) {
		this.counterNumber = counterNumber;
	}
	
	@Column(name="COUNTER_NO_LEGACY")
	public String getCounterLegacy() {
		return counterLegacy;
	}
	public void setCounterLegacy(String counterLegacy) {
		this.counterLegacy = counterLegacy;
	}
	
	@Column(name="LOGIN_USERID")
	public int getCounterLoginUser() {
		return counterLoginUser;
	}
	public void setCounterLoginUser(int counterLoginUser) {
		this.counterLoginUser = counterLoginUser;
	}
	
	@Column(name="BRANCH_CODE")
	public String getBranchCode() {
		return branchCode;
	}
	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}
	
	@Column(name="COUNTER_STATUS")
	public int getActiveCounterFlag() {
		return activeCounterFlag;
	}
	public void setActiveCounterFlag(int activeCounterFlag) {
		this.activeCounterFlag = activeCounterFlag;
	}
	
	@Column(name="CREATEDDATETIME")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	
	@Column(name="lastUpdatedDateTime")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getUpdatedOn() {
		return updatedOn;
	}
	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}
	
}
