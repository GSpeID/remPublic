package ru.x3m.rem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.x3m.rem.entity.User;
import ru.x3m.rem.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@RestController
@RequestMapping("/user/api/")
public class UserRestController {

    UserService userService;

    @Autowired
    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/findUser/{userId}", method = RequestMethod.GET)
    public Optional<User> getUserByIdRest(HttpServletRequest request,
                                          @PathVariable("userId") Long userId) {
        return userService.findUserById(userId);
    }

}
