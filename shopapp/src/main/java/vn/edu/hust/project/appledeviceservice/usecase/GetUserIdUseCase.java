package vn.edu.hust.project.appledeviceservice.usecase;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import vn.edu.hust.project.appledeviceservice.exception.BadRequestException;
import vn.edu.hust.project.appledeviceservice.security.CustomUserDetails;

@Service
@RequiredArgsConstructor
@Slf4j
public class GetUserIdUseCase {

    public Long getUserId() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof CustomUserDetails) {
            return ((CustomUserDetails) principal).getUserEntity().getId();
        }
        log.error("[GetUseIdUseCase] cannot get user id");
        throw new BadRequestException();
    }
}
