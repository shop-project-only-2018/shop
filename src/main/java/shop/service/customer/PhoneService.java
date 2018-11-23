package shop.service.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shop.dtos.customer.PhoneDto;
import shop.mappers.customer.PhoneMapper;
import shop.model.customer.Phone;
import shop.repository.customer.PhoneRepository;
import shop.service.message.Messages;
import shop.system.CheckedException;

import java.util.ArrayList;
import java.util.List;

@Service
public class PhoneService {

    private PhoneRepository repo;

    private PhoneMapper mapper;
    private Messages messages;

    @Autowired
    public void setMessages(Messages messages) {
        this.messages = messages;
    }

    @Autowired
    public void setRepo(PhoneRepository repo) {
        this.repo = repo;
    }

    @Autowired
    public void setMapper(PhoneMapper mapper) {
        this.mapper = mapper;
    }

    private Phone getById(Integer id) throws CheckedException {
        Phone phone = repo.findById(id).orElse(null);
        if (phone == null) {
            throw new CheckedException("error.unknown");
            // TODO: log id
        }
        return phone;
    }

    public void delete(Integer id) {
        repo.deleteById(id);
    }

    @Transactional(readOnly = true)
    public List<PhoneDto> getAll() {
        List<Phone> list = repo.findAll();
        List<PhoneDto> dtoList = new ArrayList<>();
        for (Phone phone : list) {
            PhoneDto dto = mapper.getDto(phone);
            dtoList.add(dto);
        }
        return dtoList;
    }

    @Transactional(readOnly = true)
    public PhoneDto getDtoById(Integer id) throws Exception {
        Phone phone = getById(id);
        PhoneDto orderDto = mapper.getDto(phone);
        return orderDto;
    }

    public Integer create(PhoneDto phoneDto) {
        Phone phone = mapper.getEntity(phoneDto);
        repo.saveAndFlush(phone);
        return phone.getId();
    }

//    public void update(PhoneDto dto) throws ResourceNotFoundException {
//        Phone phone = getById(dto.getPhoneId());
//        Phone updPhone = mapper.getEntity(dto);
//        phone = mapper.merge(phone, updPhone);
//        repo.saveAndFlush(phone);
//    }

}
