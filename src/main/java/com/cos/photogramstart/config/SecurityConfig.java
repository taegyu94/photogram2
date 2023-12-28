package com.cos.photogramstart.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig  extends WebSecurityConfigurerAdapter{
	
	@Bean
	public BCryptPasswordEncoder encode() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//super.configure(http); // super 제거 -> 기존 스프링 시큐리티가 가지고 있는 기능 disable
		http.csrf().disable(); //csrf 토큰 비활성화
		http.authorizeRequests()
		.antMatchers("/", "/user/**", "/image/**", "/subscribe/**", "/comment/**", "/api/**").authenticated()
		.anyRequest().permitAll()
		.and()
		.formLogin()
		.loginPage("/auth/signin")
		.defaultSuccessUrl("/");
		
	}

}
