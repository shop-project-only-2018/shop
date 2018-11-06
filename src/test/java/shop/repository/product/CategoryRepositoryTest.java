package shop.repository.product;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import shop.ShopApplication;
import shop.model.product.Category;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = ShopApplication.class)
public class CategoryRepositoryTest {

    @Autowired
    public CategoryRepository categoryRepository;

    @Before
    public void setUp() {
        clear();
    }

    @Test
    public void saveSeveralItems() {
        categoryRepository.save(new Category(0, "1"));
        categoryRepository.save(new Category(0, "2"));
        categoryRepository.save(new Category(0, "3"));
        assert categoryRepository.count() == 3;
    }

    @After
    public void tearDown() {
        clear();
    }

    private void clear() {
        categoryRepository.deleteAll();
    }
}
