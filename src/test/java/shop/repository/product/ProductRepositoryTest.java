package shop.repository.product;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import shop.ShopApplication;
import shop.model.product.Book;

import java.math.BigDecimal;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = ShopApplication.class)
public class ProductRepositoryTest {

    @Autowired
    public BookRepository productRepository;

    @Before
    public void setUp() {
        clear();
    }

    @Test
    public void saveSeveralItems() {
    }

    @After
    public void tearDown() {
        clear();
    }

    private void clear() {
        productRepository.deleteAll();
    }
}
