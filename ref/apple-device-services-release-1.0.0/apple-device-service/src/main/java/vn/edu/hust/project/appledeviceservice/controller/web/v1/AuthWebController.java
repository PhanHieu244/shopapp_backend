package vn.edu.hust.project.appledeviceservice.controller.web.v1;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.edu.hust.project.appledeviceservice.enitity.dto.request.CreateUserWebRequest;
import vn.edu.hust.project.appledeviceservice.enitity.dto.request.LoginRequest;
import vn.edu.hust.project.appledeviceservice.enitity.dto.response.Resource;
import vn.edu.hust.project.appledeviceservice.service.IUserService;

@RestController
@RequestMapping("/web/api/v1/auth")
@RequiredArgsConstructor
public class AuthWebController {

    private final IUserService userService;

    @PostMapping("/sign-up")
    public ResponseEntity<Resource> createUser(
            @RequestBody CreateUserWebRequest request
    ) {
        return ResponseEntity.ok(
                new Resource(userService.signUpWeb(request))
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
