package com.persist.DAOImpl;

import java.util.List;
import java.util.ResourceBundle;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.models.EmployeeMaster;
import com.persist.DAO.EmployeeMasterDAO;

@Repository("EmployeeMasterDAO")
public class EmployeeMasterDAOImpl implements EmployeeMasterDAO {
	
	static final Logger LOGGER = Logger.getLogger(EmployeeMasterDAOImpl.class);
	
	static ResourceBundle DEFAULT_VALUES_BUNDLE = ResourceBundle.getBundle("default-values");
	
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public List<EmployeeMaster> getEmployeeData(int empID) {
		Session theSession = sessionFactory.getCurrentSession();
		Criteria criteria = theSession.createCriteria(EmployeeMaster.class);
		criteria.add(Restrictions.eq("empId", empID));
		criteria.add(Restrictions.eq("empStatus",Integer.parseInt(DEFAULT_VALUES_BUNDLE.getString("employee.status").toString().trim())));
		List<EmployeeMaster> employeeData = criteria.list();
		return employeeData;
	}
	
}
