package shop.mappers.order;

import org.mapstruct.Mapper;
import shop.dtos.order.OrderItemDto;
import shop.model.order.OrderItem;

@Mapper(componentModel = "spring")
public interface OrderItemMapper {
    OrderItem getEntity(OrderItemDto orderItemDto);

    OrderItemDto getDto(OrderItem orderItem);
}
