package ru.x3m.rem.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http

                .cors().and().csrf().disable()
                .authorizeRequests()
                .antMatchers("/", "/authUser", "/login", "/static/**", "/css/*", "/js/*","/images/*","/favicon.ico",
                        "/statistic/api/*", "/statistic/api/**", "/events/api/*", "/events/api/**").permitAll()
                .anyRequest().permitAll()
                .and()
                .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/authUser")
                .defaultSuccessUrl("/repair-service")
                .and()
                .logout()
                .logoutSuccessUrl("/");
    }



}
