package com.example.demo.service;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;


@EnableWebSecurity
class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http

				.csrf().disable()
				.authorizeRequests()
				.antMatchers(
						"/",
						"/js/**",
						"/css/**",
						"/addUser/**",
						"/resources/**",
						"/img/**",
						"/webjars/**",
						"/newUser").permitAll()
				.antMatchers(
						"/dashboard",
						"/uconstruction1",
						"/uconstruction2",
						"/uconstruction3",
						"/uconstruction4"
				).access("hasRole('user')")
				.anyRequest().authenticated()
				.and()
				.formLogin()
				.loginPage("/loginPage").permitAll()
				.defaultSuccessUrl("/dashboard", true)

				.permitAll()
				.and()
				.logout()
				.permitAll();
		http.headers().frameOptions().disable();
	}
}

