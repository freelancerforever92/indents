package com.persist.DAO;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.models.EmployeeMaster;

public interface EmployeeMasterDAO {
	public List<EmployeeMaster> getEmployeeData(int empID);
}
