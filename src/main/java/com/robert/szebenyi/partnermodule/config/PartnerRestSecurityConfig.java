package com.robert.szebenyi.partnermodule.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@RequiredArgsConstructor
public class PartnerRestSecurityConfig extends WebSecurityConfigurerAdapter {

    //private final SecurityExceptionHandler securityExceptionHandler;

    @Value("${partner-api.username}")
    private String username;

    @Value("${partner-api.password}")
    private String password;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser(username).password(passwordEncoder().encode(password))
                .authorities("ROLE_USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .antMatcher("/partner/**")
                .authorizeRequests()
                .anyRequest()
                .permitAll()  // TODO
//                .authenticated()
//                .and()
//                .httpBasic()
//                // .authenticationEntryPoint(authenticationEntryPoint())
//                .and()
//                .exceptionHandling()
        // .accessDeniedHandler(accessDeniedHandler())
        ;
    }


//    private AuthenticationEntryPoint authenticationEntryPoint() throws Exception {
//        return new InternalRestAuthenticationEntryPoint(securityExceptionHandler);
//    }
//
//    private AccessDeniedHandler accessDeniedHandler() {
//        return (request, response, exception) -> securityExceptionHandler.handle(response, exception);
//    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
