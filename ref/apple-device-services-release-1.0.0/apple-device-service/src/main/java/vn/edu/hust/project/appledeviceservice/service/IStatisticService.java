package vn.edu.hust.project.appledeviceservice.service;

import vn.edu.hust.project.appledeviceservice.enitity.StatisticEntity;
import vn.edu.hust.project.appledeviceservice.enitity.dto.request.GetStatRequest;

public interface IStatisticService {
    StatisticEntity getAllStatistic(GetStatRequest request);
}
