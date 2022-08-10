package ru.x3m.rem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.x3m.rem.dto.UserDTO;
import ru.x3m.rem.entity.User;
import ru.x3m.rem.repository.RoleRepo;
import ru.x3m.rem.repository.UserRepo;
import ru.x3m.rem.utils.ObjectMapperUtils;

import java.util.List;

@Service
@Transactional
public class UserService implements UserDetailsService {

    private final UserRepo userRepo;
    private final RoleRepo roleRepo;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepo userRepo, RoleRepo roleRepo, BCryptPasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.roleRepo = roleRepo;
        this.passwordEncoder = passwordEncoder;
    }

    public UserDTO findUserById(Long id) {
        User user = userRepo.findByUserId(id);
        return ObjectMapperUtils.map(user, UserDTO.class);
    }

    public List<UserDTO> findAllUsers() {
        List<User> users = (List<User>) userRepo.findAll();
        return ObjectMapperUtils.mapAll(users, UserDTO.class);
    }

    public void create(UserDTO userDTO) {
        User user = ObjectMapperUtils.map(userDTO, User.class);
        userRepo.save(user);
    }

    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userRepo.getUserByUsername(userName);
        if (user == null) {
            return null;
        }
        List<GrantedAuthority> auth = AuthorityUtils
                .commaSeparatedStringToAuthorityList(user.getRole().getRoleName());
        String password = user.getPassword();
        return new org.springframework.security.core.userdetails.User(userName, password, auth);
    }

}
