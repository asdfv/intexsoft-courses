package by.intexsoft.vasa.userapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import by.intexsoft.vasa.userapp.model.User;
import by.intexsoft.vasa.userapp.service.impl.UserServiceImpl;

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
	
	@RequestMapping("/get")
	User findUserById(@RequestParam int id){
		return userServiceImpl.findOne(id);
	}
}
