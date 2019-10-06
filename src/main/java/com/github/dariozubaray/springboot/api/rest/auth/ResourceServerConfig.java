package com.github.dariozubaray.springboot.api.rest.auth;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        // @formatter: off
        http.authorizeRequests()
            .antMatchers(HttpMethod.GET, "/api/clientes", "/api/clientes/page/**", "/api/clientes/uploads/img/**").permitAll()
            .antMatchers(HttpMethod.GET, "/api/clientes/{id}").hasAnyRole("USER", "ADMIN")
            .antMatchers(HttpMethod.POST, "/api/clientes/upload").hasAnyRole("USER", "ADMIN")
            .antMatchers(HttpMethod.POST, "/api/clientes").hasRole("ADMIN")
            .antMatchers("/api/clientes/**").hasRole("ADMIN")
            .anyRequest().authenticated();
        // @formatter: on
    }
}
