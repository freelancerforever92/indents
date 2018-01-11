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
@Table(name="USER_MASTER")
public class UserSecurityDetails {

	private int userPk;
	private String plantId;
	private String uUserName;
	private String uPassword;
	private int employeeId;
	private int securityQuestionId;
	private String securityAnswer;
	private Date lastUpdatedDate;
	
	
	/**
	 * @return the userPk
	 */
	@Id
	@Column(name="USER_PK")
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getUserPk() {
		return userPk;
	}
	public void setUserPk(int userPk) {
		this.userPk = userPk;
	}
	
	/**
	 * @return the plantId
	 */
	@Column(name="PLANT")
	public String getPlantId() {
		return plantId;
	}
	public void setPlantId(String plantId) {
		this.plantId = plantId;
	}
	
	/**
	 * @return the uUserName
	 */
	@Column(name="USERNAME")
	public String getuUserName() {
		return uUserName;
	}
	public void setuUserName(String uUserName) {
		this.uUserName = uUserName;
	}
	
	/**
	 * @return the uPassword
	 */
	@Column(name="PWD")
	public String getuPassword() {
		return uPassword;
	}
	public void setuPassword(String uPassword) {
		this.uPassword = uPassword;
	}
	
	/**
	 * @return the employeeId
	 */
	@Column(name="EMP_FK")
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	
	/**
	 * @return the securityQuestionId
	 */
	@Column(name="SECURITYQUESTION_FK")
	public int getSecurityQuestionId() {
		return securityQuestionId;
	}
	public void setSecurityQuestionId(int securityQuestionId) {
		this.securityQuestionId = securityQuestionId;
	}
	
	/**
	 * @return the securityAnswer
	 */
	@Column(name="SECURITY_ANSWER")
	public String getSecurityAnswer() {
		return securityAnswer;
	}
	public void setSecurityAnswer(String securityAnswer) {
		this.securityAnswer = securityAnswer;
	}
	
	/**
	 * @return the lastUpdatedDate
	 */
	@Column(name="LASTUPDATED")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getLastUpdatedDate() {
		return lastUpdatedDate;
	}
	public void setLastUpdatedDate(Date lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UserBaseDetails [userPk=" + userPk + ", plantId=" + plantId
				+ ", uUserName=" + uUserName + ", uPassword=" + uPassword
				+ ", employeeId=" + employeeId + ", securityQuestionId="
				+ securityQuestionId + ", securityAnswer=" + securityAnswer
				+ ", lastUpdatedDate=" + lastUpdatedDate + "]";
	}
	
	
	
	
}
