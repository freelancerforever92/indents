package com.service.DAO;

import com.models.UserSecurityDetails;

public interface UserBaseService {

	public int authenticateBaseUser(UserSecurityDetails user);
	
}
