package by.intexsoft.vasili.lodegro.security;

import by.intexsoft.vasili.lodegro.security.controller.UserController;
import by.intexsoft.vasili.lodegro.security.model.CustomUserDetails;
import by.intexsoft.vasili.lodegro.security.model.User;
import by.intexsoft.vasili.lodegro.security.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        LOGGER.info("Try to get from db user: " + username);
        User user = userRepository.findByUsername(username);
        LOGGER.info("Found user: " + username);
        UserDetails userDetails = new CustomUserDetails(user);
        return userDetails;
    }
}
