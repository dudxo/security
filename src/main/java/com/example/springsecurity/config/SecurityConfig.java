package com.example.springsecurity.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig{


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{

        //모든 요청에 대해 인증 필요
        http
                .authorizeHttpRequests((auth) -> auth
                        .anyRequest().authenticated()
                );

        //특정 요청에 대해서 허용
//        http
//                .authorizeHttpRequests((auth) -> auth
//                        .requestMatchers("/success").permitAll()
//                );

        //Security 제공되는 기본 FormLogin 끄기
        http
//                .formLogin((auth) -> auth.disable());
                .formLogin((auth) ->
                        auth.defaultSuccessUrl("/success")

                );
        return http.build();
    }

}
