package com.service.DAOImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.models.UserSecurityDetails;
import com.persist.DAO.UserBaseDAO;
import com.service.DAO.UserBaseService;

@Service("UserBaseService")
public class UserBaseServiceImpl implements UserBaseService{
	
	@Autowired
	UserBaseDAO userBaseDAO;
	
	@Transactional
	public int authenticateBaseUser(UserSecurityDetails user) {
		return userBaseDAO.authenticateBaseUser(user);
	}

}
