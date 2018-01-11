package com.service.DAO;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.models.EmployeeMaster;

public interface EmployeeMasterService {

	public List<EmployeeMaster> getEmployeeData(int empID);
}
