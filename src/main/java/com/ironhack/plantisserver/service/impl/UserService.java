package com.ironhack.plantisserver.service.impl;

import com.ironhack.plantisserver.model.Plant;
import com.ironhack.plantisserver.model.User;
import com.ironhack.plantisserver.repository.RoleRepository;
import com.ironhack.plantisserver.repository.UserRepository;
import com.ironhack.plantisserver.service.interfaces.UserServiceInterface;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@Slf4j
public class UserService implements UserServiceInterface, UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private RoleService roleService;

    public User saveUser(User userSignupDTO) {
        log.info("Saving a new user {} inside of the database", userSignupDTO.getName());
        User user = new User(userSignupDTO.getName(), userSignupDTO.getEmail(), userSignupDTO.getPassword());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User returnUser = userRepository.save(user);
        roleService.addRoleToUser(returnUser.getEmail(), "ROLE_USER");
        return returnUser;
    }
    //optional if we have an admin
    public List<User> getUsers() {
        log.info("Fetching all users");
        return userRepository.findAll();
    }



    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            log.error("User not found in the database");
            throw new UsernameNotFoundException("User not found in the database");
        } else {
            log.info("User is found in the database: {}", email);
            Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();

                authorities.add(new SimpleGrantedAuthority(user.getRoles().getName()));

            return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), authorities);
        }
    }
}

