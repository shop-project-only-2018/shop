package shop.mappers.customer;


import org.mapstruct.Mapper;
import shop.dtos.customer.AddressDto;
import shop.model.customer.Address;

@Mapper(componentModel = "spring")
public interface AddressMapper {
    Address getEntity(AddressDto dto);

    AddressDto getDto(Address entity);
}