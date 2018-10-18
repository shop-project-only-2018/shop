package shop.util;

import shop.dtos.order.OrderDto;
import shop.dtos.order.mappers.OrderMapper;
import shop.model.order.Order;

/**
 * All the mappers in one place
 */
public class Mapper {

    public static OrderDto getDto(Order order){
        return OrderMapper.INSTANCE.orderToOrderDto(order);
    }
    public static Order getEntity(OrderDto orderDto){
        return OrderMapper.INSTANCE.orderDtoToOrder(orderDto);
    }

}
