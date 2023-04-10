package com.marcodebarros.authentication.demo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.oauth2.server.resource.authentication.JwtIssuerAuthenticationManagerResolver;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    private static String googleIssuer = "https://accounts.google.com";
    private static String githubIssuer = "https://github.com/login/oauth/access_token";
    private static String microsoftIssuer = "https://sts.windows.net/46a561fd-f65e-4010-ae9b-1b456edf9f2e/";

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        JwtIssuerAuthenticationManagerResolver authenticationManagerResolver = new JwtIssuerAuthenticationManagerResolver
                (microsoftIssuer, githubIssuer, googleIssuer);
        http
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/greetings/hello").permitAll()
                        .anyRequest().authenticated()
                )
                .oauth2ResourceServer(oauth -> oauth.authenticationManagerResolver(authenticationManagerResolver));
        http.cors().and().csrf().disable();
        return http.build();
    }
}
