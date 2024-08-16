package vn.edu.hust.project.appledeviceservice.controller.ops.v1;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.edu.hust.project.appledeviceservice.enitity.dto.request.LoginRequest;
import vn.edu.hust.project.appledeviceservice.enitity.dto.request.CreateUserRequest;
import vn.edu.hust.project.appledeviceservice.enitity.dto.response.Resource;
import vn.edu.hust.project.appledeviceservice.service.IUserService;

@RestController
@RequestMapping("/ops/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final IUserService userService;

    @PostMapping("/sign-up")
    public ResponseEntity<Resource> createUser(
            @RequestBody CreateUserRequest request
    ) {
        return ResponseEntity.ok(
                new Resource(userService.sigUpOps(request))
        );
    }

    @PostMapping("/login")
    public ResponseEntity<Resource> login(
            @RequestBody LoginRequest request
    ) {
        return ResponseEntity.ok(
                new Resource(userService.loginOps(request))
        );
    }

}
