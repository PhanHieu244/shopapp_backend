package vn.edu.hust.project.appledeviceservice.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import vn.edu.hust.project.appledeviceservice.enitity.DistrictEntity;
import vn.edu.hust.project.appledeviceservice.enitity.ProvinceEntity;
import vn.edu.hust.project.appledeviceservice.enitity.ShippingInfoEntity;
import vn.edu.hust.project.appledeviceservice.enitity.WardEntity;
import vn.edu.hust.project.appledeviceservice.enitity.dto.request.CreateShippingInfoRequest;
import vn.edu.hust.project.appledeviceservice.enitity.dto.request.DistrictRequest;
import vn.edu.hust.project.appledeviceservice.enitity.dto.request.ProvinceRequest;
import vn.edu.hust.project.appledeviceservice.enitity.dto.request.WardRequest;

@Mapper
public abstract class ShippingInfoResourceMapper {
    public static final ShippingInfoResourceMapper INSTANCE = Mappers.getMapper(ShippingInfoResourceMapper.class);
    @Mapping(target = "receivedName", source = "fullName")
    @Mapping(target = "phone", source = "phoneNumber")
    public abstract ShippingInfoEntity toEntityFromRequest(CreateShippingInfoRequest request);

    public abstract ProvinceEntity toEntityFromRequest(ProvinceRequest request);

    public abstract DistrictEntity toEntityFromRequest(DistrictRequest request);

    public abstract WardEntity toEntityFromRequest(WardRequest request);

}
