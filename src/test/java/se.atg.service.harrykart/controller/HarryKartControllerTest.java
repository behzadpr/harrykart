package se.atg.service.harrykart.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import se.atg.service.harrykart.model.HarryKart;
import se.atg.service.harrykart.model.PowerUps;
import se.atg.service.harrykart.model.RankingJson;
import se.atg.service.harrykart.model.StartList;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HarryKartControllerTest {

    @Autowired
    private HarryKartService harryKartService;

    private HarryKartController harryKartController;

    @Before
    public void setUp() throws Exception {
        harryKartController = new HarryKartController(harryKartService);
    }

    @Test
    public void playHarryKartTest_emptyHarryKart() throws Exception {
        RankingJson harryKartPlayResult = harryKartController.playHarryKart(new HarryKart());
        assertEquals(0, harryKartPlayResult.getRanking().size());
    }

    @Test
    public void playHarryKartTest_harrKartWithoutValues() throws Exception {
        HarryKart harryKart = new HarryKart();
        harryKart.setNumberOfLoops(3);
        harryKart.setPowerUps(new PowerUps());
        harryKart.setStartList(new StartList());

        RankingJson harryKartPlayResult = harryKartController.playHarryKart(harryKart);

        assertEquals(0, harryKartPlayResult.getRanking().size());
    }

}