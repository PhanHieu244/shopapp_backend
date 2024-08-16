package vn.edu.hust.project.appledeviceservice.controller.web.v1;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import vn.edu.hust.project.appledeviceservice.enitity.dto.response.Resource;
import vn.edu.hust.project.appledeviceservice.service.IWarrantyService;

@RestController
@RequestMapping("/web/api/v1/warranties")
@RequiredArgsConstructor
public class WarrantyWebController {
    private final IWarrantyService warrantyService;

    @GetMapping
    public ResponseEntity<Resource> getWarrantiesByOrderCode(@RequestParam (name = "order_code") String orderCode) {
        return ResponseEntity.ok(new Resource(warrantyService.getByOrderCode(orderCode)));
    }

}
