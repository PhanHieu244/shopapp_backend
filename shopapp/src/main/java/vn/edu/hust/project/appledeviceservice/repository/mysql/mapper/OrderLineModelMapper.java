package vn.edu.hust.project.appledeviceservice.repository.mysql.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;
import org.springframework.util.StringUtils;
import vn.edu.hust.project.appledeviceservice.enitity.OrderLineEntity;
import vn.edu.hust.project.appledeviceservice.repository.mysql.model.OrderLineModel;

import java.util.List;
import vn.edu.hust.project.appledeviceservice.utils.RandomStringUtils;

@Mapper
public abstract class OrderLineModelMapper {
    public static final OrderLineModelMapper INSTANCE = Mappers.getMapper(OrderLineModelMapper.class);

    @Mapping(target = "code", source = "code", qualifiedByName = "createOrderLineCode")
    public abstract OrderLineModel toModel(OrderLineEntity entity);

    public abstract OrderLineEntity toEntity(OrderLineModel model);

    public abstract List<OrderLineModel> toModels(List<OrderLineEntity> entities);

    public abstract List<OrderLineEntity> toEntities(List<OrderLineModel> models);

    @Named("createOrderLineCode")
    public String createOrderLineCode(String code){
        if(StringUtils.hasLength(code)){
            return code;
        }
        return RandomStringUtils.generateRandomString();
    }
}
