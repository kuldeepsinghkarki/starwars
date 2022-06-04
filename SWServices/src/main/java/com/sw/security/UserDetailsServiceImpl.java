package com.sw.security;

import com.sw.exceptions.SWResourceNotFoundException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
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
            throw new SWResourceNotFoundException(username + "is not registered with us, try different username");
        }
        return userDetails;
    }
}
