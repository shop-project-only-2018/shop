package shop.mappers.order;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import shop.dtos.order.PaymentMethodDto;
import shop.model.order.PaymentMethod;

@Mapper(componentModel = "spring")
public interface PaymentMethodMapper {

    @Mappings({
            @Mapping(source = "paymentMethodId", target = "paymentMethodId"),
            @Mapping(source = "description", target = "description")
    })
    PaymentMethod getEntity(PaymentMethodDto paymentMethodDto);

    @Mappings({
            @Mapping(source = "paymentMethodId", target = "paymentMethodId"),
            @Mapping(source = "description", target = "description")
    })
    PaymentMethodDto getDto(PaymentMethod paymentMethod);

}
