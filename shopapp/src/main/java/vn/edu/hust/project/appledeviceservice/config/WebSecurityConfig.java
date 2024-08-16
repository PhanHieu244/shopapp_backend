package vn.edu.hust.project.appledeviceservice.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import vn.edu.hust.project.appledeviceservice.property.RequestFilter;
import vn.edu.hust.project.appledeviceservice.security.JwtTokenFilter;

@Configuration
@EnableMethodSecurity
@RequiredArgsConstructor
public class WebSecurityConfig {

    private final RequestFilter requestFilter;

    private final JwtTokenFilter jwtTokenFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .cors(Customizer.withDefaults())
                .csrf(AbstractHttpConfigurer::disable)
                .addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter.class)
                .authorizeHttpRequests(requests -> {
                    requestFilter.getPublicUrls().forEach(url -> {
                        requests.requestMatchers(url.getFirst()).permitAll();
                    });
                    requestFilter.getProtectedUrls().forEach(url -> {
                        requests.requestMatchers(url.getUrlPattern()).hasAnyRole(url.getRoles().toArray(new String[0]))
                                ;
                    });

                    requests.anyRequest().authenticated();
                });
        return http.build();
    }
}
