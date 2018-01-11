package com.persist.DAOImpl;

import javax.servlet.http.HttpSession;




import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import com.models.CraftCounters;
import com.models.MaterialMaster;
import com.models.MaterialVendorMaster;
import com.models.VendorMaster;
import com.persist.DAO.VendorDAO;

@Repository("VendorDAO")
public class VendorDAOImpl implements VendorDAO{
static final Logger LOGGER = Logger.getLogger(VendorDAOImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	private static List<String> craftGroupList = new ArrayList();

	@Transactional
	public int isVendorExits(VendorMaster vendorMaster, HttpSession httpSession) {
		Session theSession = sessionFactory.getCurrentSession();
		Criteria criteria = theSession.createCriteria(VendorMaster.class);
		criteria.add(Restrictions.eq("vendorID", vendorMaster.getVendorID().trim()));
		List<VendorMaster> vendors = criteria.list();
		return vendors.size();
	}

	@Transactional
	public int isVendorMaterialMatch(MaterialMaster material,VendorMaster vendor, MaterialVendorMaster materialVendor,CraftCounters crafts, HttpSession httpSession) {
		List<MaterialVendorMaster> materialVendors = null;
		Session theSession = sessionFactory.getCurrentSession();
		Criteria criteria = theSession.createCriteria(CraftCounters.class);
		criteria.add(Restrictions.eq("storageLocation", httpSession.getAttribute("storageLocation").toString().trim()));
		List<CraftCounters> craftGroups = criteria.list();
		craftGroupList.clear();
		for(CraftCounters craftGrp : craftGroups){
			craftGroupList.add(craftGrp.getCraftGroupType().trim());
		}
		for(String craft : craftGroupList){
			Criteria criteria2 = theSession.createCriteria(MaterialVendorMaster.class);
			criteria2.add(Restrictions.eq("materialId", material.getMaterialId().trim()));
			criteria2.add(Restrictions.eq("vendorId", vendor.getVendorID().trim()));
			criteria2.add(Restrictions.eq("craftGroup", craft));
			materialVendors = criteria2.list();
			System.out.println("materialVendors : "+materialVendors);
		}
		return materialVendors.size();
	}

}
