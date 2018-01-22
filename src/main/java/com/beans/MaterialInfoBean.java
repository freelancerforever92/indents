package com.beans;

import java.util.List;

public class MaterialInfoBean {

	private String keyCode = null;
    private String materialID = null;
    private String materialDescription = null;
    private String materialCraftGroup = null;
    private String vendorID = null;
    private String vendorName = null;
    private Float quantity = 0.f;
    private Float materialStandardPrice = 0.f;
    private Float materialSellingPrice = 0.f;
    private Float materialOutputTaxPer = 0.f;
    private Float materialCraftGSTPer = 0.f;
    private Float grossAmount = 0.f;
    private String hsnCode = null;
    private List<MaterialInfoBeanLineItem> beanList;
    
    
	public String getKeyCode() {
		return keyCode;
	}
	public void setKeyCode(String keyCode) {
		this.keyCode = keyCode;
	}
	public String getMaterialID() {
		return materialID;
	}
	public void setMaterialID(String materialID) {
		this.materialID = materialID;
	}
	public String getMaterialDescription() {
		return materialDescription;
	}
	public void setMaterialDescription(String materialDescription) {
		this.materialDescription = materialDescription;
	}
	public String getMaterialCraftGroup() {
		return materialCraftGroup;
	}
	public void setMaterialCraftGroup(String materialCraftGroup) {
		this.materialCraftGroup = materialCraftGroup;
	}
	public String getVendorID() {
		return vendorID;
	}
	public void setVendorID(String vendorID) {
		this.vendorID = vendorID;
	}
	public String getVendorName() {
		return vendorName;
	}
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}
	public Float getQuantity() {
		return quantity;
	}
	public void setQuantity(Float quantity) {
		this.quantity = quantity;
	}
	public Float getMaterialStandardPrice() {
		return materialStandardPrice;
	}
	public void setMaterialStandardPrice(Float materialStandardPrice) {
		this.materialStandardPrice = materialStandardPrice;
	}
	public Float getMaterialSellingPrice() {
		return materialSellingPrice;
	}
	public void setMaterialSellingPrice(Float materialSellingPrice) {
		this.materialSellingPrice = materialSellingPrice;
	}
	public Float getMaterialOutputTaxPer() {
		return materialOutputTaxPer;
	}
	public void setMaterialOutputTaxPer(Float materialOutputTaxPer) {
		this.materialOutputTaxPer = materialOutputTaxPer;
	}
	public Float getMaterialCraftGSTPer() {
		return materialCraftGSTPer;
	}
	public void setMaterialCraftGSTPer(Float materialCraftGSTPer) {
		this.materialCraftGSTPer = materialCraftGSTPer;
	}
	public Float getGrossAmount() {
		return grossAmount;
	}
	public void setGrossAmount(Float grossAmount) {
		this.grossAmount = grossAmount;
	}
	public String getHsnCode() {
		return hsnCode;
	}
	public void setHsnCode(String hsnCode) {
		this.hsnCode = hsnCode;
	}
	public List<MaterialInfoBeanLineItem> getBeanList() {
		return beanList;
	}
	public void setBeanList(List<MaterialInfoBeanLineItem> beanList) {
		this.beanList = beanList;
	}
	@Override
	public String toString() {
		return "MaterialInfoBean [keyCode=" + keyCode + ", materialID="
				+ materialID + ", materialDescription=" + materialDescription
				+ ", materialCraftGroup=" + materialCraftGroup + ", vendorID="
				+ vendorID + ", vendorName=" + vendorName + ", quantity="
				+ quantity + ", materialStandardPrice=" + materialStandardPrice
				+ ", materialSellingPrice=" + materialSellingPrice
				+ ", materialOutputTaxPer=" + materialOutputTaxPer
				+ ", materialCraftGSTPer=" + materialCraftGSTPer
				+ ", grossAmount=" + grossAmount + ", hsnCode=" + hsnCode
				+ ", beanList=" + beanList + "]";
	}
	
	
    
}
