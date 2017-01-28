package by.intexsoft.vasili.hibernate.service;

import java.util.List;

import by.intexsoft.vasili.hibernate.model.User;
import by.intexsoft.vasili.hibernate.repository.UserRepository;

/**
 * Service for {@link UserRepository}
 */
public interface UserService {
	
	User findOne(int id);
	List<User> findAll();
	
}
