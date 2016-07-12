package com.dhboa.insol.usermanagement.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@Order(-20)
public class WebSecurity extends WebSecurityConfigurerAdapter {
	@Autowired
	private AuthenticationManager authenticationManager;

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.formLogin().loginPage("/login.html").loginProcessingUrl("/login").permitAll().and().authorizeRequests()
				.antMatchers("/login", "/oauth/authorize", "/oauth/confirm_access","/oauth/token").permitAll().anyRequest()
				.authenticated().and().csrf().disable();
	}

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.parentAuthenticationManager(authenticationManager).inMemoryAuthentication().withUser("user")
				.password("pwd").authorities("ADMIN");
	}
}
