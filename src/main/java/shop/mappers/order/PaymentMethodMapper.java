package shop.mappers.order;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import shop.dtos.customer.OrganizationDto;
import shop.model.customer.Organization;

@Mapper
public interface PaymentMethodMapper {

    PaymentMethodMapper INSTANCE = Mappers.getMapper(PaymentMethodMapper.class);

    @Mappings({
            @Mapping(source = "paymentMethodId", target = "paymentMethodId"),
            @Mapping(source = "description", target = "description")
    })
    Organization getEntity(OrganizationDto personDto);

    @Mappings({
            @Mapping(source = "paymentMethodId", target = "paymentMethodId"),
            @Mapping(source = "description", target = "description")
    })
    OrganizationDto getDto(Organization person);

}
