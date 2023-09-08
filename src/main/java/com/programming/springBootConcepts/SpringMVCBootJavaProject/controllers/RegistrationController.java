package com.programming.springBootConcepts.SpringMVCBootJavaProject.controllers;

import com.programming.springBootConcepts.SpringMVCBootJavaProject.beans.User;
import com.programming.springBootConcepts.SpringMVCBootJavaProject.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {

    @Autowired
    private UserRepository userRepository;
    @PostMapping("/registeruser")
    public String saveInDatabase(@Valid @ModelAttribute("newuser") User user, BindingResult result,Model model){
        System.out.println("In Registration Controller");
        if(result.hasErrors()){
            return "register";
        }
        userRepository.save(user);
        model.addAttribute("dataSaved","User Registered Successfully");
        return "login";
    }
}
