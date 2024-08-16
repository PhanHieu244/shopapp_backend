package vn.edu.hust.project.appledeviceservice.controller.web.v1;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import vn.edu.hust.project.appledeviceservice.enitity.dto.request.CreateOrderRequest;
import vn.edu.hust.project.appledeviceservice.enitity.dto.request.GetOrderRequest;
import vn.edu.hust.project.appledeviceservice.enitity.dto.response.MetaDataWithTotalRecord;
import vn.edu.hust.project.appledeviceservice.enitity.dto.response.Resource;
import vn.edu.hust.project.appledeviceservice.service.IOrderService;
import vn.edu.hust.project.appledeviceservice.service.IUserSecurityService;

@RestController
@RequestMapping("/web/api/v1/orders")
@RequiredArgsConstructor
public class OrderWebController {
    private final IOrderService orderService;

    private final IUserSecurityService userSecurityService;

    public static final String DEFAULT_PAGE = "0";
    public static final String DEFAULT_PAGE_SIZE = "10";

    @GetMapping
    public ResponseEntity<Resource> getAllOrder(
            @RequestParam(defaultValue = DEFAULT_PAGE, name = "page") Long page,
            @RequestParam(defaultValue = DEFAULT_PAGE_SIZE, name = "page_size") Long pageSize,
            @RequestParam(required = false, name = "status") String status
    ) {
        var filter = new GetOrderRequest();
        filter.setPage(page);
        filter.setPageSize(pageSize);
        filter.setState(status);
        filter.setUserId(userSecurityService.getUserId());

        var result = orderService.getAllOrder(filter);
        var pageInfo = result.getFirst();

        var metaData = new MetaDataWithTotalRecord(pageInfo.getTotalRecord(), pageInfo.getPageSize(),
                pageInfo.getTotalPage(), pageInfo.getNextPage(), pageInfo.getPreviousPage());

        var resource = new Resource(result.getSecond(), metaData);

        return ResponseEntity.ok(resource);
    }

    @PostMapping
    public ResponseEntity<Resource> createOrder(
            @RequestBody CreateOrderRequest request
    ) {
        request.setUserId(userSecurityService.getUserId());
        return ResponseEntity.ok(new Resource(orderService.createOrder(request)));
    }

    @PatchMapping
    public ResponseEntity<Resource> confirmOrder(
            @RequestParam(name = "order_id") Long orderId
    ) {
        orderService.cancelOrderWeb(orderId, userSecurityService.getUserId());
        return ResponseEntity.ok(new Resource(null));
    }

    @GetMapping("/{order_id}")
    public ResponseEntity<Resource> getOrderDetail(
            @PathVariable(name = "order_id") Long orderId
    ) {

        return ResponseEntity.ok(new Resource(orderService.getOrderByIdAndUserID(orderId, userSecurityService.getUserId())));
    }

}
