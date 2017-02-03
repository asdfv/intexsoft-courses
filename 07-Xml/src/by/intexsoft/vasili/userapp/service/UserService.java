package by.intexsoft.vasili.userapp.service;

import java.util.List;

import by.intexsoft.vasili.userapp.model.User;
import by.intexsoft.vasili.userapp.repository.UserRepository;

/**
 * Service for {@link UserRepository}
 */
public interface UserService {
	
	User findOne(int id);
	List<User> findAll();
	
}
