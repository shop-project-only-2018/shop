package shop.controller.order;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import shop.ShopApplication;
import shop.model.order.PaymentMethod;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ShopApplication.class)
@AutoConfigureMockMvc
public class PaymentMethodResourceTest {

//    final static Logger logger = Logger.getLogger(PaymentMethodResourceTest.class);

    @Autowired
    public MockMvc mockMvc;

    @Autowired
    public PaymentMethodResource paymentMethodResource;

    private JacksonTester<PaymentMethod> jsonTester;

    @Before
    public void setUp() {
        ObjectMapper objectMapper = new ObjectMapper();
        JacksonTester.initFields(this, objectMapper);
    }

    @Test
    public void save() {
//        PaymentMethod paymentMethod = new PaymentMethod("Payment method");
//        String json = jsonTester.write(paymentMethod).getJson();
//        mockMvc
//                .perform(post("/paymentmethod").contentType(APPLICATION_JSON).content(json))
//                .andExpect(status().isCreated());
    }
}