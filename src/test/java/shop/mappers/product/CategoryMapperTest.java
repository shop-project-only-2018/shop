package shop.mappers.product;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import shop.ShopApplication;
import shop.model.product.Category;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ShopApplication.class)
public class CategoryMapperTest {

    private CategoryMapper mapper;

    @Autowired
    public void setMapper(CategoryMapper mapper) {
        this.mapper = mapper;
    }

    @Test
    public void merge() {
        String abc = "Abc abc";
        Category recipient = new Category("");
        Category source = new Category(abc);
        recipient = mapper.merge(recipient, source);
        assert recipient.getName().equals(abc);
    }
}