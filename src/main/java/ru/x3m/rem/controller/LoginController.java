package ru.x3m.rem.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.x3m.rem.dto.UserDTO;
import ru.x3m.rem.service.UserService;

import javax.validation.Valid;

@Controller
public class LoginController {

    private static final Logger logger =  LoggerFactory.getLogger(LoginController.class);

    private final UserService userService;

    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String loginPage(){
        return  "/login";
    }
    @GetMapping("/register")
    public String registerPage(Model model) {
        model.addAttribute("user", new UserDTO());
        return "register";
    }

    @PostMapping("/register")
    public String registerNewUser(@ModelAttribute("user") @Valid UserDTO userDTO,
                                  BindingResult result) {
        logger.info("New user {}", userDTO);

        if (result.hasErrors()) {
            return "register";
        }
        if (!userDTO.getPassword().equals(userDTO.getMatchingPassword())) {
            result.rejectValue("password", "", "Password not matching");
            return "register";
        }

        userService.create(userDTO);
        return "redirect:/login";
    }

}
