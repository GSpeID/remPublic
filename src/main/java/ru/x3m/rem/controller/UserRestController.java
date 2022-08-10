package ru.x3m.rem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.x3m.rem.dto.UserDTO;
import ru.x3m.rem.service.UserService;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/user/api/")
public class UserRestController {

    UserService userService;

    @Autowired
    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/findUser/{userId}")
    public UserDTO getUserByIdRest(HttpServletRequest request,
                                   @PathVariable("userId") Long userId) {
        return userService.findUserById(userId);
    }

}
