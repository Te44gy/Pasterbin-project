//package com.martin.pasterbin.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.core.annotation.Order;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer;
//import org.springframework.security.web.SecurityFilterChain;
//
//@EnableWebSecurity
//public class NewSecurityConfig {
//
//    @Bean
//    SecurityFilterChain     defaultSecurityFilterChain(HttpSecurity http) throws Exception {
//        http.authorizeHttpRequests((requests) -> {
//            ((AuthorizeHttpRequestsConfigurer.AuthorizedUrl)requests.anyRequest())
//                    .authenticated();
//        });
//        http.httpBasic(Customizer.withDefaults());
////        http.formLogin(Customizer.withDefaults());
////        http.httpBasic(Customizer.withDefaults());
//        return (SecurityFilterChain)http.build();
//    }
//
//}
