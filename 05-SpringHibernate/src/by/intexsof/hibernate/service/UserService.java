package by.intexsof.hibernate.service;

import java.util.List;

import by.intexsof.hibernate.model.User;

public interface UserService {

	User findUserById(int id);
	List<User> findAllUsers();
	
}
