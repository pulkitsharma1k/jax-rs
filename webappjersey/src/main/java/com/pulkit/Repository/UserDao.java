package com.pulkit.Repository;

import java.util.List;

import com.pulkit.model.UserDetail;

public interface UserDao {

	
	public List<UserDetail> getuser();
	public UserDetail saveuser(UserDetail user);
}
