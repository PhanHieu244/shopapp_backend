package vn.edu.hust.project.appledeviceservice.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import vn.edu.hust.project.appledeviceservice.port.IRolePort;
import vn.edu.hust.project.appledeviceservice.port.IUserPort;
import vn.edu.hust.project.appledeviceservice.security.CustomUserDetails;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {

    private final IUserPort userPort;

    private final IRolePort rolePort;

    //user's detail object
    @Bean
    public UserDetailsService userDetailsService() {
        return email -> {
            var user = userPort.getUserByEmail(email);
            return new CustomUserDetails(user, userPort, rolePort);
        };
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        var authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService());
        authenticationProvider.setPasswordEncoder(passwordEncoder());

        return authenticationProvider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config)
            throws Exception {
        return config.getAuthenticationManager();
    }
}
