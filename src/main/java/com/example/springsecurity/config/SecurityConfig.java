package com.example.springsecurity.config;


import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import java.io.IOException;

@Configuration
@EnableWebSecurity
public class SecurityConfig{


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{

        //모든 요청에 대해 인증 필요
//        http
//                .authorizeHttpRequests((auth) -> auth
//                        .anyRequest().authenticated()
//                );

        //특정 요청에 대해서 허용
        http
                .authorizeHttpRequests((auth) -> auth
                        .requestMatchers("/success").permitAll()
                );

        //Security basic formLogin
        http
//                .formLogin((auth) -> auth.disable());
                .formLogin((auth) ->
                        auth
                                .defaultSuccessUrl("/success")
                                .failureUrl("/login")
//                                .successHandler(
//                                        new AuthenticationSuccessHandler() {
//                                            @Override
//                                            public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
//                                                System.out.println("로그인 성공 ID : " + authentication.getName());
//                                                response.sendRedirect("/success");
//                                            }
//                                        }
//                                )
//                                .failureHandler(
//                                        new AuthenticationFailureHandler() {
//                                            @Override
//                                            public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
//                                                System.out.println("로그인 실패 : " + exception.getMessage());
//                                                response.sendRedirect("/login");
//                                            }
//                                        }
//                                )
                );
        return http.build();
    }

}
