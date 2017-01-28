package by.intexsoft.vasili.hibernate.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.intexsoft.vasili.hibernate.model.User;
import by.intexsoft.vasili.hibernate.repository.UserRepository;
import by.intexsoft.vasili.hibernate.service.UserService;


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
