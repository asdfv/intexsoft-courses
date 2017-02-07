package by.intexsoft.vasili.userapp.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import by.intexsoft.vasili.userapp.model.User;
import by.intexsoft.vasili.userapp.service.UserService;

/**
 * Controller for {@link User}
 */
@RestController
@RequestMapping("/user")
public class UserController {

	public final static Logger LOGGER = Logger.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@RequestMapping("/all")
	private Iterable<User> getAllUsers() {
		LOGGER.info("Mapping user/all working");
		return userService.findAll();
	}

	@RequestMapping(value = "/get", params = "id")
	private User findUserById(@RequestParam("id") int id) {
		LOGGER.info("Mapping user/{id} working");
		User user = userService.findOne(id);
		LOGGER.info(user.toString());
		return user;
	}
}
