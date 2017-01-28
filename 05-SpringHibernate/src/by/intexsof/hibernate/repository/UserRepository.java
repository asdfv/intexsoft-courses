package by.intexsof.hibernate.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import by.intexsof.hibernate.model.User;

@Repository
public interface UserRepository extends CrudRepository <User, Integer> {
	
	List<User> findAll();
	
	@Query("select u from User u where id = :number")
	User findUserByCustomId(@Param("number") int number );
	
}
