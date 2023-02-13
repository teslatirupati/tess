package com.photan;

import org.apache.catalina.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfigaration extends WebSecurityConfigurerAdapter{
	@Bean
	protected UserDetailsService userdeails() {
		UserDetails userd=org.springframework.security.core.userdetails.User.builder().username("trisha")
				.password("{noop}sam").roles("USER").build();
    
		UserDetails usera= org.springframework.security.core.userdetails.User.builder().
				username("tamcat").password("{noop}sam").roles("ADMIN").
				build();
		return new InMemoryUserDetailsManager(userd,usera);
		
	}
	
	protected void configer(HttpSecurity http)throws Exception
	{
		http.csrf().disable()
		.authorizeRequests()
		.antMatchers(HttpMethod.GET,"/api/**").permitAll()
		.antMatchers("/api/auth/**").permitAll()
		.anyRequest().authenticated();
		
	}
}
