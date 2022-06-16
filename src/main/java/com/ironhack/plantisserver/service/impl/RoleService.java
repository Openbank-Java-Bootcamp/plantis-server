package com.ironhack.plantisserver.service.impl;

import com.ironhack.plantisserver.model.Role;
import com.ironhack.plantisserver.model.User;
import com.ironhack.plantisserver.repository.RoleRepository;
import com.ironhack.plantisserver.repository.UserRepository;
import com.ironhack.plantisserver.service.interfaces.RoleServiceInterface;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RoleService implements RoleServiceInterface {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;


    public Role saveRole(Role role) {
        log.info("Saving a new role {} to the database", role.getName());
        return roleRepository.save(role);
    }

    public void addRoleToUser(String email, String roleName) {
        User user = userRepository.findByEmail(email);
        Role role = roleRepository.findByName(roleName);
        user.setRoles(role);
        userRepository.save(user);
    }
}
