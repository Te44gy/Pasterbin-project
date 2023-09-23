//package com.martin.pasterbin.Service;
//
//import com.martin.pasterbin.models.User;
//import com.martin.pasterbin.models.enums.Role;
//import com.martin.pasterbin.repostitories.UserRepository;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Repository;
//import org.springframework.stereotype.Service;
//
//@Slf4j
//@Service
//@RequiredArgsConstructor
//public class UserService {
//
//    private final UserRepository userRepository;
//    private final PasswordEncoder passwordEncoder;
//
//    public boolean createUser(User user){
//        String email = user.getEmail();
//        if(userRepository.findByEmail(email) != null){
//            return false;
//        }
//        user.setActive(true);
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
//        user.getRoles().add(Role.ROLE_USER);
//        log.info("Сохранение нового User с email: " + email);
//        userRepository.save(user);
//        return true;
//    }
//
//}
