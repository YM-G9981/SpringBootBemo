package com.example.springbootdemo.config;

import com.example.springbootdemo.service.UserAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/","/static/**","/resignUser","/resign","/failure"
                ,"/resignSuccess","/resignFailure").permitAll()
                .anyRequest().hasAnyRole("teacher","student")
                .and()
                .formLogin()
                .loginPage("/")
                .loginProcessingUrl("/loginin")
                .successForwardUrl("/main")
                .failureForwardUrl("/failure")
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/")
                .and()
                .csrf().disable();

    }
    @Autowired
    UserAuthService userAuthService;
    @Autowired
    BCryptPasswordEncoder bcryptPasswordEncoder;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userAuthService)
                .passwordEncoder(bcryptPasswordEncoder);
    }
}
