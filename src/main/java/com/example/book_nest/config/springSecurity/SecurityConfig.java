package com.example.book_nest.config.springSecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	@Autowired
	private SecurityProperties securityProperties;

	@Bean
	/*
	 * public SecurityFilterChain securityFilterChain(HttpSecurity http) throws
	 * Exception { http .csrf(AbstractHttpConfigurer::disable)
	 * .authorizeHttpRequests(auth -> {
	 * securityProperties.getNoAuthUrls().forEach(url ->
	 * auth.requestMatchers(url).permitAll()); auth.anyRequest().authenticated(); })
	 * .formLogin(form -> form .loginPage("/login") .permitAll() )
	 * .logout(LogoutConfigurer::permitAll);
	 * 
	 * return http.build(); }
	 */
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.csrf(AbstractHttpConfigurer::disable).authorizeHttpRequests((requests) -> requests.anyRequest().permitAll());

		return http.build();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
