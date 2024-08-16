package vn.edu.hust.project.appledeviceservice.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@ConfigurationProperties(prefix = "app.service.cors")
@Getter
@Setter
public class CorsProperties {
    private String baseUrl;
    private List<String> allowedMethods;
}
