package by.intexsoft.vasili.lodegro.security.service;

import by.intexsoft.vasili.lodegro.security.model.User;

/**
 * Service for {@link by.intexsoft.vasili.lodegro.security.repository.UserRepository}
 */
public interface UserService {
    User loadUser(String username);
}
