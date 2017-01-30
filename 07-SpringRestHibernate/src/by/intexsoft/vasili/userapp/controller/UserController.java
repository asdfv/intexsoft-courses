package by.intexsoft.vasili.userapp.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import by.intexsoft.vasili.userapp.model.User;
import by.intexsoft.vasili.userapp.service.impl.UserServiceImpl;

/**
 * Controller for {@link User}
 */
@RestController
@RequestMapping("/user")
public class UserController {
	
	public final static Logger logger = Logger.getLogger(UserController.class); 
	
	@Autowired
	private UserServiceImpl userServiceImpl;
	
	@RequestMapping("/all")
	List<User> getAllUsers(){
		logger.info("Mapping user/all working");
		return userServiceImpl.findAll();
	}
	
	@RequestMapping("/{id}")
	User findUserById(@PathVariable int id){
		logger.info("Mapping user/{id} working");
		logger.info(userServiceImpl.findOne(id).toString());
		return userServiceImpl.findOne(id);
	}
}
