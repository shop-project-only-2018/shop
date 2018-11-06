package shop.mappers.customer;


import org.mapstruct.Mapper;
import shop.dtos.customer.AddressDto;
import shop.dtos.customer.CustomerDto;
import shop.model.customer.Address;
import shop.model.customer.Customer;

@Mapper(componentModel = "spring")
public interface AddressMapper {
    Address getEntity(AddressDto dto);
    AddressDto getDto(Address entity);}