package by.intexsoft.vasili.userapp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.intexsoft.vasili.userapp.model.User;
import by.intexsoft.vasili.userapp.repository.UserRepository;
import by.intexsoft.vasili.userapp.service.UserService;


/**
 * Implementation for {@link UserService}
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public User findOne(int id) {
		return userRepository.findOne(id);
	}

	@Override
	public Iterable<User> findAll() {
		return userRepository.findAll();
	}
}
