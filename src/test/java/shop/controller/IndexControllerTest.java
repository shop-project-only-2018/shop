package shop.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import shop.ShopApplication;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ShopApplication.class)
@AutoConfigureMockMvc
public class IndexControllerTest {

    @Autowired
    public MockMvc mockMvc;

    @Test
    public void expectRedirection() throws Exception {
        mockMvc
                .perform(get("/"))
                .andExpect(status().isOk());
        mockMvc
                .perform(get("/index.html"))
                .andExpect(status().isOk());
    }

}