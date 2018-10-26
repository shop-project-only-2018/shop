package shop.mappers.order;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import shop.dtos.order.StatusDto;
import shop.model.order.Status;

@Mapper(componentModel = "spring")
public interface StatusMapper {

    @Mappings({
            @Mapping(source = "status", target = "status"),
            @Mapping(source = "id", target = "statusId", defaultValue = "0")
    })
    Status getEntity(StatusDto statusDto);

    @Mappings({
            @Mapping(source = "status", target = "status"),
            @Mapping(source = "statusId", target = "id", defaultValue = "0")
    })
    StatusDto getDto(Status status);

}
