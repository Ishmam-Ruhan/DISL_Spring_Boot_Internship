package com.ishmam.SpringSecurityPractice.Configurations;

import com.ishmam.SpringSecurityPractice.Service.Security.CustomUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.authentication.www.DigestAuthenticationEntryPoint;
import org.springframework.security.web.authentication.www.DigestAuthenticationFilter;

//@Configuration
//@EnableWebSecurity
//@Order(1)
public class DigestFilterConfig{// extends WebSecurityConfigurerAdapter {
//
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//
//
//		http.headers().disable().antMatcher("/admin/**").
//				addFilter(getDigestAuthFilter()).exceptionHandling()
//				.authenticationEntryPoint(getDigestEntryPoint())
//				.and().authorizeRequests().antMatchers("/admin/**").hasRole("ADMIN");
//	}
//
//
//
//	// TODO-9 Uncomment the below to configure  DigestAuthenticationFilter.
//	// Observe the we are injecting userDetailsService and DigestAuthenticationEntryPoint
//
//	private DigestAuthenticationFilter getDigestAuthFilter() throws Exception {
//		DigestAuthenticationFilter digestFilter = new DigestAuthenticationFilter();
//		digestFilter.setUserDetailsService(userDetailsServiceBean());
//		digestFilter.setAuthenticationEntryPoint(getDigestEntryPoint());
//		return digestFilter;
//	}
//
//
//	// TODO-5 uncomment the below to configure DigestAuthenticationEntryPoint
//
//	private DigestAuthenticationEntryPoint getDigestEntryPoint() {
//		DigestAuthenticationEntryPoint digestEntryPoint = new DigestAuthenticationEntryPoint();
//		digestEntryPoint.setRealmName("admin-digest-realm");
//		digestEntryPoint.setKey("somedigestkey");
//		return digestEntryPoint;
//	}
//
//
//
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication()
//				.withUser("digestsiva")
//				.password(passwordEncoder().encode("digestsecret"))
//				.roles("USER")
//				.and()
//				.withUser("admin")
//				.password(passwordEncoder().encode("adminsecret"))
//				.roles("ADMIN");
//	}
//
//
//	@Bean
//	public UserDetailsService userDetailsServiceBean() throws Exception {
//		return super.userDetailsServiceBean();
//	}
//
//
//
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//
//		//return NoOpPasswordEncoder.getInstance();
//	}

}
