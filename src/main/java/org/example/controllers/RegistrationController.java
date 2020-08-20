package org.example.controllers;

import org.example.dao.UserDAO;
import org.example.models.Role;
import org.example.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;

@Controller
public class RegistrationController {

    @Autowired
    private UserDAO userDAO;

    @GetMapping("/registration")
    public String registration() {
        return "RegistrationPage";
    }

    @PostMapping("/registration")
    public String addUser(User user, Model model) {
        User userFromDb = userDAO.findByUsername(user.getUsername());

        if (userFromDb != null) {
            model.addAttribute("message", "User exists!");
            return "RegistrationPage";
        }

        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        userDAO.save(user);

        return "redirect:/login";
    }
}
