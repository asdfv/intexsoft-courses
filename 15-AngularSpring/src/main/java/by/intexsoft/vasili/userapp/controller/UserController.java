package by.intexsoft.vasili.userapp.controller;

import by.intexsoft.vasili.userapp.model.User;
import by.intexsoft.vasili.userapp.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller for {@link User}
 */
@RestController
@RequestMapping("/user")
public class UserController {

	public final static Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@RequestMapping("/all")
	private ResponseEntity<Iterable<User>> searchAllUsers() {
		LOGGER.info("Mapping user/all works");
		Iterable<User> list = userService.findAll();
		return new ResponseEntity<Iterable<User>>(list, HttpStatus.OK);
	}

	@RequestMapping(value = "/get", params = "id")
	private ResponseEntity<User> searchUser(@RequestParam("id") int id) {
		LOGGER.info("Mapping user?id working");
		User user = userService.findOne(id);
		if (user == null) {
			LOGGER.info("Not found User with id = " + id);
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<User>(user, HttpStatus.OK);
    }
}
