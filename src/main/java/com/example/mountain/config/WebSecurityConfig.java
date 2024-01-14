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
				.loginProcessingUrl("/mountain/login")
				//ログイン画面のURL
				.loginPage("/mountain/login")
				//ログイン成功後のリダイレクト先URL
				.defaultSuccessUrl("/mountain/user-mypage")
				//ログイン失敗後のリダイレクト先URL
				.failureUrl("/mountain/login?error")
				//ログイン画面は未認証でもアクセス可能
				.permitAll()
		).logout(logout -> logout
				//.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				.logoutSuccessUrl("/mountain/login")
				.invalidateHttpSession(true)
		).authorizeHttpRequests(authz -> authz
				.requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
				.requestMatchers("/mountain","/mountain/result**","/mountain/search","/mountain/show**","/mountain/signup").permitAll()
				.anyRequest().authenticated()
		);
		return http.build();
	}
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
}
