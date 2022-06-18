package ru.x3m.rem.controller;

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
public class RegistrationController {


    private final UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/register")
    public String registerPage(Model model) {
        model.addAttribute("user", new UserDTO());
        return "register";
    }

    @PostMapping("/register")
    public String registerNewUser(@ModelAttribute("user") @Valid UserDTO userDTO,
                                  BindingResult result) {

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
