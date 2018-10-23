package shop.repository.order;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import shop.ShopApplication;
import shop.model.order.Status;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = ShopApplication.class)
public class StatusRepositoryTest {

    @Autowired
    public StatusRepository statusRepository;

    @Before
    public void setUp() {
        clear();
    }

    @Test
    public void saveSeveralItems() {
        statusRepository.save(new Status("1"));
        statusRepository.save(new Status("2"));
        statusRepository.save(new Status("3"));
        statusRepository.save(new Status("4"));
        statusRepository.save(new Status("5"));
        statusRepository.save(new Status("6"));
        statusRepository.save(new Status("7"));
        statusRepository.save(new Status("8"));
        statusRepository.save(new Status("9"));
        assert statusRepository.count() == 9;
    }

    @After
    public void tearDown() {
        clear();
    }

    private void clear() {
        statusRepository.deleteAll();
    }
}
