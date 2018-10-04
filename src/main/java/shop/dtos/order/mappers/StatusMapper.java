package shop.dtos.order.mappers;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import shop.dtos.order.StatusDto;
import shop.model.order.Status;

@Mapper
public interface StatusMapper {

    StatusMapper INSTANCE = Mappers.getMapper( StatusMapper.class );

    @Mapping(source = "status", target = "status")
    Status statusDtoToStatus(StatusDto statusDto);

    @Mapping(source = "status", target = "status")
    StatusDto statusToStatusDto(Status status);

}
