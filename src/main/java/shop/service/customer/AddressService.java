package shop.service.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shop.dtos.customer.AddressDto;
import shop.mappers.customer.AddressMapper;
import shop.model.customer.Address;
import shop.repository.customer.AddressRepository;
import shop.system.exceptions.ResourceNotFoundException;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressService {

    private AddressRepository repo;

    private AddressMapper mapper;

    @Autowired
    public void setRepo(AddressRepository repo) {
        this.repo = repo;
    }

    @Autowired
    public void setMapper(AddressMapper mapper) {
        this.mapper = mapper;
    }

    private Address getById(Integer id) throws ResourceNotFoundException {
        Address address = repo.findById(id).orElse(null);
        if (address == null) {
            throw new ResourceNotFoundException("Address id = " + id.toString());
        }
        return address;
    }

    public void delete(Integer id) {
        repo.deleteById(id);
    }

    @Transactional(readOnly = true)
    public List<AddressDto> getAll() {
        List<Address> list = repo.findAll();
        List<AddressDto> dtoList = new ArrayList<>();
        for (Address address : list) {
            AddressDto dto = mapper.getDto(address);
            dtoList.add(dto);
        }
        return dtoList;
    }

    @Transactional(readOnly = true)
    public AddressDto getDtoById(Integer id) throws ResourceNotFoundException {
        Address address = getById(id);
        if (address == null) {
            throw new ResourceNotFoundException();
        } else {
            AddressDto orderDto = mapper.getDto(address);
            return orderDto;
        }
    }

    public Integer create(AddressDto addressDto) {
        Address address = mapper.getEntity(addressDto);
        repo.saveAndFlush(address);
        return address.getId();
    }

    public void update(AddressDto dto) throws ResourceNotFoundException {
//        Address address = getById(dto.getAddressId());
//        Address updAddress = mapper.getEntity(dto);
//        address = mapper.merge(address, updAddress);
//        repo.saveAndFlush(address);
    }

}
