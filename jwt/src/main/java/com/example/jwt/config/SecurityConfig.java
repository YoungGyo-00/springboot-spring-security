package com.example.jwt.config;

import lombok.RequiredArgsConstructor;
import org.apache.catalina.filters.CorsFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig{

    private final CorsFilter corsFilter;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilter(corsFilter) // @CorssOrigin(인증 x), 시큐리티 필터에 인증
                .formLogin().disable()
                .httpBasic().disable()
                .authorizeHttpRequests()
                .requestMatchers("/api/vi/user/**")
                .hasAnyAuthority("ROLE_USER", "ROLE_MANAGER", "ROLE_ADMIN")
                .requestMatchers("api/v1/manager/**")
                .hasAnyAuthority("ROLE_MANAGER", "ROLE_ADMIN")
                .requestMatchers("/api/v1/admin/**")
                .hasAuthority("ROLE_ADMIN")
                .anyRequest().permitAll();

        return http.build();
    }
}
