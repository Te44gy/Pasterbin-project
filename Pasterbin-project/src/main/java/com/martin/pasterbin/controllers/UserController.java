package com.martin.pasterbin.controllers;

import com.martin.pasterbin.service.ActiveUserService;
import com.martin.pasterbin.models.User;
//import com.martin.pasterbin.models.enums.Role;
import com.martin.pasterbin.repostitories.UserRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@Controller
@RequiredArgsConstructor
@RequestMapping("/pasterbin")
public class UserController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    ActiveUserService activeUserService;

    @GetMapping("/login")
    public String login(@ModelAttribute("attributeUser") User userLogging){
        if(activeUserService.getActiveUser()==null){
            return "login";
        }
        return "redirect:/pasterbin/home";
    }

    @PostMapping("/login")
    public String logging(@ModelAttribute("attributeUser") @Valid User userLogging, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return "login";
        }
        User userFromDB = userRepository.findByEmail(userLogging.getEmail());
        if(userFromDB!=null){
            String userDBPassword = userFromDB.getPassword();
            if(Objects.equals(userDBPassword, userLogging.getPassword())){
                activeUserService.setActiveUser(userFromDB);
                return "redirect:/pasterbin/home";
            }
        }
        return "redirect:/pasterbin/login";
    }

//    @PostMapping("/login")
//    public String logging(@RequestParam String email,
//                          @RequestParam String password){
//        User userFromDB = userRepository.findByEmail(email);
//        if(userFromDB!=null){
//            String userDBPassword = userFromDB.getPassword();
//            if(Objects.equals(userDBPassword, password)){
//                return "home-page";
//            }
//        }
//        return "redirect:/pasterbin/login";
//    }

    @GetMapping("/logout")
    public String logout(){
        activeUserService.setInactiveUser();
        return "redirect:/pasterbin/home";
    }

    @GetMapping("/registration")
    public String registration(@ModelAttribute("attributeUser") User user){
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(@ModelAttribute("attributeUser") @Valid User user, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return "registration";
        }
        User newUser = userRepository.findByEmail(user.getEmail());
        if(newUser!=null){
            return "registration";
        }
        userRepository.save(user);
        System.out.println("Пользыватель сохранен");
        return "redirect:/pasterbin/login";
    }

}
