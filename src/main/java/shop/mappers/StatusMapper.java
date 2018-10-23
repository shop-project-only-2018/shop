package shop.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import shop.dtos.order.StatusDto;
import shop.model.order.Status;

@Mapper
public interface StatusMapper {

    StatusMapper INSTANCE = Mappers.getMapper(StatusMapper.class);

    @Mappings({
            @Mapping(source = "status", target = "status"),
            @Mapping(source = "id", target = "statusId", defaultValue = "0")
    })
    Status getStatus(StatusDto statusDto);

    @Mappings({
            @Mapping(source = "status", target = "status"),
            @Mapping(source = "statusId", target = "id", defaultValue = "0")
    })
    StatusDto getDto(Status status);

}
