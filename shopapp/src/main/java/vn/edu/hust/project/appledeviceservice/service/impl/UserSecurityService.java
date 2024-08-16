package vn.edu.hust.project.appledeviceservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import vn.edu.hust.project.appledeviceservice.service.IUserSecurityService;
import vn.edu.hust.project.appledeviceservice.usecase.GetUserIdUseCase;

@Service
@RequiredArgsConstructor
public class UserSecurityService implements IUserSecurityService {
    private final GetUserIdUseCase getUserIdUseCase;
    @Override
    public Long getUserId() {
        return getUserIdUseCase.getUserId();
    }
}
