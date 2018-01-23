package com.service.DAO;

import java.util.List;
import javax.servlet.http.HttpSession;
import com.models.CraftCounters;
import com.models.MaterialMaster;
import com.models.MaterialVendorMaster;
import com.models.VendorMaster;

public interface VendorService {
	public List<VendorMaster> getVendors();
	public int isVendorExits(VendorMaster vendorMaster,HttpSession httpSession);
	public int isVendorMaterialMatch(MaterialMaster material,VendorMaster vendor,MaterialVendorMaster materialVendor,CraftCounters crafts,HttpSession httpSession);
}
