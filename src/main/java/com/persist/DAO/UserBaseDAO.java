package com.persist.DAO;

import com.models.UserSecurityDetails;

public interface UserBaseDAO {
	public int authenticateBaseUser(UserSecurityDetails user);
}
