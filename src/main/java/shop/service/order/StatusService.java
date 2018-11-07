package shop.service.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shop.dtos.order.StatusDto;
import shop.mappers.order.StatusMapper;
import shop.model.order.Status;
import shop.repository.order.StatusRepository;
import shop.system.exceptions.ResourceNotFoundException;

import java.util.ArrayList;
import java.util.List;

@Service
public class StatusService {

    private StatusRepository repo;
    private StatusMapper mapper;

    @Autowired
    public void setRepo(StatusRepository repo) {
        this.repo = repo;
    }

    @Autowired
    public void setMapper(StatusMapper mapper) {
        this.mapper = mapper;
    }

    private Status getById(Integer id) throws ResourceNotFoundException {
        Status status = repo.findById(id).orElse(null);
        if (status == null) {
            throw new ResourceNotFoundException("Status id = " + id.toString());
        }
        return status;
    }

    public void delete(Integer id) {
        repo.deleteById(id);
    }

    @Transactional(readOnly = true)
    public List<StatusDto> getAll() {
        List<Status> list = repo.findAll();
        List<StatusDto> dtoList = new ArrayList<>();
        for (Status status : list) {
            StatusDto dto = mapper.getDto(status);
            dtoList.add(dto);
        }
        return dtoList;
    }

    @Transactional(readOnly = true)
    public StatusDto getDtoById(Integer id) throws ResourceNotFoundException {
        Status status = getById(id);
        if (status == null) {
            throw new ResourceNotFoundException();
        } else {
            return mapper.getDto(status);
        }
    }

    public Integer create(StatusDto statusDto) {
        Status status = mapper.getEntity(statusDto);
        repo.saveAndFlush(status);
        return status.getId();
    }

    public void update(StatusDto dto) {
//        Status status = getById(dto.getStatusId());
//        Status updStatus = mapper.getEntity(dto);
//        status = mapper.merge(status, updStatus);
//        repo.saveAndFlush(status);
    }
}
