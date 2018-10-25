package shop.util;

import shop.dtos.customer.CustomerDto;
import shop.dtos.customer.OrganizationDto;
import shop.dtos.customer.PersonDto;
import shop.dtos.order.OrderDto;
import shop.dtos.order.StatusDto;
import shop.dtos.product.CategoryDto;
import shop.mappers.OrganizationMapper;
import shop.mappers.PersonMapper;
import shop.mappers.StatusMapper;
import shop.mappers.product.CategoryMapper;
import shop.model.customer.Customer;
import shop.model.customer.Organization;
import shop.model.customer.Person;
import shop.model.order.Order;
import shop.model.order.Status;
import shop.model.product.Category;
import shop.system.exceptions.EntityMappingException;

/**
 * All the mappers in one place
 * <p>
 * Every mapping should have getDto() and getEntity() methods.
 * Some mappings may have a merge() method.
 */
public class Mapper {
    //
    // Mapstruct mappings
    //

    public static PersonDto getDto(Person entity) {
        return PersonMapper.INSTANCE.getDto(entity);
    }

    public static Organization getEntity(OrganizationDto dto) {
        return OrganizationMapper.INSTANCE.getEntity(dto);
    }

    public static OrganizationDto getDto(Organization entity) {
        return OrganizationMapper.INSTANCE.getDto(entity);
    }

    public static Person getEntity(PersonDto dto) {
        return PersonMapper.INSTANCE.getEntity(dto);
    }

    public static Status getEntity(StatusDto statusDto) {
        return StatusMapper.INSTANCE.getStatus(statusDto);
    }

    public static StatusDto getDto(Status status) {
        return StatusMapper.INSTANCE.getDto(status);
    }

    public static Category getEntity(CategoryDto categoryDTO) { return CategoryMapper.INSTANCE.getEntity(categoryDTO);
    }

    public static CategoryDto getDto(Category category) {
        return CategoryMapper.INSTANCE.getDto(category);
    }

    //
    // Custom mappings
    //

    public static CustomerDto getDto(Customer customer) throws EntityMappingException {

        CustomerDto customerDto = new CustomerDto();

        if (customer.getPerson() != null) {
            PersonDto personDto = getDto(customer.getPerson());
            customerDto.setPersonDto(personDto);
        } else if (customer.getOrganization() != null) {
            OrganizationDto organizationDto = getDto(customer.getOrganization());
            customerDto.setOrganizationDto(organizationDto);
        } else {
            throw new EntityMappingException("Customer №" + customer.getId().toString()
                    + " is neither a person nor an organization, which is impossible");
        }


        return customerDto;
    }

    public static Customer getEntity(CustomerDto dto) {
        Customer customer = new Customer();
        // !!!

        return customer;
    }

    public static OrderDto getDto(Order order) {
        return new OrderDto();
    }

    public static Order getEntity(OrderDto orderDto) {
        return new Order();
    }

}
