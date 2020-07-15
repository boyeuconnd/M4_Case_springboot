package com.casestudy.casestudy.config;

import com.casestudy.casestudy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    UserService userService;

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService((UserDetailsService) userService)
                .passwordEncoder(passwordEncoder());
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/","/blog","/staff","/gallery","/user/**")
                .permitAll()
                .and().authorizeRequests().antMatchers("/staff/promote")
                .hasRole("CUSTOMER")
                .and().authorizeRequests().antMatchers("/payment/**","/user/delete","/blog/**","/staff/view/**")
                .hasAnyRole("CUSTOMER","STAFF","ADMIN")
                .and()
                .authorizeRequests().antMatchers("/staff/**")
                .hasAnyRole("STAFF","ADMIN")
                .and()
                .authorizeRequests().antMatchers("/gallery/**","/admin/**")
                .hasRole("ADMIN")
                .and().formLogin()
                .loginPage("/login")
                .and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .and().exceptionHandling().accessDeniedPage("/403")
                .and().csrf().disable();
    }
}
