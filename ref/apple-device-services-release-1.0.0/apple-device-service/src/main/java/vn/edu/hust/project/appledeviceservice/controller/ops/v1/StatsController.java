package vn.edu.hust.project.appledeviceservice.controller.ops.v1;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import vn.edu.hust.project.appledeviceservice.enitity.StatisticEntity;
import vn.edu.hust.project.appledeviceservice.enitity.dto.request.GetStatRequest;
import vn.edu.hust.project.appledeviceservice.enitity.dto.response.Resource;
import vn.edu.hust.project.appledeviceservice.service.IStatisticService;
import vn.edu.hust.project.appledeviceservice.utils.TimeUtils;

@RestController
@RequiredArgsConstructor
@RequestMapping("/ops/api/v1/stats")
public class StatsController {
    private final IStatisticService statisticService;

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/all")
    public ResponseEntity<Resource> getAllStatistic(
            @RequestParam(required = false, name = "order_date_from") Long orderDateFrom,
            @RequestParam(required = false, name = "order_date_to") Long orderDateTo
    ) {

        var filter = new GetStatRequest();
        filter.setOrderDateFrom(orderDateFrom);
        filter.setOrderDateTo(orderDateTo);


        StatisticEntity statisticEntity = statisticService.getAllStatistic(filter);
        return ResponseEntity.ok(new Resource(statisticEntity));
    }

    @GetMapping("/date")
    public ResponseEntity<Resource> getAllStatisticByDate(

    ) {

        var filter = new GetStatRequest();
        filter.setOrderDateFrom(TimeUtils.convertLocalDateTimeToUnixTime(TimeUtils.getStartOfToday()));
        filter.setOrderDateTo(TimeUtils.convertLocalDateTimeToUnixTime(TimeUtils.getEndOfToday()));


        StatisticEntity statisticEntity = statisticService.getAllStatistic(filter);
        return ResponseEntity.ok(new Resource(statisticEntity));
    }
}
