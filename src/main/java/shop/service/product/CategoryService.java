package shop.service.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shop.dtos.product.CategoryDto;
import shop.mappers.product.CategoryMapper;
import shop.model.product.Category;
import shop.repository.product.CategoryRepository;
import shop.system.exceptions.ResourceNotFoundException;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {

    @Autowired
    public CategoryRepository categoryRepository;

    @Autowired
    private CategoryMapper mapper;


    public void save(CategoryDto categoryDTO) {
        Category category = mapper.getEntity(categoryDTO);
        categoryRepository.save(category);
    }

    private Category getById(Integer id) {
        return categoryRepository.findById(id).orElse(null);
    }

    public void delete(Integer id) {
        categoryRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public List<CategoryDto> getAll() {
        List<Category> list = categoryRepository.findAll();
        List<CategoryDto> dtoList = new ArrayList<>();
        for (Category order : list) {
            CategoryDto sd = mapper.getDto(order);
            dtoList.add(sd);
        }
        return dtoList;
    }

    @Transactional(readOnly = true)
    public CategoryDto getDtoById(Integer id) throws ResourceNotFoundException {
        Category category = getById(id);
        if (category == null) {
            throw new ResourceNotFoundException();
        } else {
            CategoryDto orderDto = mapper.getDto(category);
            return orderDto;
        }
    }

    public Integer create(CategoryDto categoryDto) {
        Category category = mapper.getEntity(categoryDto);
        categoryRepository.save(category);
        return category.getId();
    }

    public void update(CategoryDto dto) {
// MERGE!
    }

    public List<CategoryDto> retrieveAll() {
        return null;
    }
}
