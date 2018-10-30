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

    private CategoryRepository repo;

    private CategoryMapper mapper;

    @Autowired
    public void setRepo(CategoryRepository repo) {
        this.repo = repo;
    }

    @Autowired
    public void setMapper(CategoryMapper mapper) {
        this.mapper = mapper;
    }

    private Category getById(Integer id) throws ResourceNotFoundException {
        Category category = repo.findById(id).orElse(null);
        if (category == null) {
            throw new ResourceNotFoundException("Category id = " + id.toString());
        }
        return category;
    }

    public void delete(Integer id) {
        repo.deleteById(id);
    }

    @Transactional(readOnly = true)
    public List<CategoryDto> getAll() {
        List<Category> list = repo.findAll();
        List<CategoryDto> dtoList = new ArrayList<>();
        for (Category category : list) {
            CategoryDto dto = mapper.getDto(category);
            dtoList.add(dto);
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
        if(categoryDto.getParentCategoryId()!=null){
            try {
                Category parent =  getById(categoryDto.getParentCategoryId());
                category.setParent(parent);
            } catch (ResourceNotFoundException e) {}}
        if(repo==null)System.out.println("\n\n\n\n\n\n\nFUUUUUUUCK\n\n\n\n\n\n\n\n\n");
        if(category==null)System.out.println("\n\n\n\n\n\n\nWTF\n\n\n\n\n\n\n\n\n");
        if(category.getId()==null)System.out.println("\n\n\n\n\n\n\nTHIS IS NORMAL\n\n\n\n\n\n\n\n\n");
        repo.saveAndFlush(category);
        return category.getId();
    }

    public void update(CategoryDto dto) throws ResourceNotFoundException {
        Category category = getById(dto.getCategoryId());
        Category updCategory = mapper.getEntity(dto);
        category = mapper.merge(category, updCategory);
        repo.saveAndFlush(category);
    }

}
