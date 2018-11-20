package shop.service.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shop.dtos.product.ProductDto;
import shop.mappers.product.ProductMapper;
import shop.model.product.Book;
import shop.repository.product.CategoryRepository;
import shop.repository.product.ProductRepository;
import shop.system.exceptions.ResourceNotFoundException;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private CategoryRepository categoryRepository;
    private ProductRepository productRepository;
    private ProductMapper mapper;

    @Autowired
    public void setMapper(ProductMapper mapper) {
        this.mapper = mapper;
    }

    @Autowired
    public void setCategoryRepository(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    private Book getById(Integer id) throws ResourceNotFoundException {
        Book product = productRepository.findById(id).orElse(null);
        if (product == null) {
            throw new ResourceNotFoundException("Book id = " + id.toString());
        }
        return product;
    }

    public void delete(Integer id) {
        productRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public List<ProductDto> getAll() {
        List<Book> list = productRepository.findAll();
        List<ProductDto> dtoList = new ArrayList<>();
        for (Book product : list) {
            ProductDto dto = mapper.getDto(product);
            dtoList.add(dto);
        }
        return dtoList;
    }

    @Transactional(readOnly = true)
    public ProductDto getDtoById(Integer id) throws ResourceNotFoundException {
        Book product = getById(id);
        if (product == null) {
            throw new ResourceNotFoundException();
        } else {
            ProductDto orderDto = mapper.getDto(product);
            return orderDto;
        }
    }

    public Integer create(ProductDto productDto) {
        Book product = mapper.getEntity(productDto);
        productRepository.save(product);
        return product.getId();
    }

    public void update(ProductDto dto) throws ResourceNotFoundException {
        Book product = getById(dto.getProductId());
        Book updProduct = mapper.getEntity(dto);
        product = mapper.merge(product, updProduct);
        productRepository.saveAndFlush(product);
    }

}
