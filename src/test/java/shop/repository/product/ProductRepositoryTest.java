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
import shop.model.product.Product;

import java.math.BigDecimal;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = ShopApplication.class)
public class ProductRepositoryTest {

    @Autowired
    public ProductRepository productRepository;

    @Before
    public void setUp() {
        clear();
    }

    @Test
    public void saveSeveralItems() {
        productRepository.save(new Product("1", new BigDecimal(10), 1));
        productRepository.save(new Product("2", new BigDecimal(10), 1));
        productRepository.save(new Product("3", new BigDecimal(10), 1));
        productRepository.save(new Product("4", new BigDecimal(10), 1));
        productRepository.save(new Product("5", new BigDecimal(10), 1));
        assert productRepository.count() == 5;
    }

    @After
    public void tearDown() {
        clear();
    }

    private void clear() {
        productRepository.deleteAll();
    }
}
