package by.intexsoft.vasa.userapp.service;

import java.util.List;

import by.intexsoft.vasa.userapp.model.User;
import by.intexsoft.vasa.userapp.repository.UserRepository;

/**
 * Service for {@link UserRepository}
 */
public interface UserService {
	
	User findOne(int id);
	List<User> findAll();
	
}
