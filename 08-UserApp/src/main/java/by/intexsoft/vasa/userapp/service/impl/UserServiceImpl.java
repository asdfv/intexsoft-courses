package by.intexsoft.vasa.userapp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.intexsoft.vasa.userapp.model.User;
import by.intexsoft.vasa.userapp.repository.UserRepository;
import by.intexsoft.vasa.userapp.service.UserService;


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
	public List<User> findAll() {
		return userRepository.findAll();
	}
}
