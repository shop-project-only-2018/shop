package shop.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import shop.dtos.customer.OrganizationDto;
import shop.model.customer.Organization;

@Mapper
public interface OrganizationMapper {

    OrganizationMapper INSTANCE = Mappers.getMapper(OrganizationMapper.class);

    @Mappings({
            @Mapping(source = "name", target = "name")
    })
    Organization getEntity(OrganizationDto personDto);

    @Mappings({
            @Mapping(source = "name", target = "name")
    })
    OrganizationDto getDto(Organization person);

}
