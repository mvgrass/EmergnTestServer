package com.mvgrass.Server.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private MyUserDetailsService userDetailsService;


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.httpBasic()


                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET,"/api/users/").authenticated()

                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/api/users/").permitAll()

                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/api/users/{id}").authenticated()

                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.PUT,"/api/users/{id}")
                .access("isAuthenticated() and @guard.checkUser(authentication, #id)")

                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.DELETE,"/api/users/{id}")
                .access("isAuthenticated() and @guard.checkUser(authentication, #id)")

                //TO DO
                .and().csrf().disable();//ENABLE LATER
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider
                = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(encoder());
        return authProvider;
    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }
}
