package com.service.DAOImpl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.beans.MaterialInfoBean;
import com.models.CraftCounters;
import com.models.MaterialMaster;
import com.models.VendorMaster;
import com.persist.DAO.MaterialDAO;
import com.service.DAO.MaterialService;

@Service("MaterialService")
public class MaterialServiceImpl implements MaterialService {
	
	@Autowired
	MaterialDAO materialDAO;
	
	@Transactional
	public int isMaterialIdExits(String materialNumber,CraftCounters craftCounters,HttpSession httpSession) {
		return materialDAO.isMaterialIdExits(materialNumber,craftCounters,httpSession);
	}
	
	@Transactional
	public List<MaterialInfoBean> getMaterialInfo(MaterialMaster material,VendorMaster vendor,Float mQty,HttpSession httpSession){
		return materialDAO.getMaterialInfo(material, vendor,mQty,httpSession);
	}

	@Transactional
	public int deleteItmFrmCrt(MaterialMaster material,VendorMaster vendor, String cID, HttpSession httpSession) {
		return materialDAO.deleteItmFrmCrt(material, vendor, cID, httpSession);
	}
	
	@Transactional
	public List<MaterialInfoBean> getItmsFrmCrt(HttpSession httpSession){
		return materialDAO.getItmsFrmCrt(httpSession);
	}
	

}
