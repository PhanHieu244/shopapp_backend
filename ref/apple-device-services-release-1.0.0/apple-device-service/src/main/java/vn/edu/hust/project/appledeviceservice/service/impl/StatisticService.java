package vn.edu.hust.project.appledeviceservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import vn.edu.hust.project.appledeviceservice.enitity.StatisticEntity;
import vn.edu.hust.project.appledeviceservice.enitity.dto.request.GetStatRequest;
import vn.edu.hust.project.appledeviceservice.port.IOrderPort;
import vn.edu.hust.project.appledeviceservice.service.IStatisticService;
import vn.edu.hust.project.appledeviceservice.usecase.GetStatisticUseCase;

@Service
@RequiredArgsConstructor
public class StatisticService implements IStatisticService {
    private final GetStatisticUseCase getStatisticUseCase;

    @Override
    public StatisticEntity getAllStatistic(GetStatRequest request) {

        return getStatisticUseCase.getAllStatics(request);
    }
}
