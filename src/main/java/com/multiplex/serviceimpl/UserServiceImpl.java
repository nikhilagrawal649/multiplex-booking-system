package com.multiplex.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multiplex.dao.UsersRepository;
import com.multiplex.entity.User;
import com.multiplex.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UsersRepository repo;

	public User saveUser(User user) {
		return repo.save(user);
	}

	public User fetchUserByEmailId(String email) {
		return repo.findByEmailId(email);
	}

	public User fetchUserByEmailIdAndPassword(String emailId, String password) {
		return repo.findByEmailIdAndPassword(emailId, password);
	}

	@Override
	public User getUserByEmail(String email) {
		User user = repo.findByEmailId(email);
		if(user!=null) {
		return user;
	}
		else {
			return  null;
		}
	}
}
