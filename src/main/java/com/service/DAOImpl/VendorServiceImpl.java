package com.service.DAOImpl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.models.CraftCounters;
import com.models.MaterialMaster;
import com.models.MaterialVendorMaster;
import com.models.VendorMaster;
import com.persist.DAO.VendorDAO;
import com.service.DAO.VendorService;

@Service("VendorService")
public class VendorServiceImpl implements VendorService {
	
	@Autowired
	VendorDAO vendorDAO;

	@Transactional
	public List<VendorMaster> getVendors(){
		return vendorDAO.getVendors();
	}
	
	@Transactional
	public int isVendorExits(VendorMaster vendorMaster, HttpSession httpSession) {
		return vendorDAO.isVendorExits(vendorMaster, httpSession);
	}

	@Transactional
	public int isVendorMaterialMatch(MaterialMaster material,VendorMaster vendor, MaterialVendorMaster materialVendor,CraftCounters crafts, HttpSession httpSession){
		return vendorDAO.isVendorMaterialMatch(material, vendor, materialVendor, crafts, httpSession);
	}

}
