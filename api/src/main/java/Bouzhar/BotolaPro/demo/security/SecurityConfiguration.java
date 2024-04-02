package Bouzhar.BotolaPro.demo.security;

import Bouzhar.BotolaPro.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

/**
 * Configuration class for Spring Security settings.
 * This class configures the security aspects of the application, including CORS settings,
 */
@Configuration
@RequiredArgsConstructor
public class SecurityConfiguration {

    private final UserRepository repository;

    private static final List<String> ALLOW_ORIGIN = List.of(
            "http://localhost:4200",
            "https://e044-197-230-250-154.ngrok-free.app"
    );
    private static final List<String> ALLOW_METHODS = List.of(
            "GET",
            "POST",
            "PUT",
            "DELETE",
            "OPTIONS"
    );
    private static final List<String> ALLOW_HEAD = List.of(
            "Access-Control-Allow-Origin",
            "Access-Control-Allow-Methods",
            "Access-Control-Allow-Headers",
            "Access-Control-Max-Age",
            "Access-Control-Request-Headers",
            "Access-Control-Request-Method",
            "Access-Control-Allow-Credentials",
            "Access-Control-Expose-Headers",
            "accept",
            "authorization",
            "content-type",
            "X-CSRF-TOKEN",
            "x-xsrf-token",
            "user-agent",
            "x-requested-with",
            "ngrok-skip-browser-warning",
            "Origin",
            "Cache-Control",
            "Content-Type",
            "Authorization",
            "Accept",
            "X-Requested-With"
    );


    /**
     * Creates and configures the CORS policy for the application.
     * This policy defines the allowed origins, HTTP methods, and headers for cross-origin requests.
     *
     * @return A CorsConfigurationSource object encapsulating the CORS configuration.
     */
    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(ALLOW_ORIGIN);
        configuration.setAllowedMethods(ALLOW_METHODS);
        configuration.setAllowedHeaders(ALLOW_HEAD);
        configuration.setAllowCredentials(true);
        configuration.setMaxAge(3600L);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    /**
     * Creates and configures the CSRF token repository.
     * This repository is responsible for storing and managing CSRF tokens,
     * using cookies as the storage mechanism.
     *
     */
    @Bean
    public CsrfTokenRepository csrfTokenRepository() {
        CookieCsrfTokenRepository repository = CookieCsrfTokenRepository.withHttpOnlyFalse();
        repository.setCookiePath("/");
        return repository;
    }

    /**
     * Creates a custom implementation of UserDetailsService to load user details by email.
     *
     * @return UserDetailsService implementation
     */
    @Bean
    public UserDetailsService userDetailsService() {
        return username -> repository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    /**
     * Configures and provides a custom AuthenticationProvider using DaoAuthenticationProvider.
     *
     * @return AuthenticationProvider
     */
    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    /**
     * Creates an instance of BCryptPasswordEncoder as the password encoder.
     *
     * @return PasswordEncoder
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


}
