package com.example.springboot.config;

/*import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;*/
/*
@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(
                (auth) -> {
                    System.out.println("auth begin");
                    auth
                            .requestMatchers("/", "/home").authenticated()//这里是说/和/home需要验证
                            .anyRequest()
                            .permitAll();
                    System.out.println("auth end");
                }

        ).formLogin(form -> form
                .loginPage("/login")
                .permitAll()
        ).logout(out -> out
                .permitAll()
        );
        System.out.println("http auth begin");
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        //配置一个用户，用户名为user，密码为pass
        UserDetails user =
                User.withDefaultPasswordEncoder()
                        .username("user")
                        .password("password")
                        .roles("USER")
                        .build();

        return new InMemoryUserDetailsManager(user);
    }
}*/