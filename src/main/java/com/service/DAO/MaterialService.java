package com.service.DAO;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.beans.MaterialInfoBean;
import com.models.CraftCounters;
import com.models.MaterialMaster;
import com.models.VendorMaster;

public interface MaterialService {
	
	public int isMaterialIdExits(String materialNumber,CraftCounters craftCounters,HttpSession httpSession);
	public List<MaterialInfoBean> getMaterialInfo(MaterialMaster material,VendorMaster vendor, Float mQty,HttpSession httpSession);
	public int deleteItmFrmCrt(MaterialMaster material,VendorMaster vendor,String cID,HttpSession httpSession);
	public List<MaterialInfoBean> getItmsFrmCrt(HttpSession httpSession);
}
