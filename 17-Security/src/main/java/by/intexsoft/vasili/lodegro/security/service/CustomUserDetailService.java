package by.intexsoft.vasili.lodegro.security.service;

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

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomUserDetailService.class);

    final
    UserRepository userRepository;

    @Autowired
    public CustomUserDetailService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        LOGGER.info("Try to get from db user: " + username);
        try {
            User user = userRepository.findByUsername(username);
            UserDetails userDetails = new CustomUserDetails(user);
            LOGGER.info("UserDetails auth-s: " + userDetails.getAuthorities());
            return userDetails;
        } catch (Exception e) {
            LOGGER.info("getting user error. StackTrace: \n");
            e.printStackTrace();
        }
        return null;
    }
}
