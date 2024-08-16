package vn.edu.hust.project.appledeviceservice.controller.web.v1;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.edu.hust.project.appledeviceservice.enitity.dto.request.CreateShippingInfoRequest;
import vn.edu.hust.project.appledeviceservice.enitity.dto.response.Resource;
import vn.edu.hust.project.appledeviceservice.service.IShippingInfoService;
import vn.edu.hust.project.appledeviceservice.service.IUserSecurityService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/web/api/v1/shipping_infos")
public class ShippingInfoWebController {
    private final IShippingInfoService shippingInfoService;
    private final IUserSecurityService userSecurityService;

    @PostMapping
    ResponseEntity<Resource> createShippingInfo(
            @RequestBody CreateShippingInfoRequest request) {
        request.setUserId(userSecurityService.getUserId());
        var shippingInfo = shippingInfoService.createShippingInfo(request);
        return ResponseEntity.ok(new Resource(shippingInfo));
    }
}
