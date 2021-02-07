package com.java.securitytest.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource securityDataSource;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
//		UserBuilder userBuilder = User.withDefaultPasswordEncoder();
//		auth.inMemoryAuthentication().withUser(userBuilder.username("naveen").password("qwerty").roles("Admin"))
//				.withUser(userBuilder.username("rohit").password("qwerty").roles("employee"));

		auth.jdbcAuthentication().dataSource(securityDataSource);
		
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/employee").hasRole("Admin").and().formLogin().loginPage("/loginPage")
				.loginProcessingUrl("/homePage").permitAll().and().logout().permitAll().and().exceptionHandling()
				.accessDeniedPage("/access-handling-page");
	}

}
