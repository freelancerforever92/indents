package com.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="MATERIAL_VENDOR_CRAFT")
public class MaterialVendorMaster {
private int materialVendorId;
private String materialId;
private String vendorId;
private String craftGroup;
private String storageLocation;


@Id
@Column(name="TBL_PK")

public int getMaterialVendorId() {
	return materialVendorId;
}
public void setMaterialVendorId(int materialVendorId) {
	this.materialVendorId = materialVendorId;
}

@Column(name="MATERIAL_NO")
public String getMaterialId() {
	return materialId;
}
public void setMaterialId(String materialId) {
	this.materialId = materialId;
}

@Column(name="VENDOR_ID")
public String getVendorId() {
	return vendorId;
}
public void setVendorId(String vendorId) {
	this.vendorId = vendorId;
}

@Column(name="CRAFTGROUP")
public String getCraftGroup() {
	return craftGroup;
}
public void setCraftGroup(String craftGroup) {
	this.craftGroup = craftGroup;
}


@Column(name="STORAGE_LOCATION")
public String getStorageLocation() {
	return storageLocation;
}
public void setStorageLocation(String storageLocation) {
	this.storageLocation = storageLocation;
}
/* (non-Javadoc)
 * @see java.lang.Object#toString()
 */
@Override
public String toString() {
	return "MaterialVendorMaster [materialVendorId=" + materialVendorId
			+ ", materialId=" + materialId + ", vendorId=" + vendorId
			+ ", craftGroup=" + craftGroup + ", storageLocation="
			+ storageLocation + "]";
}






}
