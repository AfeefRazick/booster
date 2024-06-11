package org.rooster.server.config;

import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
    private static final String[] USER_RESTRICTED_URLS = {
            "/job/**",
            "/user/**"
    };
    private static final String[] ADMIN_RESTRICTED_URLS = {
            "/admin/**",
    };

    private static final String[] API_DOCUMENTATION_URLS = {
            "/v2/api-docs",
            "/v3/api-docs",
            "/v3/api-docs/**",
            "/swagger-resources",
            "/swagger-resources/**",
            "/configuration/ui",
            "/configuration/security",
            "/swagger-ui/**",
            "/webjars/**",
            "/swagger-ui.html"
    };
    private static final String[] WHITE_LIST_URLS = {
            "/auth/**",
    };

    private final AuthenticationProvider authenticationProvider;
    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(requestMatcherRegistry ->
                        // when a user hits non-existent route it returns 403, which is super confusing
                        // https://stackoverflow.com/questions/70054528/receiving-403-instead-of-404-when-calling-non-existing-endpoint
                        // the top 2 answers are good, i prefer 2nd answer as it is explicit
                        // we can define restricted urls and permit everything else instead of the opposite white list
                        // or as i have done below being explicit as possible, define both
                        requestMatcherRegistry
                                .requestMatchers(ArrayUtils.addAll(USER_RESTRICTED_URLS, ADMIN_RESTRICTED_URLS))
                                .authenticated()
                                .requestMatchers(ArrayUtils.addAll(WHITE_LIST_URLS, API_DOCUMENTATION_URLS))
                                .permitAll()
                                .anyRequest()
                                .permitAll()
                )
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }
}