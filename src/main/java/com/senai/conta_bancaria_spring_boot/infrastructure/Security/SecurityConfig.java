package com.senai.conta_bancaria_spring_boot.infrastructure.Security;


import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.*;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {

    private final UsuarioDetailsService usuarioDetailsService;
    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(
                        AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/auth/**","/auth/refresh", "/swagger-ui/**", "/v3/api-docs/**", "/h2-console/**", "/api/pagamentos/**").permitAll()

                        .requestMatchers(HttpMethod.POST, "/api/gerente").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/api/gerente").hasAnyRole("ADMIN","GERENTE")

                        .requestMatchers(HttpMethod.POST, "/api/cliente").hasAnyRole("ADMIN","GERENTE")
                        .requestMatchers(HttpMethod.GET, "/api/cliente").hasAnyRole("ADMIN","GERENTE")

                        .requestMatchers(HttpMethod.POST, "/api/conta/**").hasRole("CLIENTE")
                        .requestMatchers(HttpMethod.GET, "/api/conta").hasAnyRole("ADMIN","GERENTE","CLIENTE")

                        .requestMatchers(HttpMethod.POST, "/api/pagamentos").hasAnyRole("CLIENTE", "ADMIN")
                        .requestMatchers(HttpMethod.GET, "/api/pagamentos").hasAnyRole("CLIENTE", "GERENTE", "ADMIN")

                        .requestMatchers(HttpMethod.POST, "/api/taxas").hasAnyRole("GERENTE","ADMIN")
                        .requestMatchers(HttpMethod.GET, "/api/taxas").hasAnyRole("CLIENTE", "GERENTE", "ADMIN")


                        .anyRequest().authenticated()

                )
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .userDetailsService(usuarioDetailsService);

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authManager(AuthenticationConfiguration configuration) throws Exception{
        return configuration.getAuthenticationManager();
    }
}
