package by.intexsoft.vasili.lodegro.security.repository;

import by.intexsoft.vasili.lodegro.security.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUsername(String username);
}