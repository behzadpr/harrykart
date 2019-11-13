package se.atg.service.harrykart.controller;

import org.junit.Before;
import org.junit.Test;
import se.atg.service.harrykart.model.HarryKart;
import se.atg.service.harrykart.model.PowerUps;
import se.atg.service.harrykart.model.StartList;

import java.util.Map;

import static org.junit.Assert.*;

public class HarryKartServiceTest {

    private HarryKartService harryKartService;
    private static final int TOP_WINNERS_LIMIT = 3;

    @Before
    public void setUp() throws Exception {
        harryKartService = new HarryKartService();
    }

    @Test
    public void getTheTopWinnersTest() throws Exception {
        HarryKart harryKart = new HarryKart();
        harryKart.setNumberOfLoops(3);
        harryKart.setPowerUps(new PowerUps());
        harryKart.setStartList(new StartList());

        Map<String, Double> harryKartServiceResult = harryKartService.getTheTopWinners(harryKart, TOP_WINNERS_LIMIT);
        assertEquals(0, harryKartServiceResult.size());
    }
}