package by.intexsoft.vasili.repository;

import org.springframework.data.repository.CrudRepository;

import by.intexsoft.vasili.model.User;

/**
 * Repository for {@link User}
 */
public interface UserRepository extends CrudRepository <User, Integer> {
	
}
