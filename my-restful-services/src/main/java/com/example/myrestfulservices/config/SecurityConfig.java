package com.example.myrestfulservices.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@EnableWebSecurity
@Configuration
public class SecurityConfig {



    @Bean
    public UserDetailsService userDetailsService(){
        UserDetails user = User.withUsername("jun")
                               .password("{noop}test1234")
                               .roles("USER")
                               .build();
        
        return new InMemoryUserDetailsManager(user);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.authorizeRequests()  // 요청에 의한 보안검사 시작
            .antMatchers("/h2-console/**").permitAll()  // 일부 url에 대해서 허용
            .anyRequest()
            .authenticated() 
            .and()
            .httpBasic();
        
        http.csrf().disable();
        http.headers().frameOptions().disable();

        return http.build();
    }

}
