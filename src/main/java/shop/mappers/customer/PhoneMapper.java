package shop.mappers.customer;


import org.mapstruct.Mapper;
import shop.dtos.customer.CustomerDto;
import shop.dtos.customer.PhoneDto;
import shop.model.customer.Customer;
import shop.model.customer.Phone;

@Mapper(componentModel = "spring")
public interface PhoneMapper {
    Phone getEntity(PhoneDto dto);
    PhoneDto getDto(Phone entity);}
