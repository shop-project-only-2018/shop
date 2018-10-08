package shop.service.order;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.dtos.order.StatusDto;
import shop.dtos.order.mappers.StatusMapper;
import shop.model.order.Status;
import shop.repository.customer.CustomerRepository;
import shop.repository.order.OrderRepository;
import shop.repository.order.PaymentMethodRepository;
import shop.repository.order.StatusRepository;

@Service
public class OrderService {

    final static Logger logger = Logger.getLogger(OrderService.class);

    @Autowired
    public OrderRepository orderRepository;

    @Autowired
    public CustomerRepository customerRepository;

    @Autowired
    public PaymentMethodRepository paymentMethodRepository;

    @Autowired
    public StatusRepository statusRepository;

    public boolean save(StatusDto statusDto) {
        Status status = StatusMapper.INSTANCE.statusDtoToStatus(statusDto);
        statusRepository.save(status);
        return true;
    }

    public StatusDto getById(Integer id) {
        if (id == null) {
            logger.fatal("getById(): id is null");
        }
        Status status = null;
        try {
            status = statusRepository.findById(id).orElse(null);
        } catch (javax.persistence.EntityNotFoundException e) {
            return null;
        }
        StatusDto statusDto = StatusMapper.INSTANCE.statusToStatusDto(status);
        if (status == null || statusDto == null) {
            return null;
        }
        return statusDto;
    }
}
