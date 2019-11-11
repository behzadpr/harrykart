package se.atg.service.harrykart.rest;

import org.apache.commons.io.IOUtils;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import se.atg.service.harrykart.HarryKartApp;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = HarryKartApp.class)
@WebAppConfiguration
class HarryKartControllerTest {

/*    @MockBean
    private HarryKartService harryKartService;*/

    @Autowired
    WebApplicationContext webApplicationContext;
    private MockMvc mockMvc;
    String uri="/api/play";

    @Before
    public void setup(){

    }
    @Test
    void playHarryKart() throws Exception {
        DefaultMockMvcBuilder builder= MockMvcBuilders.webAppContextSetup(webApplicationContext);
        mockMvc= builder.build();
        performPost();
    }

    protected MvcResult performPost() throws Exception {
        return mockMvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_XML)
                .content(getInputXml())).andReturn();
    }

    public String getInputXml() {
        String fileName= "xml/input_0.xml";
        ClassLoader classLoader = getClass().getClassLoader();
        String result = null;

        try (InputStream inputStream = classLoader.getResourceAsStream(fileName)){
            result = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
        }catch (IOException e){
            e.printStackTrace();
        }
        return result;
    }


}