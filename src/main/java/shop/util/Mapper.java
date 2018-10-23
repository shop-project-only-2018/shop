package shop.util;

import shop.dtos.customer.CustomerDto;
import shop.dtos.customer.OrganizationDto;
import shop.dtos.customer.PersonDto;
import shop.dtos.order.OrderDto;
import shop.dtos.order.mappers.OrderMapper;
import shop.model.customer.Customer;
import shop.model.order.Order;
import shop.system.exceptions.EntityMappingException;

/**
 * All the mappers in one place
 * <p>
 * Every mapping should have getDto() and getEntity() methods.
 * Some mappings may have a merge() method.
 */
public class Mapper {

    public static OrderDto getDto(Order entity) {
        return OrderMapper.INSTANCE.orderToOrderDto(entity);
    }

    public static Order getEntity(OrderDto dto) {
        return OrderMapper.INSTANCE.orderDtoToOrder(dto);
    }

    public static CustomerDto getDto(Customer entity) throws EntityMappingException {
        CustomerDto customerDto = new CustomerDto();
        if (entity.getPerson() != null) {
            PersonDto personDto = new PersonDto();
            personDto.setFirstName(entity.getPerson().getFirstName());
            personDto.setLastName(entity.getPerson().getLastName());
            customerDto.setPersonDto(personDto);
        } else if (entity.getOrganization() != null) {
            OrganizationDto organizationDto = new OrganizationDto();
            organizationDto.setOrganizationName(entity.getOrganization().getName());
            customerDto.setOrganizationDto(organizationDto);
        } else {
            throw new EntityMappingException("Customer №" + entity.getId().toString()
                    + " is neither a person nor an organization, which is impossible");
        }
        // !!!

        return customerDto;
    }

    public static Customer getEntity(CustomerDto dto) {
        Customer customer = new Customer();
        // !!!

        return customer;
    }

}
