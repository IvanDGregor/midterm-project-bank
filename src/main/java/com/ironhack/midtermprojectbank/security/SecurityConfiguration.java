package com.ironhack.midtermprojectbank.security;


import com.ironhack.midtermprojectbank.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableGlobalMethodSecurity(securedEnabled=true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Bean
    public PasswordEncoder passwordEncoder () {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder);
    }

    @Override
    public void configure(HttpSecurity httpSecurity) throws Exception {

        httpSecurity.httpBasic();
        httpSecurity.authorizeRequests()
                .antMatchers(HttpMethod.GET, "/saving/**").hasAnyAuthority("ROLE_ADMIN","ROLE_HOLDER")
                .antMatchers(HttpMethod.GET, "/credit-card/**").hasAnyAuthority("ROLE_ADMIN","ROLE_HOLDER")
                .antMatchers(HttpMethod.GET, "/checking/**").hasAnyAuthority("ROLE_ADMIN","ROLE_HOLDER")
                .antMatchers(HttpMethod.GET, "/student-checking/**").hasAnyAuthority("ROLE_ADMIN","ROLE_HOLDER")
                .antMatchers(HttpMethod.POST, "/admin/**").hasAuthority("ROLE_ADMIN")
//                .antMatchers("/", "/resources/**").permitAll()
                .and().logout().deleteCookies("JSESSIONID");

        httpSecurity.csrf().disable();
    }
}
