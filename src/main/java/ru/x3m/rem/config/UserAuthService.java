package ru.x3m.rem.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.x3m.rem.repository.UserRepo;

import java.util.Collections;

@Service
@Transactional
public class UserAuthService implements UserDetailsService {

    private static final Logger logger = LoggerFactory.getLogger(UserAuthService.class);

    private final UserRepo userRepo;

    @Autowired
    public UserAuthService(UserRepo userRepo){
        this.userRepo=userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.info("SpringSecurity loading user by name");

        return userRepo.getUserByUsername(username)
                .map(user -> new org.springframework.security.core.userdetails.User(
                        user.getUsername(),
                        user.getPassword(),
                        Collections.singletonList(new SimpleGrantedAuthority("USER"))
                ))
                .orElseThrow(()->new UsernameNotFoundException("USER NOT FOUND"));
    }
}
