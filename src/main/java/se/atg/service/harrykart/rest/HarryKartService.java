package se.atg.service.harrykart.rest;

import org.springframework.stereotype.Service;
import se.atg.service.harrykart.types.*;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class HarryKartService {

    private static final Integer LANE_LENGTH = 1000;

    Map<String, Double> getTheTopWinners(HarryKart harryKart, Integer limit) {
        return compete(harryKart).entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.naturalOrder()))
                .limit(limit)
                .collect(Collectors.toMap(
                        Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
    }

    private Map<String, Double> compete(HarryKart harryKart) {
        PowerUps powerUps = harryKart.getPowerUps();
        StartList startList = harryKart.getStartList();
        return startList.getParticipant().stream().collect(Collectors.toMap(Participant::getName, participant -> calculateLaneRecord(participant, powerUps)));
    }

    private Double calculateLaneRecord(Participant participant, PowerUps powerUps) {
        List<Integer> participantPowerUpsByLoop = powerUps.getLoop().stream().map(loop -> getParticipantPowerupByLoop(participant, loop)).collect(Collectors.toList());
        return participantPowerUpsByLoop.stream().map(powerUp ->
                calculateParticipantsRecord(participant, powerUp)
        ).collect(Collectors.toList()).stream().reduce(Double::sum).get();
    }

    private Integer getParticipantPowerupByLoop(Participant participant, Loop loop) {
        Lane lanes = loop.getLane().stream().filter(lane -> lane.getNumber().equals(participant.getLane())).findAny().orElse(null);
        return Objects.isNull(lanes) ? null : lanes.getValue();
    }

    private Double calculateParticipantsRecord(Participant participant, Integer powerUp) {
        Integer currentSpeed = participant.getBaseSpeed() + powerUp;
        participant.setBaseSpeed(currentSpeed);
        if (currentSpeed > 0) {
            return (LANE_LENGTH / currentSpeed.doubleValue());
        } else {
            return Double.MAX_VALUE;
        }
    }
}
