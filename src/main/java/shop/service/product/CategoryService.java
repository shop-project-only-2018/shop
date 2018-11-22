package shop.service.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shop.dtos.product.CategoryDto;
import shop.mappers.product.CategoryMapper;
import shop.model.product.Category;
import shop.repository.product.CategoryRepository;
import shop.service.message.Messages;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {

    private CategoryRepository repo;
    private CategoryMapper mapper;
    private Messages messages;

    @Autowired
    public void setMessages(Messages messages) {
        this.messages = messages;
    }

    @Autowired
    public void setRepo(CategoryRepository repo) {
        this.repo = repo;
    }

    @Autowired
    public void setMapper(CategoryMapper mapper) {
        this.mapper = mapper;
    }

    private Category getById(Integer id) throws Exception {
        Category category = repo.findById(id).orElse(null);
        if (category == null) {
            throw new Exception(messages.get("error.unknown"));
            // TODO: log id
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
    public CategoryDto getDtoById(Integer id) throws Exception {
        Category category = getById(id);
        CategoryDto orderDto = mapper.getDto(category);
        return orderDto;
    }

    public Integer create(CategoryDto categoryDto) throws Exception {
        Category category = mapper.getEntity(categoryDto);
        Category parent = null;
        try {
            parent = getById(categoryDto.getParentCategoryId());
        } catch (Exception e) {
            throw new Exception("error.notFound.category.parent");
        }
        category.setParent(parent);
        repo.saveAndFlush(category);
        return category.getId();
    }

    public void update(CategoryDto dto) throws Exception {
        Category category = getById(dto.getCategoryId());
        Category updCategory = mapper.getEntity(dto);
        category = mapper.merge(category, updCategory);
        repo.saveAndFlush(category);
    }

}
