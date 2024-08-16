package vn.edu.hust.project.appledeviceservice.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import vn.edu.hust.project.appledeviceservice.enitity.OrderEntity;
import vn.edu.hust.project.appledeviceservice.enitity.dto.request.CreateOrderRequest;

@Mapper
public abstract class OrderResourceMapper {

    public static final OrderResourceMapper INSTANCE = Mappers.getMapper(OrderResourceMapper.class);

    public abstract OrderEntity createOrderFromRequest(CreateOrderRequest request);
}
