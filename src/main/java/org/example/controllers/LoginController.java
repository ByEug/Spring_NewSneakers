package org.example.controllers;


import org.example.models.User;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String LoginPage() {
        return "LoginPage";
    }

    /*@PostMapping("/login")
    public String Login(@ModelAttribute("userForm") User userForm, Model model) {
        if (userService.findByUsername(userForm.getUsername()) == null) {
            return "redirect:/login?error";
        }
    }*/

    @GetMapping("/registration")
    public String RegistrationPage(Model model) {

        //model.addAttribute("userForm", new User());

        return "RegistrationPage";
    }

    @PostMapping("/registration")
    public String Registration(@ModelAttribute("userForm") User userForm, Model model) {

        System.out.println(userForm.getUsername() + userForm.getPassword());
        userService.save(userForm);

        return "redirect:/login";
    }

    @GetMapping("/logout")
    public String LogoutPage(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login?logout";
    }
}
