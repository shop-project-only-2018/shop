package shop.service.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shop.dtos.order.PaymentMethodDto;
import shop.mappers.order.PaymentMethodMapper;
import shop.model.order.PaymentMethod;
import shop.repository.order.PaymentMethodRepository;
import shop.system.exceptions.ResourceNotFoundException;

import java.util.ArrayList;
import java.util.List;

@Service
public class PaymentMethodService {

    private PaymentMethodRepository repo;

    private PaymentMethodMapper mapper;

    @Autowired
    public void setRepo(PaymentMethodRepository repo) {
        this.repo = repo;
    }

    @Autowired
    public void setMapper(PaymentMethodMapper mapper) {
        this.mapper = mapper;
    }

    private PaymentMethod getById(Integer id) throws ResourceNotFoundException {
        PaymentMethod paymentMethod = repo.findById(id).orElse(null);
        if (paymentMethod == null) {
            throw new ResourceNotFoundException("PaymentMethod id = " + id.toString());
        }
        return paymentMethod;
    }

    public void delete(Integer id) {
        repo.deleteById(id);
    }

    @Transactional(readOnly = true)
    public List<PaymentMethodDto> getAll() {
        List<PaymentMethod> list = repo.findAll();
        List<PaymentMethodDto> dtoList = new ArrayList<>();
        for (PaymentMethod paymentMethod : list) {
            PaymentMethodDto dto = mapper.getDto(paymentMethod);
            dtoList.add(dto);
        }
        return dtoList;
    }

    @Transactional(readOnly = true)
    public PaymentMethodDto getDtoById(Integer id) throws ResourceNotFoundException {
        PaymentMethod paymentMethod = getById(id);
        if (paymentMethod == null) {
            throw new ResourceNotFoundException();
        } else {
            PaymentMethodDto orderDto = mapper.getDto(paymentMethod);
            return orderDto;
        }
    }

    public Integer create(PaymentMethodDto paymentMethodDto) {
        PaymentMethod paymentMethod = mapper.getEntity(paymentMethodDto);
        repo.saveAndFlush(paymentMethod);
        return paymentMethod.getId();
    }

    public void update(PaymentMethodDto dto) throws ResourceNotFoundException {
//        PaymentMethod paymentMethod = getById(dto.getPaymentMethodId());
//        PaymentMethod updPaymentMethod = mapper.getEntity(dto);
//        paymentMethod = mapper.merge(paymentMethod, updPaymentMethod);
//        repo.saveAndFlush(paymentMethod);
    }

}
