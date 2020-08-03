package com.inventory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.inventory.service.MyUserDetailsService;

@EnableWebSecurity
public class SecurityConfigurer extends WebSecurityConfigurerAdapter {
	
	@Autowired
	MyUserDetailsService myUserDetailsSerivce;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(myUserDetailsSerivce);
	}

	@Bean
	public PasswordEncoder passworEncoder() {
		return NoOpPasswordEncoder.getInstance();

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
	}

	/*
	 * @Bean public PasswordEncoder passworEncoder() { return
	 * NoOpPasswordEncoder.getInstance(); }
	 */
	/*
	 * @SuppressWarnings("deprecation")
	 * 
	 * @Bean public static NoOpPasswordEncoder passwordEncoder() { return
	 * (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance(); }
	 * 
	 * @Override protected void configure(HttpSecurity http) throws Exception {
	 * http.csrf().disable().authorizeRequests().antMatchers("/ims/*").hasAnyRole(
	 * "admin","user").and().formLogin();
	 * http.csrf().disable().authorizeRequests().antMatchers("/ims/**").hasAnyRole(
	 * "admin","user").and().formLogin(); //
	 * http.csrf().disable().authorizeRequests().antMatchers("/ims/getAllSales").
	 * hasAnyRole("admin").and().formLogin();
	 * 
	 * }
	 * 
	 * @Autowired public void configureGlobal(AuthenticationManagerBuilder auth)
	 * throws Exception {
	 * auth.inMemoryAuthentication().withUser("susmitha").password("{noop}susmitha")
	 * .roles("admin");
	 * auth.inMemoryAuthentication().withUser("robert").password("{noop}robert").
	 * roles("user"); }
	 */
	
}
