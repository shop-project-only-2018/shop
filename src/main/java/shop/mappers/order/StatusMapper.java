package shop.mappers.order;

import org.mapstruct.Mapper;
import shop.dtos.order.StatusDto;
import shop.model.order.Status;

@Mapper(componentModel = "spring")
public interface StatusMapper {
    Status getEntity(StatusDto statusDto);
    StatusDto getDto(Status status);}
