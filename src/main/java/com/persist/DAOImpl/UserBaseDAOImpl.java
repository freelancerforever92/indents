package com.persist.DAOImpl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.models.UserSecurityDetails;
import com.persist.DAO.UserBaseDAO;

@Repository("UserBaseDAO")
public class UserBaseDAOImpl implements UserBaseDAO {

	static final Logger LOGGER = Logger.getLogger(UserBaseDAOImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Transactional
	public int authenticateBaseUser(UserSecurityDetails user) {
		// TODO Auto-generated method stub
		Session theSession = sessionFactory.getCurrentSession();
		Criteria criteria = theSession.createCriteria(UserSecurityDetails.class);
		criteria.add(Restrictions.eq("uUserName", user.getuUserName().trim()));
		criteria.add(Restrictions.eq("uPassword", user.getuPassword().trim()));
		List<UserSecurityDetails> users = criteria.list();
		return users.size();
	}

}
