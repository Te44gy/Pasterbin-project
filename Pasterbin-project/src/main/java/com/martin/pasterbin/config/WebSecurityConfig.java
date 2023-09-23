//package com.martin.pasterbin.config;
//
////import com.martin.pasterbin.Service.CustomUserDetailsService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.NoOpPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.stereotype.Component;
//
//import javax.sql.DataSource;
//
//@Component
//@EnableWebSecurity
//@RequiredArgsConstructor
//public class WebSecurityConfig {
////	private final CustomUserDetailsService userDetailsService;
//
//	@Autowired
//	private DataSource dataSource;
//
//
//	@Bean
//	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//		http
//			.authorizeHttpRequests((requests) -> requests
//				.requestMatchers("/pasterbin/home", "/pasterbin/registration").permitAll()  // --->  не требуют аутификации <---
//				.anyRequest().authenticated()
//			)
//
//			.formLogin((form) -> form
//				.loginPage("/login") //  --->  требуют аутификации  <---
//				.permitAll()
//			)
//			.logout((logout) -> logout.permitAll());
//
//		return http.build();
//
//
//	}
//
//
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
//		System.out.println("Запрос к базе данных");
//		auth.jdbcAuthentication()
//				.dataSource(dataSource)
//				.passwordEncoder(NoOpPasswordEncoder.getInstance())
//				.usersByUsernameQuery("select email, password, active from db_example.users where email=?")
//				.authoritiesByUsernameQuery("select email u.username, ur.roles from users u inner join user_role ur on u.id = ur.user_id where u.username=?");
//		System.out.println("Запрос к базе данных");
//	}
////
////
////
//////
//////	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//////		auth.userDetailsService(userDetailsService)
//////				.passwordEncoder(passwordEncoder());
//////	}
//////
//////	@Bean
//////	PasswordEncoder passwordEncoder() {
//////		return new BCryptPasswordEncoder(8);
//////	}
////
//	@Bean
//	public UserDetailsService userDetailsService() {
//		UserDetails user = User.withDefaultPasswordEncoder()
//				.username("u")
//				.password("1")
//				.roles("USER")
//				.build();
//
//		return new InMemoryUserDetailsManager(user);
//	}
//}