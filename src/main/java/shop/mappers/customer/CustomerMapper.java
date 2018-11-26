package shop.mappers.customer;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import shop.dtos.customer.CreateUpdateCustomerDto;
import shop.dtos.customer.CustomerDto;
import shop.dtos.security.LoginDTO;
import shop.mappers.util.CustomerURIMapper;
import shop.model.customer.Customer;

@Mapper(uses = {CustomerURIMapper.class}, componentModel = "spring")
public interface CustomerMapper {
    Customer getEntity(CustomerDto dto);

    @Mappings({
            @Mapping(target = "username", source = "username"),
            @Mapping(target = "password", source = "password"),
            @Mapping(target = "firstName", source = "firstName"),
            @Mapping(target = "lastName", source = "lastName")})
    Customer getEntity(CreateUpdateCustomerDto dto);

    CustomerDto getDto(Customer entity);

    @Mappings({
            @Mapping(target = "username", source = "username"),
            @Mapping(target = "userURI", source = "customerId")})
    LoginDTO toAuthDTO(Customer customer);
}
