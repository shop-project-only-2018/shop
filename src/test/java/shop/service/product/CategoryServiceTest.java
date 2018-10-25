package shop.service.product;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import shop.ShopApplication;
import shop.dtos.product.CategoryDto;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ShopApplication.class)
public class CategoryServiceTest {

    @Autowired
    public CategoryService categoryService;

    @Before
    public void setUp() throws Exception {
        clear();
    }

    @After
    public void tearDown() throws Exception {
        clear();
    }

    @Test
    public void save() {
        categoryService.save(new CategoryDto("1"));
        categoryService.save(new CategoryDto("2"));
        categoryService.save(new CategoryDto("3"));
        assert categoryService.categoryRepository.count() == 3;
    }

    private void clear() {
        categoryService.categoryRepository.deleteAll();
    }
}