package shop.dtos.customer.mappers;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import shop.dtos.customer.CustomerDto;
import shop.dtos.order.StatusDto;
import shop.model.customer.Customer;
import shop.model.order.Status;

@Mapper
public interface CustomerMapper {

    CustomerMapper INSTANCE = Mappers.getMapper( CustomerMapper.class );

    @Mapping(source = "id", target = "customerId")
    Customer statusDtoToStatus(CustomerDto statusDto);

    @Mapping(source = "customerId", target = "id")
    CustomerDto statusToStatusDto(Customer customer);

}
