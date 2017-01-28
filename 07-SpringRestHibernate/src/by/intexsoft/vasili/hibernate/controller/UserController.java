package by.intexsoft.vasili.hibernate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import by.intexsoft.vasili.hibernate.model.User;
import by.intexsoft.vasili.hibernate.service.impl.UserServiceImpl;

/**
 * Controller for {@link User}
 */
@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserServiceImpl userServiceImpl;
	
	@RequestMapping("/all")
	List<User> getAllUsers(){
		return userServiceImpl.findAll();
	}
	
	@RequestMapping("/{id}")
	User findUserById(@PathVariable int id){
		return userServiceImpl.findOne(id);
	}
}
