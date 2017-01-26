package rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@RestController
@RequestMapping(
		value = "/user",
		produces = "applicaiton/json")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping("/all")
	List<User> getAllUsers(){
		System.out.println("Mapping user-all has working");
		return userRepository.findAll();
	}
	
	@RequestMapping("/{id}")
	User findUserById(@PathVariable int id){
		System.out.println("Mapping user-id has working, id = " + id);
		return userRepository.findById(id);
	}
}
