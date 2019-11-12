package se.atg.service.harrykart.controller;

import org.apache.commons.io.IOUtils;
import org.junit.Before;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MvcResult;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
        String actualResult = mvcResult.getResponse().getContentAsString();

        assertEquals(HttpStatus.OK.value(), mvcResult.getResponse().getStatus());
        JSONAssert.assertEquals(expectedResult, actualResult, true);
    }

    @Test
    public void playHarryKart_example2() throws Exception {
        String inputXmlFileName= "xml/input_1.xml";
        String expectedResultJson= "json/input_1_expected_result.json";
        String expectedResult = readResource(expectedResultJson);
        MvcResult mvcResult= performPost(readResource(inputXmlFileName));
        String actualResult = mvcResult.getResponse().getContentAsString();

        assertEquals(HttpStatus.OK.value(), mvcResult.getResponse().getStatus());
        JSONAssert.assertEquals(expectedResult, actualResult, true);
    }

    /**
     **Start List:**
     | Lane | Horse name     | Base speed |
     |------|----------------|------------|
     | 1    | TIMETOBELUCKY  | 10         |
     | 2    | CARGO DOOR     | 10         |

     **Power-Ups/Downs:**
     | Loop | Lane 1 | Lane 3 |
     |------|--------|--------|
     | 1    | 0      | 0      |
     | 2    | 10     | 0      |

     * @throws Exception
     */
    @Test
    public void playHarryKart_participantsNotMatchingLoops() throws Exception {
        String inputXmlFileName= "xml/input_2_not_maching_loops_participants.xml";
        MvcResult mvcResult= performPost(readResource(inputXmlFileName));
        String actualResult = mvcResult.getResponse().getContentAsString();

        assertEquals(HttpStatus.NOT_FOUND.value(), mvcResult.getResponse().getStatus());
        assertTrue(actualResult.contains("Lanes and participants not matched"));
    }

    /**
     **Start List:**
     | Lane | Horse name     | Base speed |
     |------|----------------|------------|
     | 1    | TIMETOBELUCKY  | 10         |
     | 2    | CARGO DOOR     | 10         |

     **Power-Ups/Downs:**
     | Loop | Lane 1 | Lane 2 |
     |------|--------|--------|
     | 1    | 0      | 0      |
     | 2    | 0      | -10    |

     * @throws Exception
     */
    @Test
    public void playHarryKart_negativePowerUpEqualToSpeed() throws Exception {
        String inputXmlFileName= "xml/input_3_nagative_powerup_equalto_speed.xml";
        String expectedResultJson= "json/input_3_expected_result.json";
        String expectedResult = readResource(expectedResultJson);
        MvcResult mvcResult= performPost(readResource(inputXmlFileName));
        String actualResult = mvcResult.getResponse().getContentAsString();

        assertEquals(HttpStatus.OK.value(), mvcResult.getResponse().getStatus());
        JSONAssert.assertEquals(expectedResult, actualResult, true);
    }

    /**
     **Start List:**
     | Lane | Horse name     | Base speed |
     |------|----------------|------------|
     | 1    | TIMETOBELUCKY  | 10         |
     | 2    | CARGO DOOR     | 10         |
     * @throws Exception
     */
    @Test
    public void playHarryKart_invalidValue() throws Exception {
        String inputXmlFileName= "xml/input_4_invalid_value.xml";
        MvcResult mvcResult= performPost(readResource(inputXmlFileName));
        String actualResult = mvcResult.getResponse().getContentAsString();

        assertEquals(HttpStatus.NOT_ACCEPTABLE.value(), mvcResult.getResponse().getStatus());
        assertTrue(actualResult.contains("Invalid value detected in input xml"));
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