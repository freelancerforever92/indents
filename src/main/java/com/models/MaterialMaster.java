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
@Table(name="MATERIAL_MASTER_TAXGROUP")
public class MaterialMaster {

	private String materialId;
	private String materialDescription;
	private String craftGroup;
	private String plantId;
	private String storageLocation;
	private String distributionChannel;
	private Float standardPrice;
	private Float sellingPrice;
	private Date createdOn;
	private Date updatedOn;
	
	
	@Id
	@Column(name="MATERIAL_NO")
	public String getMaterialId() {
		return materialId;
	}
	public void setMaterialId(String materialId) {
		this.materialId = materialId;
	}
	
	@Column(name="MATERIAL_DESC")
	public String getMaterialDescription() {
		return materialDescription;
	}
		public void setMaterialDescription(String materialDescription) {
		this.materialDescription = materialDescription;
	}
	
	@Column(name="CRAFT_GROUP")
	public String getCraftGroup() {
		return craftGroup;
	}
	public void setCraftGroup(String craftGroup) {
		this.craftGroup = craftGroup;
	}
	
	@Column(name="PLANT")
	public String getPlantId() {
		return plantId;
	}
	public void setPlantId(String plantId) {
		this.plantId = plantId;
	}
	
	@Column(name="STORAGELOCATION")
	public String getStorageLocation() {
		return storageLocation;
	}
	public void setStorageLocation(String storageLocation) {
		this.storageLocation = storageLocation;
	}
	
	@Column(name="DISTRIBUTIONCHANNEL")
	public String getDistributionChannel() {
		return distributionChannel;
	}
	public void setDistributionChannel(String distributionChannel) {
		this.distributionChannel = distributionChannel;
	}
	
	@Column(name="PRICE")
	public Float getStandardPrice() {
		return standardPrice;
	}
	public void setStandardPrice(Float standardPrice) {
		this.standardPrice = standardPrice;
	}
	
	@Column(name="STANDARDPRICE")
	public Float getSellingPrice() {
		return sellingPrice;
	}
	public void setSellingPrice(Float sellingPrice) {
		this.sellingPrice = sellingPrice;
	}
	
	@Column(name="CREATEDDATETIME")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	
	@Column(name="LASTUPDATEDDATETIME")
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
		return "MaterialMaster [materialId=" + materialId
				+ ", materialDescription=" + materialDescription
				+ ", craftGroup=" + craftGroup + ", plantId=" + plantId
				+ ", storageLocation=" + storageLocation
				+ ", distributionChannel=" + distributionChannel
				+ ", standardPrice=" + standardPrice + ", sellingPrice="
				+ sellingPrice + ", createdOn=" + createdOn + ", updatedOn="
				+ updatedOn + "]";
	}
	
}
