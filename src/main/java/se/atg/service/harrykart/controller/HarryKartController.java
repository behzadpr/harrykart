package se.atg.service.harrykart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import se.atg.service.harrykart.model.HarryKart;
import se.atg.service.harrykart.model.Ranking;
import se.atg.service.harrykart.model.RankingJson;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequestMapping("/api")
public class HarryKartController {

    private static final int TOP_WINNERS_LIMIT = 3;
    private final HarryKartService harryKartService;

    @Autowired
    public HarryKartController(HarryKartService harryKartService) {
        this.harryKartService = harryKartService;
    }

    /**
     * Launches the competition on the input provided in xml.
     * @param harryKart
     * @return Json answer presenting the rankings of top winners
     */
    @RequestMapping(method = RequestMethod.POST, path = "/play", consumes = "application/xml", produces = "application/json")
    public RankingJson playHarryKart(@RequestBody HarryKart harryKart) {
        harryKart = Objects.isNull(harryKart)? new HarryKart(): harryKart;
        Map<String, Double> topWinners = harryKartService.getTheTopWinners(harryKart, TOP_WINNERS_LIMIT);
        return mapToJsonResponse(topWinners);
    }

    /**
     * Constructs a json object from the competition's result
     * @param topWinners
     * @return
     */
    private RankingJson mapToJsonResponse(Map<String, Double> topWinners) {
        AtomicInteger position = new AtomicInteger(1);
        RankingJson rankingJson = new RankingJson();
        List<Ranking> rankingList = new ArrayList<>();
        topWinners.forEach((horseName, record) -> rankingList.add(createRanking(horseName, position.getAndIncrement())));
        rankingJson.setRanking(rankingList);
        return rankingJson;
    }

    private Ranking createRanking(String horse, int position) {
        Ranking ranking = new Ranking();
        ranking.setPosition(position);
        ranking.setHorse(horse);
        return ranking;
    }
}
