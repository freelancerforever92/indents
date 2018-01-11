package com.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CRAFT_COUNTER_LIST")
public class CraftCounters {

	private int craftGroupPk;
	private String craftGroupType;
	private String description;
	private String storageLocation;
	
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getCraftGroupPk() {
		return craftGroupPk;
	}
	public void setCraftGroupPk(int craftGroupPk) {
		this.craftGroupPk = craftGroupPk;
	}
	
	@Column(name="CRAFT_GROUP")
	public String getCraftGroupType() {
		return craftGroupType;
	}
	public void setCraftGroupType(String craftGroupType) {
		this.craftGroupType = craftGroupType;
	}
	
	
	@Column(name="DESCRIPTION")
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
		return "CraftCounters [craftGroupPk=" + craftGroupPk
				+ ", craftGroupType=" + craftGroupType + ", description="
				+ description + ", storageLocation=" + storageLocation + "]";
	}
	
	
	
	
	
	
	
}
