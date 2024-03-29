package com.example.mountain.config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@RequiredArgsConstructor
public class WebSecurityConfig {
	
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http)throws Exception{
		http.formLogin(login -> login
				//ユーザー名、パスワードの送信先URL
				.loginProcessingUrl("/login")
				//ログイン画面のURL
				.loginPage("/login")
				//ログイン成功後のリダイレクト先URL
				.defaultSuccessUrl("/mypage")
				//ログイン失敗後のリダイレクト先URL
				.failureUrl("/login?error")
				//ログイン画面は未認証でもアクセス可能
				.permitAll()
		).logout(logout -> logout
				.logoutSuccessUrl("/")
				.invalidateHttpSession(true)
		).authorizeHttpRequests(authz -> authz
				.requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
				.requestMatchers("/","/top","/result**","/search","/show**","/signup").permitAll()
				.anyRequest().authenticated()
		);
		return http.build();
	}
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
}
