package ru.x3m.rem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.x3m.rem.dto.UserDTO;
import ru.x3m.rem.entity.Role;
import ru.x3m.rem.entity.User;
import ru.x3m.rem.repository.UserRepo;
import ru.x3m.rem.repository.RoleRepo;

import java.util.Arrays;

@Service
@Transactional
public class UserService {

    private final UserRepo userRepo;
    private final RoleRepo roleRepo;

    private final BCryptPasswordEncoder passwordEncoder;


    public UserService(UserRepo userRepo, RoleRepo roleRepo, BCryptPasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.roleRepo = roleRepo;
        this.passwordEncoder = passwordEncoder;
    }

    public void create(UserDTO userDTO){
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        userRepo.save(user);
    }

}
