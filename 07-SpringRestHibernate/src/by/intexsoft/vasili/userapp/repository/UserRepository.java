package by.intexsoft.vasili.userapp.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import by.intexsoft.vasili.userapp.model.User;

/**
 * Repository for {@link User}
 */
@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
	
	/**
	 * All {@link User}
	 */	
	List<User> findAll();
	/**
	 * {@link User} by id
	 */	
	User findById(int id);
}
