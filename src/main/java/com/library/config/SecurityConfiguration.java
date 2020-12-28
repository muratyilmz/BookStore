package com.library.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.library.service.UserService;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private UserService userService;
	
	
	
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
		
	}
	
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
		auth.setUserDetailsService(userService);
		auth.setPasswordEncoder(passwordEncoder());
		return auth;
	}
	
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.authenticationProvider(authenticationProvider());
		auth.inMemoryAuthentication()
        .withUser("admin@gmail.com")
        .password(encoder().encode("admin"))
        .roles("ADMIN");
		
		
	}
	
	
	

	protected void configure(HttpSecurity httpSecurity ) throws Exception {
		
		httpSecurity.authorizeRequests().antMatchers(
				"/registration**",
				"/js/**",
				"/css/**",
				"/img/**").permitAll()
		.antMatchers("/"
				,"registration"
				,"detailed_view"
				,"search_result").permitAll()
		.antMatchers(
				"new_library"
				,"update_library","user").hasRole("ADMIN")
		.anyRequest().authenticated()
		.and()
		
		.formLogin()
		.loginPage("/login")
		.permitAll()
		.and()
		.logout()
		.invalidateHttpSession(true)
		.clearAuthentication(true)
		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		.logoutSuccessUrl("/login?logout")
		.permitAll();
			
	}
private BCryptPasswordEncoder encoder() {
		
		return new BCryptPasswordEncoder();
	}

}
	
