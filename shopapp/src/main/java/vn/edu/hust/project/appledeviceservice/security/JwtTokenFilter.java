package vn.edu.hust.project.appledeviceservice.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import jakarta.servlet.FilterChain;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import vn.edu.hust.project.appledeviceservice.enitity.dto.response.Resource;
import vn.edu.hust.project.appledeviceservice.exception.UnauthorizedException;
import vn.edu.hust.project.appledeviceservice.property.RequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
@Slf4j
public class JwtTokenFilter extends OncePerRequestFilter {

    private final RequestFilter requestFilter;

    private final UserDetailsService userDetailsService;

    private final JwtTokenUtil jwtTokenUtil;


    @Override
    @SneakyThrows
    protected void doFilterInternal(
        @NonNull HttpServletRequest request,
        @NonNull HttpServletResponse response,
        @NonNull FilterChain filterChain) {
        try {
            if (isByPassToken(request)) {
                filterChain.doFilter(request, response);
                return;
            }
            final String authorizationHeader = request.getHeader("Authorization");
            if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")
                && authorizationHeader.length() > 7) {
                final var token = authorizationHeader.substring(7);
                final var email = jwtTokenUtil.extractEmail(token);

                if (email != null
                    && SecurityContextHolder.getContext().getAuthentication() == null) {
                    var existingUser = (CustomUserDetails) userDetailsService.loadUserByUsername(email);

                    if (jwtTokenUtil.validateToken(token, existingUser)) {
                        var authentication = new UsernamePasswordAuthenticationToken(
                            existingUser, null, existingUser.getAuthorities()
                        );
                        authentication.setDetails(
                            new WebAuthenticationDetailsSource().buildDetails(request));
                        SecurityContextHolder.getContext().setAuthentication(authentication);
                    }
                }
                filterChain.doFilter(request, response);
                return;
            }
            throw new UnauthorizedException();

        } catch (Exception ex) {
            log.error("[JwtTokenFilter] token filter error: {}", ex.getMessage());
            setUnauthorizedResponse(response);
        }


    }

    private void setUnauthorizedResponse(HttpServletResponse response) throws IOException {
        var responseEntity = ResponseEntity.status(HttpStatus.UNAUTHORIZED)
            .body(new Resource((long) HttpStatus.UNAUTHORIZED.value(), "Unauthorized"));
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        response.setStatus(responseEntity.getStatusCodeValue());
        response.getWriter().write(mapper.writeValueAsString(responseEntity.getBody()));
    }

    private boolean isByPassToken(
        @NonNull HttpServletRequest request
    ) {

        var bypassToken = requestFilter.getPublicUrls();
        ;
        for (var byPassToken : bypassToken) {
            if (request.getRequestURI().matches(byPassToken.getFirst()) && request.getMethod()
                .equals(byPassToken.getSecond())) {
                return true;
            }
        }
        return false;
    }
}
