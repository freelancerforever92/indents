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
@Table(name="EMP_MASTER")
public class EmployeeMaster {

	private int empPk;
	private int empId;
	private String empFullName;
	private String empRole;
	private int empStatus;
	private String empEmailAddress;
	private String cancellingStatus;
	private Date createdOn;
	private Date updatedOn;
	
	
	
	@Id
	@Column(name="EMP_PK")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getEmpPk() {
		return empPk;
	}
	public void setEmpPk(int empPk) {
		this.empPk = empPk;
	}
	
	@Column(name="EMP_ID")
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	
	@Column(name="EMP_NAME")
	public String getEmpFullName() {
		return empFullName;
	}
	public void setEmpFullName(String empFullName) {
		this.empFullName = empFullName;
	}
	
	@Column(name="EMP_TYPE")
	public String getEmpRole() {
		return empRole;
	}
	public void setEmpRole(String empRole) {
		this.empRole = empRole;
	}
	
	@Column(name="EMP_STATUS")
	public int getEmpStatus() {
		return empStatus;
	}
	public void setEmpStatus(int empStatus) {
		this.empStatus = empStatus;
	}
	
	@Column(name="EMP_EMAIL")
	public String getEmpEmailAddress() {
		return empEmailAddress;
	}
	public void setEmpEmailAddress(String empEmailAddress) {
		this.empEmailAddress = empEmailAddress;
	}
	
	@Column(name="CANCELLING_FLAG")
	public String getCancellingStatus() {
		return cancellingStatus;
	}
	public void setCancellingStatus(String cancellingStatus) {
		this.cancellingStatus = cancellingStatus;
	}

	
	@Column(name="EMP_CREATEDDATE")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getCreatedOn() {
		return createdOn;
	}
		public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	
	@Column(name="EMP_UPDATEDDATE")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getUpdatedOn() {
		return updatedOn;
	}
	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "EmployeeMaster [empPk=" + empPk + ", empId=" + empId
				+ ", empFullName=" + empFullName + ", empRole=" + empRole
				+ ", empStatus=" + empStatus + ", empEmailAddress="
				+ empEmailAddress + ", cancellingStatus=" + cancellingStatus
				+ ", createdOn=" + createdOn + ", updatedOn=" + updatedOn + "]";
	}
	
}
