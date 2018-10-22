package shop.dtos.customer.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import shop.dtos.customer.CustomerDto;
import shop.model.customer.Customer;

@Mapper
public interface CustomerMapper {

    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    @Mapping(source = "id", target = "customerId")
    Customer customerDtoToCustomer(CustomerDto customerDto);

    @Mappings({
//            @Mapping(source = "customerId", target = "id"),
            @Mapping(source = "customerId", target = "id")
    })
    CustomerDto customerToCustomerDto(Customer customer);

}
