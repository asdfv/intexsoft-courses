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
	
	List<User> findAll();
	User findById(int id);
}
