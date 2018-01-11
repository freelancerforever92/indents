package com.service.DAOImpl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.models.EmployeeMaster;
import com.persist.DAO.EmployeeMasterDAO;
import com.service.DAO.EmployeeMasterService;

@Service("EmployeeMasterService")
public class EmployeeMasterServiceImpl implements EmployeeMasterService{
	
	@Autowired
	EmployeeMasterDAO employeeMasterDAO;

	@Transactional
	public List<EmployeeMaster> getEmployeeData(int empID) {
		return employeeMasterDAO.getEmployeeData(empID);
	}

}
