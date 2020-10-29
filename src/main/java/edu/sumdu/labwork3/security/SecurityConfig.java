package edu.sumdu.labwork3.security;

import edu.sumdu.labwork3.details.UserDetailsServiceImpl;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
@ComponentScan("edu.sumdu.labwork3")
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    final static Logger logger = Logger.getLogger(SecurityConfig.class);
    private final UserDetailsServiceImpl userDetailsService;

    public SecurityConfig(UserDetailsServiceImpl userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Autowired
    public void registerGlobalAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(encoder());
        return authProvider;
    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http
//            .authorizeRequests()
//            .anyRequest()
//            .hasAnyAuthority("CONSUMER", "SUPPLIER")
//                .and()
//            .formLogin();
        http
                .authorizeRequests()
                .antMatchers("/index.jsp")
                .authenticated()
                .antMatchers("/navigate/admin")
                .hasAnyAuthority("ADMIN")
                    .and()
                .authorizeRequests()
                .antMatchers("/navigate/supplier")
                .hasAnyAuthority("SUPPLIER", "ADMIN")
                    .and()
                .authorizeRequests()
                .antMatchers("/navigate/consumer")
                .hasAnyAuthority("CONSUMER", "ADMIN")
                    .and()
                .formLogin()
                .permitAll()
                    .and()
                .logout()
                .permitAll();
    }
}
