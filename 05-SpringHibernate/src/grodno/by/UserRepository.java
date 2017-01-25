package grodno.by;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository <User, Integer> {
	
	List<User> findAll();
	
	@Query("select u from User u where id = ?1")
	User findUserByCustomId(Integer id);
}
