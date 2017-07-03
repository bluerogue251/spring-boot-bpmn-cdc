package com.teddywidom.service;

import com.teddywidom.repo.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {
    private Logger logger = LoggerFactory.getLogger(UserDetailsService.class);

    @Autowired
    public UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.teddywidom.model.User loadedUser = userRepository.findOneByUsername(username);
        if (loadedUser == null) throw new UsernameNotFoundException("Username not found");
        User userDetails = new User(loadedUser.getUsername(), loadedUser.getEncryptedPassword(), new ArrayList<GrantedAuthority>());
        return userDetails;
    }
}
