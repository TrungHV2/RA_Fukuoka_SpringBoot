package com.ra.session5.service.impl;

import com.ra.session5.entity.UsersEntity;
import com.ra.session5.model.TokenRequest;
import com.ra.session5.model.UserDetailsAdapter;
import com.ra.session5.repository.UserRepository;
import com.ra.session5.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserService, UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UsersEntity usersEntity = userRepository.findByUsername(username);
        if (usersEntity != null) {
            UserDetails userDetails = new UserDetailsAdapter(usersEntity);
            return userDetails;
        }
        throw new UsernameNotFoundException("Username \"" + username + "\" not found!");
    }

    @Override
    public UsersEntity add(TokenRequest request) {
        UsersEntity usersEntity = new UsersEntity();
        usersEntity.setUsername(request.getUsername());
        usersEntity.setPassword(passwordEncoder.encode(request.getPassword()));
        usersEntity.setStatus(true);
        return userRepository.save(usersEntity);
    }
}
