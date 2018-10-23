package shop.service.order;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import shop.ShopApplication;
import shop.dtos.order.StatusDto;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ShopApplication.class)
public class StatusServiceTest {

    @Autowired
    public StatusService statusService;

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
        assert statusService.save(new StatusDto("1", 0));
        assert statusService.save(new StatusDto("2", 0));
        assert statusService.statusRepository.count() == 2;
    }

    private void clear() {
        statusService.statusRepository.deleteAll();
    }
}