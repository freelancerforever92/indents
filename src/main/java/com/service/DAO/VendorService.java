package com.service.DAO;

import javax.servlet.http.HttpSession;

import com.models.CraftCounters;
import com.models.MaterialMaster;
import com.models.MaterialVendorMaster;
import com.models.VendorMaster;

public interface VendorService {
	public int isVendorExits(VendorMaster vendorMaster,HttpSession httpSession);
	public int isVendorMaterialMatch(MaterialMaster material,VendorMaster vendor,MaterialVendorMaster materialVendor,CraftCounters crafts,HttpSession httpSession);
}
