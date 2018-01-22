package com.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.beans.MaterialInfoBean;
import com.models.CraftCounters;
import com.models.EmployeeMaster;
import com.models.MaterialMaster;
import com.models.MaterialVendorMaster;
import com.models.UserSecurityDetails;
import com.models.VendorMaster;
import com.service.DAO.BranchCounterService;
import com.service.DAO.EmployeeMasterService;
import com.service.DAO.MaterialService;
import com.service.DAO.UserBaseService;
import com.service.DAO.VendorService;

@Controller
@Scope("session")
public class AppController {

	String loadingPage = "";

	private static final Logger logger = LoggerFactory.getLogger(AppController.class);

	/* The Constant RESOURCE BUNDLE */
	//static ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle("applicationProps");
	HttpSession httpSession = null;
	
	@Autowired
	UserBaseService userBaseService;
	
	@Autowired
	BranchCounterService branchCounters;
	
	@Autowired
	EmployeeMasterService employeeMasterService;
	
	@Autowired
	MaterialService materialService;
	
	@Autowired
	VendorService vendorService;

	@RequestMapping(value = "/")
	public ModelAndView controllerRedirec(Model model) {
		System.out.println("-WELCOME TO CONTROLLER- ");
		loadingPage = "indexLogin";
		return new ModelAndView(loadingPage);
	}

	@RequestMapping(value = "/doLogin")
	public ModelAndView authenticateUser(HttpServletRequest request,HttpServletResponse httpServletResponse,Model model,UserSecurityDetails userDetails,EmployeeMaster employeeMaster) {
		
		int isValidUser = userBaseService.authenticateBaseUser(userDetails);
		
		if (isValidUser >= 1) {
			
			List<EmployeeMaster> employee = employeeMasterService.getEmployeeData(Integer.parseInt(userDetails.getuUserName().trim()));
			
			if(employee.size() > 0){
				httpSession = request.getSession();
				for(EmployeeMaster emp : employee){
					httpSession.setAttribute("loggedUserNo", emp.getEmpPk());
					httpSession.setAttribute("loggedEmpId",emp.getEmpId());
					httpSession.setAttribute("loggedEmpFirstNameLastName",emp.getEmpFullName().trim());
					httpSession.setAttribute("loggedUserRole",emp.getEmpRole().trim());
					httpSession.setAttribute("loggedUserStatus", emp.getEmpStatus());
					httpSession.setAttribute("cancelFlagStatus",emp.getCancellingStatus().trim());
				}
				model.addAttribute("counters", branchCounters.getCounters());
				model.addAttribute("loggedUser", httpSession.getAttribute("loggedEmpFirstNameLastName").toString().trim());
				loadingPage = "homePage";
			}else{
				loadingPage = "invalidUserPage";
			}	
		} else if (isValidUser <= 0) {
				loadingPage = "invalidUserPage";
		}
		return new ModelAndView(loadingPage);
	}
	
	@RequestMapping(value="/addCounterToSession")
	public @ResponseBody int getProductCategoryName(@RequestParam String legacyNo){
		int isInSession = 0;
		String getStorageLocation = branchCounters.addCounterToSession(legacyNo);
		if(!(getStorageLocation.isEmpty())){
			httpSession.setAttribute("storageLocation",getStorageLocation);
			String storageLoc = httpSession.getAttribute("storageLocation").toString().trim();
			if(!(storageLoc.isEmpty())){
				isInSession = 1;
			}else{
				isInSession = 0;
			}
		}
		return isInSession;
	}
	
	@RequestMapping(value="/createIndent")
	public ModelAndView showCreateIndent(Model model){
		model.addAttribute("counters", branchCounters.getCounters());
		model.addAttribute("loggedUser", httpSession.getAttribute("loggedEmpFirstNameLastName").toString().trim());
		loadingPage = "homePage";
		return new ModelAndView(loadingPage);
	}
	
	@RequestMapping(value="/materialValidate")
	public @ResponseBody int getMaterialValidateCode(MaterialMaster materialMaster,CraftCounters craftCounters,HttpSession httpSession){
		int isMaterialValid = 0;
		String materialNumber = materialMaster.getMaterialId();
		if(!materialNumber.trim().isEmpty()){
			if(materialNumber.trim().length() == 13){
				isMaterialValid = materialService.isMaterialIdExits(materialNumber,craftCounters,httpSession);
			}else{
				isMaterialValid = -2;
			}
		}else{
			isMaterialValid = -1;
		}
		return isMaterialValid;
	}
	
	@RequestMapping(value="/vendorValidate")
	public @ResponseBody int vendorValidation(MaterialMaster materialMaster,VendorMaster vendorMaster,MaterialVendorMaster materialVendor,CraftCounters craftCounters,HttpSession httpSession){
		int isVendorValid = 0;
		int isVendorMaterialMatch = 0;
		String vendorId = vendorMaster.getVendorID().trim();
		if(!vendorId.trim().isEmpty()){
			isVendorValid = vendorService.isVendorExits(vendorMaster, httpSession);
			
			if(isVendorValid >=1 ){
				isVendorMaterialMatch = vendorService.isVendorMaterialMatch(materialMaster, vendorMaster, materialVendor, craftCounters, httpSession);
				if(isVendorMaterialMatch >= 1){
					isVendorValid = 1;	// Material-Vendor matched
				}else if(isVendorMaterialMatch <= 0){
					isVendorValid = -2;	// Material-Vendor not matched
				}
			}else if(isVendorValid <= 0){
				isVendorValid = 0;	    // Vendor number is not valid
			}
		}else{
			isVendorValid = -1;		    // Vendor field is empty
		}
		return isVendorValid;
	}
	
	List<MaterialInfoBean> materialLst = null;
	@RequestMapping(value="/getProductDetail")
	public @ResponseBody List<MaterialInfoBean> getMaterialInfo(MaterialMaster material,VendorMaster vendor,@RequestParam Float mQty,HttpSession httpSession){
		materialLst = new ArrayList<MaterialInfoBean>();
		materialLst = materialService.getMaterialInfo(material, vendor,mQty,httpSession);
		return materialLst;
	}
	
	@RequestMapping(value="/removeItemFromCart")
	public @ResponseBody int removeItemFromCrt(MaterialMaster material,VendorMaster vendor,@RequestParam String cID,HttpSession httpSession){
		return materialService.deleteItmFrmCrt(material, vendor,cID,httpSession);
	}
	
	List<MaterialInfoBean> itmsFrmCrt = null;
	@RequestMapping(value="/getItemsFromCart")
	public @ResponseBody List<MaterialInfoBean> getItmsFrmCrt(HttpSession httpSession){
		itmsFrmCrt = new ArrayList<MaterialInfoBean>();
		itmsFrmCrt = materialService.getItmsFrmCrt(httpSession);
		return itmsFrmCrt;
	}

}
