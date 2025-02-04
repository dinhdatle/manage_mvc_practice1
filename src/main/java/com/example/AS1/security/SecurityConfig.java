package com.example.AS1.security;

import com.example.AS1.service.impl.CustomUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@Configuration
public class SecurityConfig {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/login", "/css/**").permitAll() // Cho phép truy cập không cần đăng nhập
                        .requestMatchers("/logout", "/css/**").permitAll() // Cho phép truy cập không cần đăng nhập
                        .requestMatchers("/students", "/accounts", "/classes", "/courses").hasRole("ADMIN") // Chỉ Admin
                        .requestMatchers("/scores").hasRole("TRAINER") // Chỉ Trainer
                        .anyRequest().authenticated()                     // Các yêu cầu khác cần đăng nhập
                )
                .formLogin(form -> form
                        .loginPage("/login")                  // Định nghĩa trang login
                        .defaultSuccessUrl("/")               // Chuyển hướng sau khi đăng nhập thành công
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/login")
                        .permitAll()
                )
                .csrf(csrf -> csrf
                        .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()) // Optional: adds CSRF token as a cookie
                );

        return http.build();
    }

    @Bean
    public AuthenticationManager authManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

}
