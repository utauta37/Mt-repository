package com.example.mountain.config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig{
	
	@Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
			//フォーム認証の設定
		http.formLogin(login -> login
				.loginProcessingUrl("/login") //ログイン処理のパス
				.loginPage("/mountain/login") //ログインページの指定
				.defaultSuccessUrl("/mountain/mypage") //ログイン成功後の遷移先（任意で「/mypage」）
				//TODO .failureUrl("mounrain/login?error=true") //ログイン失敗時の遷移先（任意で「/login?error」）
				.permitAll()
				.usernameParameter("email") //usernameの認証要素をemailに指定
			//URLごとの認可設定
		).authorizeHttpRequests(authz -> authz
				.requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll() //css,jsなどへのアクセス許可
				.requestMatchers("/mountain","/mountain/search","/mountain/result-**","/mountain/signin","/mountain/show*").permitAll() //認証の必要ないURL
				.anyRequest().authenticated() //以上のURL以外はログイン後にアクセス可能	
		);
        return http.build();
    }

	//パスワードのエンコード
	//@Bean
	//public PasswordEncoder passwordEncoder() {
	//	return new BCryptPasswordEncoder();
	//}
	
	
	
}