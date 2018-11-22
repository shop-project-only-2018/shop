package shop.service.product;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import shop.ShopApplication;
import shop.dtos.product.CategoryDto;

import static org.junit.Assert.fail;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ShopApplication.class)
public class CategoryServiceTest {

    @Autowired
    public CategoryService service;

    @Test
    public void createRetrieveAndDelete() throws Exception {
        String name = "Category 1";
        CategoryDto categoryDto = new CategoryDto(name);
        Integer id = service.create(categoryDto);
        assert id != null;
        assert id > -1;

        CategoryDto retrievedDto = service.getDtoById(id);
        assert retrievedDto.getName().equals(name);

        service.delete(id);
        try {
            service.getDtoById(id);
            fail("Expected Exception");
        } catch (Exception e) {
        }
    }
}