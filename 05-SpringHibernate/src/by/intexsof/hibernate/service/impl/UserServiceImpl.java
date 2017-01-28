package by.intexsof.hibernate.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.intexsof.hibernate.model.User;
import by.intexsof.hibernate.repository.UserRepository;
import by.intexsof.hibernate.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepository;

	@Override
	public User findUserById(int id) {
		return userRepository.findOne(id);
	}

	@Override
	public List<User> findAllUsers() {
		return userRepository.findAll();
	}

}
