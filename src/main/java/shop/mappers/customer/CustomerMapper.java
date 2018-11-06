package shop.mappers.customer;


import org.mapstruct.Mapper;
import shop.dtos.customer.CustomerDto;
import shop.model.customer.Customer;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    Customer getEntity(CustomerDto dto);
    CustomerDto getDto(Customer entity);}
