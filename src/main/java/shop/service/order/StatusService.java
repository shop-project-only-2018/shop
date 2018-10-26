package shop.service.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.dtos.order.StatusDto;
import shop.mappers.order.StatusMapper;
import shop.model.order.Status;
import shop.repository.order.StatusRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class StatusService {

    @Autowired
    public StatusRepository statusRepository;

    @Autowired
    private StatusMapper mapper;

    public boolean save(StatusDto statusDto) {
        Status status = mapper.getEntity(statusDto);
        statusRepository.save(status);
        return true;
    }

    public StatusDto getById(Integer id) {
//        if (id == null) {
//            logger.fatal("getById(): id is null");
//        }
        Status status = null;
        try {
            status = statusRepository.findById(id).orElse(null);
        } catch (javax.persistence.EntityNotFoundException e) {
            return null;
        }
        StatusDto statusDto = mapper.getDto(status);
        if (status == null || statusDto == null) {
            return null;
        }
        return statusDto;
    }

    public List<StatusDto> getAll() {
        List<Status> statusList = statusRepository.findAll();
        List<StatusDto> statusDtoList = new ArrayList<>();
        for (Status status : statusList) {
            StatusDto statusDto = mapper.getDto(status);
            statusDtoList.add(statusDto);
        }
        return statusDtoList;
    }

    public boolean delete(StatusDto statusDto) {
        return delete(statusDto.getId());
    }

    public boolean delete(Integer id) {
        Status status = null;
        status = statusRepository.findById(id).orElse(null);
        if (status != null) {
            statusRepository.delete(status);
            return true;
        } else {
            return false;
        }
    }
}
