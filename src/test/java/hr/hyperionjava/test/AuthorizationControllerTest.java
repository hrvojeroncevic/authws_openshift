package hr.hyperionjava.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import hr.hyperionjava.Application;

import static org.hamcrest.Matchers.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
public class AuthorizationControllerTest {

    private static final String CONTENT_TYPE = "application/json;charset=UTF-8";

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void setup() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void whenCreateGetEmployee_thenOk() throws Exception {
        String authorizationJson = "{\"id\":1,\"tstamp\":1553172678528,\"pan\":\"1111112222220005\",\"mid\":\"MID0001\",\"eurocents\":1000,\"status\":\"A\",\"respcde\":\"1\"}";

        this.mockMvc.perform(post("/authorizations").contentType(CONTENT_TYPE).content(authorizationJson)).andExpect(status().isCreated());

        this.mockMvc.perform(get("/authorizations")).andExpect(status().isOk()).andExpect(content().contentType(CONTENT_TYPE)).andExpect(jsonPath("$", hasSize(3))).andExpect(jsonPath("$[0].pan", is("1111112222220005"))).andExpect(jsonPath("$[2].pan", is("1111112222220001")));
    }
}
