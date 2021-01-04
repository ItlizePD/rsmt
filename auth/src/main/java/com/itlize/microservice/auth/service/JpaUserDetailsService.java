package com.itlize.microservice.auth.service;


import com.itlize.microservice.auth.entity.User;
import com.itlize.microservice.auth.model.CustomUserDetails;
import com.itlize.microservice.auth.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.function.Supplier;

@Service
public class JpaUserDetailsService implements UserDetailsService {

    private static final Logger logger = LoggerFactory.getLogger(JpaUserDetailsService.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public CustomUserDetails loadUserByUsername(String username) {
        
        Supplier<UsernameNotFoundException> s =
                () -> new UsernameNotFoundException("Problem during authentication!");

        logger.info("Search the user by name");
        User u = userRepository.findUserByUsername(username).orElseThrow(s);

        /* in memory test */
        // User u = new User();
        // u.setUsername("root");
        // u.setPassword(passwordEncoder.encode("root"));
        // Profile p = new Profile();
        // p.setType("Admin");
        // u.setProfiles(Arrays.asList(p));

        // String cur = DateUtil.getDate();
		// u.setCreationTime(cur);
		// u.setUpdateTime(cur);

        return new CustomUserDetails(u);
    }
}