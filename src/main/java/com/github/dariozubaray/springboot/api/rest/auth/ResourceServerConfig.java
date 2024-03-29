package com.github.dariozubaray.springboot.api.rest.auth;

import java.util.Arrays;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        // @formatter: off
        http.authorizeRequests()
            .antMatchers(HttpMethod.GET, "/api/clientes", "/api/clientes/page/**", "/img/**", "/api/clientes/uploads/img/**").permitAll()
            .antMatchers(HttpMethod.GET, "/api/productos", "/api/productos/page/**").permitAll()
//            .antMatchers(HttpMethod.GET, "/api/clientes/{id}").hasAnyRole("USER", "ADMIN")
//            .antMatchers(HttpMethod.POST, "/api/clientes/upload").hasAnyRole("USER", "ADMIN")
//            .antMatchers(HttpMethod.POST, "/api/clientes").hasRole("ADMIN")
//            .antMatchers("/api/clientes/**").hasRole("ADMIN")
            .anyRequest().authenticated()
            .and()
            .cors().configurationSource(corsConfigurationSource());
        // @formatter: on
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
        config.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        config.setAllowCredentials(true);
        config.setAllowedHeaders(Arrays.asList("Content-type", "Authorization"));

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);

        return source;
    }

    @Bean
    public FilterRegistrationBean<CorsFilter> corsFilter() {
        CorsFilter corsFilter = new CorsFilter(corsConfigurationSource());
        FilterRegistrationBean<CorsFilter> corsFilterBean = new FilterRegistrationBean<>(corsFilter);
        corsFilterBean.setOrder(Ordered.HIGHEST_PRECEDENCE);
        return corsFilterBean;
    }
}
