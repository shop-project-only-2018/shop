package shop.controller.order;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
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
import shop.dtos.order.StatusDto;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ShopApplication.class)
@AutoConfigureMockMvc
public class StatusControllerTest {

    final static Logger logger = Logger.getLogger(StatusControllerTest.class);

    @Autowired
    public MockMvc mockMvc;

    @Autowired
    public StatusController statusController;

//    @MockBean
//    public StatusService statusService;

//    @MockBean
//    public StatusRepository statusRepository;

    private JacksonTester<StatusDto> jsonTester;

    @Before
    public void setUp() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        JacksonTester.initFields(this, objectMapper);
    }

    @Test
    public void save() throws Exception {
        StatusDto statusDto = new StatusDto("1234567890");
        String json = jsonTester.write(statusDto).getJson();
        mockMvc
                .perform(post("/status").contentType(APPLICATION_JSON).content(json))
                .andExpect(status().isCreated());
    }

    @Test
    public void getById() throws Exception {
        mockMvc.perform(get("/status/123")).andExpect(status().isNotFound());
    }

    @Test
    public void saveAndGetById() throws Exception {
        StatusDto statusDto = new StatusDto("0987654321");
        String json = jsonTester.write(statusDto).getJson();
        mockMvc
                .perform(post("/status").contentType(APPLICATION_JSON).content(json))
                .andExpect(status().isCreated());
//        mockMvc.perform(get("/status").param("id","0")).andExpect(status().isOk());
        mockMvc.perform(get("/status").param("id","0")).andExpect(status().isNotFound());
    }
}