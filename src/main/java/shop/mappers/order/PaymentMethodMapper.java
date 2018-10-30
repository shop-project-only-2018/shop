package shop.mappers.order;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import shop.dtos.order.PaymentMethodDto;
import shop.model.order.PaymentMethod;

@Mapper(componentModel = "spring")
public interface PaymentMethodMapper {
    PaymentMethod getEntity(PaymentMethodDto paymentMethodDto);
    PaymentMethodDto getDto(PaymentMethod paymentMethod);}
