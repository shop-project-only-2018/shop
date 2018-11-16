package shop.mappers.customer;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import shop.dtos.customer.CustomerDto;
import shop.dtos.security.LoginDTO;
import shop.mappers.util.CustomerURIMapper;
import shop.model.customer.Customer;

@Mapper(uses = {CustomerURIMapper.class}, componentModel = "spring")
public interface CustomerMapper {
    Customer getEntity(CustomerDto dto);

    CustomerDto getDto(Customer entity);

    @Mapping(target = "userURI", source = "customerId")
    LoginDTO toAuthDTO(Customer customer);}
