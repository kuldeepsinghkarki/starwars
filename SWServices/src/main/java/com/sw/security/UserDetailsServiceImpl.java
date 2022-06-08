package com.sw.security;

import com.sw.exceptions.SWResourceNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * This service checks for user data existence based on internal logic
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    Logger logger = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
        SWUserDetails userDetails = new SWUserDetails();
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encoded = encoder.encode("password");
        userDetails.setUsername(username);
        if (username.equalsIgnoreCase("kuldeep")) {
            userDetails.setEnabled(true);
            userDetails.setPassword(encoded);
            authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
            userDetails.setAuthorities(authorities);
        } else if (username.startsWith("a")) {
            userDetails.setEnabled(true);
            userDetails.setPassword(encoded);
            userDetails.setUsername(username);
            authorities.add(new SimpleGrantedAuthority("ROLE_OPERATOR"));
            userDetails.setAuthorities(authorities);
        } else {
            logger.error("No matching record found");
            throw new SWResourceNotFoundException(username + "is not registered with us, try different username");
        }
        return userDetails;
    }
}
