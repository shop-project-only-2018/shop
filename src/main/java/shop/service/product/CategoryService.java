package shop.service.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.dtos.product.CategoryDto;
import shop.model.product.Category;
import shop.repository.product.CategoryRepository;
import shop.system.exceptions.ResourceNotFoundException;
import shop.util.Mapper;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {

    @Autowired
    public CategoryRepository categoryRepository;

    public void save(CategoryDto categoryDTO) {
        Category category = Mapper.getEntity(categoryDTO);
        categoryRepository.save(category);
    }


    private Category getById(Integer id) {
        return categoryRepository.findById(id).orElse(null);
    }

    public boolean delete(Integer id) {
        Category category = getById(id);
        if (category != null) {
            categoryRepository.delete(category);
            return true;
        } else {
            return false;
        }
    }

    public List<CategoryDto> getAll() {
        List<Category> list = categoryRepository.findAll();
        List<CategoryDto> dtoList = new ArrayList<>();
        for (Category order : list) {
            CategoryDto sd = Mapper.getDto(order);
            dtoList.add(sd);
        }
        return dtoList;
    }

    public CategoryDto getDtoById(Integer id) throws ResourceNotFoundException {
        Category category = getById(id);
        if (category == null) {
            throw new ResourceNotFoundException();
        } else {
            CategoryDto orderDto = Mapper.getDto(category);
            return orderDto;
        }
    }

    public Integer create(CategoryDto categoryDto) {
        Category category = Mapper.getEntity(categoryDto);
        categoryRepository.save(category);
        return category.getId();
    }

    public void update(CategoryDto orderDto) {
// MERGE!
    }
}
