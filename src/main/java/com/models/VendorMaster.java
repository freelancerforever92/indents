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
@Table(name="VENDOR_MASTER")
public class VendorMaster {

	private int vendorPk;
	private String vendorID;
	private int accountGroup;
	private String title;
	private String vendorName1;
	private String vendorName2;
	private String vendorName3;
	private String vendorName4;
	private String searchTerm;
	private String address1;
	private String address2;
	private String address3;
	private String address4;
	private String city;
	private String zipcode;
	private String district;
	private String state;
	private String telNumber;
	private String mobileNumber;
	private String faxNumber;
	private String emailAddress;
	private Float creditLimit; // indentCreditLimit
	private Date createdOn;
	private Date updatedOn;
	
	@Id
	@Column(name="VNDR_PK")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getVendorPk() {
		return vendorPk;
	}
	public void setVendorPk(int vendorPk) {
		this.vendorPk = vendorPk;
	}
	
	@Column(name="VENDOR_ID")
	public String getVendorID() {
		return vendorID;
	}
	public void setVendorID(String vendorID) {
		this.vendorID = vendorID;
	}
	
	@Column(name="ACCOUNT_GROUP")
	public int getAccountGroup() {
		return accountGroup;
	}
	public void setAccountGroup(int accountGroup) {
		this.accountGroup = accountGroup;
	}
	
	@Column(name="TITLE")
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	@Column(name="VENDOR_NAME")
	public String getVendorName1() {
		return vendorName1;
	}
	public void setVendorName1(String vendorName1) {
		this.vendorName1 = vendorName1;
	}
	@Column(name="VENDOR_NAME2")
	public String getVendorName2() {
		return vendorName2;
	}
	public void setVendorName2(String vendorName2) {
		this.vendorName2 = vendorName2;
	}
	
	@Column(name="VENDOR_NAME3")
	public String getVendorName3() {
		return vendorName3;
	}
	public void setVendorName3(String vendorName3) {
		this.vendorName3 = vendorName3;
	}
	@Column(name="VENDOR_NAME4")
	public String getVendorName4() {
		return vendorName4;
	}
	public void setVendorName4(String vendorName4) {
		this.vendorName4 = vendorName4;
	}
	@Column(name="SEARCH_TERM")
	public String getSearchTerm() {
		return searchTerm;
	}
	public void setSearchTerm(String searchTerm) {
		this.searchTerm = searchTerm;
	}
	@Column(name="ADDRESS1")
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	
	@Column(name="ADDRESS2")
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	
	@Column(name="ADDRESS3")
	public String getAddress3() {
		return address3;
	}
	public void setAddress3(String address3) {
		this.address3 = address3;
	}
	
	@Column(name="ADDRESS4")
	public String getAddress4() {
		return address4;
	}
	public void setAddress4(String address4) {
		this.address4 = address4;
	}
	
	@Column(name="CITY")
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Column(name="PINCODE")
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	
	@Column(name="DISTRICT")
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	@Column(name="STATE")
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	@Column(name="TEL_NO")
	public String getTelNumber() {
		return telNumber;
	}
	public void setTelNumber(String telNumber) {
		this.telNumber = telNumber;
	}
	@Column(name="MOBILE_NO")
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	@Column(name="FAX_NO")
	public String getFaxNumber() {
		return faxNumber;
	}
	public void setFaxNumber(String faxNumber) {
		this.faxNumber = faxNumber;
	}
	@Column(name="EMAIL_ID")
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
	@Column(name="INDENTCREDITLIMIT")
	public Float getCreditLimit() {
		return creditLimit;
	}
	public void setCreditLimit(Float creditLimit) {
		this.creditLimit = creditLimit;
	}
	
	@Column(name="CREATED_DATE_TIME")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	
	@Column(name="UPDATED_DATE_TIME")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getUpdatedOn() {
		return updatedOn;
	}
	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}
	@Override
	public String toString() {
		return "VendorMaster [vendorPk=" + vendorPk + ", vendorID=" + vendorID
				+ ", accountGroup=" + accountGroup + ", title=" + title
				+ ", vendorName1=" + vendorName1 + ", vendorName2="
				+ vendorName2 + ", vendorName3=" + vendorName3
				+ ", vendorName4=" + vendorName4 + ", searchTerm=" + searchTerm
				+ ", address1=" + address1 + ", address2=" + address2
				+ ", address3=" + address3 + ", address4=" + address4
				+ ", city=" + city + ", zipcode=" + zipcode + ", district="
				+ district + ", state=" + state + ", telNumber=" + telNumber
				+ ", mobileNumber=" + mobileNumber + ", faxNumber=" + faxNumber
				+ ", emailAddress=" + emailAddress + ", creditLimit="
				+ creditLimit + ", createdOn=" + createdOn + ", updatedOn="
				+ updatedOn + "]";
	}
		
}
