package se.atg.service.harrykart.controller;

import org.apache.commons.io.IOUtils;
import org.junit.Before;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MvcResult;
import se.atg.service.harrykart.model.RankingJson;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import static org.junit.Assert.assertEquals;

public class HarryKartControllerTest extends HarryKartAbstractTest {

    @Before
    public void setUp() {
        super.setUp();
    }

    @Test
    public void playHarryKart_example1() throws Exception {
        String inputXmlFileName= "xml/input_0.xml";
        String expectedResultJson= "json/input_0_expected_result.json";
        String expectedResult = readResource(expectedResultJson);
        MvcResult mvcResult= performPost(readResource(inputXmlFileName));
        String content = mvcResult.getResponse().getContentAsString();
        RankingJson rankingJsonActual = super.mapFromJson(content, RankingJson.class);
        RankingJson rankingJsonExpected = super.mapFromJson(expectedResult, RankingJson.class);

        assertEquals(HttpStatus.OK.value(), mvcResult.getResponse().getStatus());
        JSONAssert.assertEquals(expectedResult, content, true);
    }

    @Test
    public void playHarryKart_example2() throws Exception {
        String inputXmlFileName= "xml/input_1.xml";
        String expectedResultJson= "json/input_1_expected_result.json";
        String expectedResult = readResource(expectedResultJson);
        MvcResult mvcResult= performPost(readResource(inputXmlFileName));
        String content = mvcResult.getResponse().getContentAsString();

        assertEquals(HttpStatus.OK.value(), mvcResult.getResponse().getStatus());
        JSONAssert.assertEquals(expectedResult, content, true);
    }

    @Test
    public void playHarryKart_example3() throws Exception {
        String inputXmlFileName= "xml/input_2.xml";
        String expectedResultJson= "json/input_1_expected_result.json";
        String expectedResult = readResource(expectedResultJson);
        MvcResult mvcResult= performPost(readResource(inputXmlFileName));
        String content = mvcResult.getResponse().getContentAsString();

        assertEquals(HttpStatus.NOT_FOUND.value(), mvcResult.getResponse().getStatus());
    }

    private String readResource(String resourceUrl) {
        ClassLoader classLoader = getClass().getClassLoader();
        String result = null;

        try (InputStream inputStream = classLoader.getResourceAsStream(resourceUrl)){
            result = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
        }catch (IOException e){
            e.printStackTrace();
        }
        return result;
    }

}