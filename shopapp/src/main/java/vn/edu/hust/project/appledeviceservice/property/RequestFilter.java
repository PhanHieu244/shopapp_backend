package vn.edu.hust.project.appledeviceservice.property;

import java.util.List;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.util.Pair;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "app.security.filter")
public class RequestFilter {
    List<Pair<String, String>> publicUrls;

    List<ProtectedUrls> protectedUrls;

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    public static class ProtectedUrls{
        private String urlPattern;
        private List<String> roles;
    }

}
