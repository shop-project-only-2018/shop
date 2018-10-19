package shop.dtos.order.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import shop.dtos.order.OrderDto;
import shop.model.order.Order;

@Mapper
public interface OrderMapper {

    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    @Mappings({
            @Mapping(source = "id", target = "orderId")
    })
    Order orderDtoToOrder(OrderDto orderDto);

    @Mappings({
            @Mapping(source = "orderId", target = "id")
    })
    OrderDto orderToOrderDto(Order order);
}
