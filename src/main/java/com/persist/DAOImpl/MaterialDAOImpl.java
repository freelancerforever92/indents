package com.persist.DAOImpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.beans.MaterialInfoBean;
import com.beans.MaterialInfoBeanLineItem;
import com.models.CraftCounters;
import com.models.MaterialMaster;
import com.models.VendorMaster;
import com.persist.DAO.MaterialDAO;

@Repository("MaterialDAO")
public class MaterialDAOImpl implements MaterialDAO {
	Float grandTotal = 0.f;
	static final Logger LOGGER = Logger.getLogger(MaterialDAOImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	private static List<String> craftGroupList = new ArrayList<String>();
	private Map<Integer,ArrayList<MaterialInfoBean>> itemToCart = new ConcurrentHashMap<Integer, ArrayList<MaterialInfoBean>>();

	@Transactional
	public int isMaterialIdExits(String materialNumber,CraftCounters craftCounters,HttpSession httpSession) {
		int returnCode = 0;
		String materialCraftGroup = null;
		Session theSession = sessionFactory.getCurrentSession();
		Criteria criteria = theSession.createCriteria(MaterialMaster.class);
		criteria.add(Restrictions.eq("materialId", materialNumber));
		List<MaterialMaster> materials = criteria.list();
		if(materials.size() > 0){
			for(MaterialMaster craftGrp : materials){
				materialCraftGroup = craftGrp.getCraftGroup().trim();
			}
			Criteria criteria2 = theSession.createCriteria(CraftCounters.class);
			criteria2.add(Restrictions.eq("storageLocation", httpSession.getAttribute("storageLocation").toString().trim()));
			List<CraftCounters> craftGroups = criteria2.list();
			craftGroupList.clear();
			for(CraftCounters craftGrps : craftGroups){
				craftGroupList.add(craftGrps.getCraftGroupType().trim());
			}
			if(craftGroupList.contains(materialCraftGroup.toString().trim())){
				returnCode = 1;
			}else{
				returnCode = -3;
			}
		}else if(materials.size() <= 0){
			returnCode = 0;
		}
		return returnCode;
	}
	
	
	ArrayList<MaterialInfoBean> headerItems = new ArrayList<MaterialInfoBean>();
	ArrayList<MaterialInfoBeanLineItem> lineItems = new ArrayList<MaterialInfoBeanLineItem>();
	@Transactional
	public synchronized List<MaterialInfoBean> getMaterialInfo(MaterialMaster material,VendorMaster vendor,Float mQty,HttpSession httpSession){
		
		Session theSession = sessionFactory.getCurrentSession();
		List<Object>materialInfoObj = new ArrayList<Object>();
		int loggedEmpID = Integer.parseInt(httpSession.getAttribute("loggedEmpId").toString().trim());
		String materialInfoQry = "SELECT material_master_taxgroup.material_no,\n"
                + "       material_master_taxgroup.material_desc,\n"
                + "       material_master_taxgroup.craft_group,\n"
                + "       vendor_master.vendor_id,\n"
                + "       vendor_master.vendor_name,\n"
                + "       IFNULL(material_master_taxgroup.price,0),\n"
                + "       IFNULL(material_master_taxgroup.standardPrice,0),\n"
                + "       IFNULL(craft_tax_price.output_tax,0),\n"
                + "       IFNULL(craft_tax_price.output_gst_tax,0),\n"
                + "       craft_tax_price.hsn_code\n"
                + "       FROM pos.vendor_master vendor_master\n"
                + "       CROSS JOIN pos.material_master_taxgroup material_master_taxgroup\n"
                + "       INNER JOIN pos.craft_tax_price craft_tax_price\n"
                + "       ON (material_master_taxgroup.craft_group =\n"
                + "       craft_tax_price.craft_group)\n"
                + "       WHERE (material_master_taxgroup.material_no ='" + material.getMaterialId().trim() + "')\n"
                + "       AND (vendor_master.vendor_id = '" + vendor.getVendorID().trim() + "')";
		materialInfoObj = theSession.createSQLQuery(materialInfoQry).list();
		Iterator<?> iterator = materialInfoObj.iterator();
		headerItems.clear();
		lineItems.clear();
		if(itemToCart != null){
			while(iterator.hasNext()) {
				Object[] objectValue = (Object[]) iterator.next();
				MaterialInfoBean materialInfo = new MaterialInfoBean();
				MaterialInfoBeanLineItem lineItem = new MaterialInfoBeanLineItem();
				materialInfo.setMaterialID(String.valueOf(objectValue[0]).trim());
				materialInfo.setMaterialDescription(String.valueOf(objectValue[1]).trim());
				materialInfo.setMaterialCraftGroup(String.valueOf(objectValue[2]).trim());
				materialInfo.setVendorID(String.valueOf(objectValue[3]).trim());
				materialInfo.setVendorName(String.valueOf(objectValue[4]).trim());
				materialInfo.setMaterialSellingPrice(Float.parseFloat(String.valueOf(objectValue[5]).trim()));
				materialInfo.setQuantity(mQty);
				Float gross = Float.parseFloat(String.valueOf(objectValue[5]).trim()) * mQty;
				materialInfo.setGrossAmount(gross);
				grandTotal += gross;
				System.out.println("TOT "+grandTotal);
				//materialInfo.setTotalAmount(grandTotal);
				lineItem.setTotalAmount(grandTotal);
				lineItems.add(lineItem);
				materialInfo.setBeanList(lineItems);
				materialInfo.setMaterialStandardPrice(Float.parseFloat(String.valueOf(objectValue[6]).trim()));
				materialInfo.setMaterialOutputTaxPer(Float.parseFloat(String.valueOf(objectValue[7]).trim()));
				materialInfo.setMaterialCraftGSTPer(Float.parseFloat(String.valueOf(objectValue[8]).trim()));
				materialInfo.setHsnCode(String.valueOf(objectValue[9]).trim());
				materialInfo.setKeyCode(GetUUIDToken().trim());
				headerItems.add(materialInfo);
			}
			itemToCart.put(loggedEmpID, (ArrayList<MaterialInfoBean>) headerItems);
		}
		return headerItems;
	}
	
	@Transactional
	public int deleteItmFrmCrt(MaterialMaster material,VendorMaster vendor, String cID, HttpSession httpSession) {
		int deleteStatus = 0;
		int loggedEmpID = Integer.parseInt(httpSession.getAttribute("loggedEmpId").toString().trim());
		if(itemToCart != null){
			Iterator<Map.Entry<Integer,ArrayList<MaterialInfoBean>>> iter = itemToCart.entrySet().iterator();
			while (iter.hasNext()) {
	        	Map.Entry<Integer,ArrayList<MaterialInfoBean>> entry = iter.next();
	        	if(loggedEmpID == entry.getKey()){
	        		ArrayList<MaterialInfoBean> list = entry.getValue();
			        for(int i = 0 ; i < list.size() ; i++){
			           if(list.get(i).getKeyCode().equals(cID) ){
			            	list.remove(i);
			            	deleteStatus = 1;
						    itemToCart.put(entry.getKey(), list);
			             }
			        }
	        	}
			}
		}
		return deleteStatus;
	}
	
	ArrayList<MaterialInfoBean> itemsFromMap = new ArrayList<MaterialInfoBean>();
	@Transactional
	public List<MaterialInfoBean> getItmsFrmCrt(HttpSession httpSession){
		Float grandTotal = 0.f;
		ArrayList<MaterialInfoBean> intentLstItms = new ArrayList<MaterialInfoBean>();
		int loggedEmpID = Integer.parseInt(httpSession.getAttribute("loggedEmpId").toString().trim());
		if(itemToCart != null){
			intentLstItms.clear();
			itemsFromMap.clear();
			Iterator<Map.Entry<Integer,ArrayList<MaterialInfoBean>>> iter = itemToCart.entrySet().iterator();
			while (iter.hasNext()) {
	        	Map.Entry<Integer,ArrayList<MaterialInfoBean>> entry = iter.next();
	        	MaterialInfoBean mBean = new MaterialInfoBean();
	        	if(loggedEmpID == entry.getKey()){
	        		intentLstItms = entry.getValue();
	        		System.out.println("LIST ITMS :: "+intentLstItms);
	        		for(MaterialInfoBean bean : intentLstItms){
	        			System.out.println(bean.getGrossAmount());
	        			grandTotal += bean.getGrossAmount();
	        			System.out.println("Grand Total :: "+grandTotal);
	        		}
	        		intentLstItms.add(mBean);
	        		itemsFromMap.addAll(intentLstItms);
	        	}
			}
			System.out.println("ITEM AFTER REMOVE :: "+itemsFromMap);
		}
		return itemsFromMap;
	}
	
	public String GetUUIDToken() {
        return UUID.randomUUID().toString();
    }

}
