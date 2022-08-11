package ru.x3m.rem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.x3m.rem.dto.UserDTO;
import ru.x3m.rem.service.UserService;

import javax.validation.Valid;
import java.util.List;

@Controller
public class AdminPanelController {

    private final UserService userService;

    @Autowired
    public AdminPanelController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/adminPanel")
    public String adminPanel(Model model) {
        List<UserDTO> users = userService.findAllUsers();
        model.addAttribute("users", users);
        model.addAttribute("newUser", new UserDTO());
        return "adminPanel";
    }

    @PostMapping("/adminPanel/createUser")
    public String registerNewUser(@ModelAttribute("newUser") @Valid UserDTO userDTO,
                                  BindingResult result, Model model) {

        if (result.hasErrors()) {
            model.addAttribute("newUser", userDTO);
            return "adminPanel";
        }
        if (userService.ifUserExist(userDTO.getUsername())) {
            result.rejectValue("username", "", "Пользователь с таким именем уже существует");
            return "adminPanel";
        }
        if (!userDTO.getPassword().equals(userDTO.getMatchingPassword())) {
            result.rejectValue("password", "", "Введённые пароли не совпадают");
            return "adminPanel";
        }

        userService.create(userDTO);
        return "redirect:/adminPanel";
    }

    @PostMapping("/adminPanel/deleteUser/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/adminPanel";
    }

}
