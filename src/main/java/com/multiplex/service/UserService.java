package com.multiplex.service;

import com.multiplex.entity.User;

public interface UserService {

	User fetchUserByEmailId(String tempEmailId);

	User saveUser(User user);

	User fetchUserByEmailIdAndPassword(String tempEmailId, String tempPass);

	public User getUserByEmail(String email);

}
