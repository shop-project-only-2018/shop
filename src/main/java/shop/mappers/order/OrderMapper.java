package shop.mappers.order;

import org.mapstruct.Mapper;
import shop.dtos.order.OrderDto;
import shop.model.order.Order;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    Order getEntity(OrderDto orderDto);

    OrderDto getDto(Order order);
}
