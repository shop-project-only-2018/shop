package shop.repository.product;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import shop.ShopApplication;
import shop.model.order.Status;
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
        categoryRepository.save(new Category("1"));
        categoryRepository.save(new Category("2"));
        categoryRepository.save(new Category("3"));
        categoryRepository.save(new Category("4"));
        categoryRepository.save(new Category("5"));
        categoryRepository.save(new Category("6"));
        categoryRepository.save(new Category("7"));
        categoryRepository.save(new Category("8"));
        categoryRepository.save(new Category("9"));
        categoryRepository.save(new Category("10"));
        assert categoryRepository.count() == 10;
    }

    @After
    public void tearDown() {
        clear();
    }

    private void clear() {
        categoryRepository.deleteAll();
    }
}
