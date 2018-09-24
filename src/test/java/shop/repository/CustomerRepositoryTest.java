package shop.repository;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import shop.ShopApplication;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = ShopApplication.class)
public class CustomerRepositoryTest {

    @Autowired
    public CustomerRepository r;

    @Before
    public void setUp() {
        System.out.println("IT'S ALIVE!");

    }

    @Test
    public void test() {
        System.out.println("IT'S ALIVE!");
    }

    @After
    public void tearDown() {
        System.out.println("IT'S ALIVE!");
    }

}
