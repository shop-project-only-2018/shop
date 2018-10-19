package shop.controller.order;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import shop.ShopApplication;
import shop.dtos.order.OrderDto;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ShopApplication.class)
@AutoConfigureMockMvc
public class OrderControllerTest {

    final static Logger logger = Logger.getLogger(OrderControllerTest.class);
    @Value("${paths.order}")
    public String URL;
    @Autowired
    public MockMvc mockMvc;

    private JacksonTester<OrderDto> jsonTester;

    @Before
    public void setUp() {
        ObjectMapper objectMapper = new ObjectMapper();
        JacksonTester.initFields(this, objectMapper);
    }

    @Test
    public void saveEmptyAndGetError() throws Exception {
        OrderDto orderDto = new OrderDto();
        String json = jsonTester.write(orderDto).getJson();
        mockMvc
                .perform(post("/" + URL).contentType(APPLICATION_JSON).content(json))
                .andExpect(status().is4xxClientError());
    }

}