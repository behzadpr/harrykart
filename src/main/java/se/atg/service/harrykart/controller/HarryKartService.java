package se.atg.service.harrykart.controller;

import org.springframework.stereotype.Service;
import se.atg.service.harrykart.exceptions.InvalidValueException;
import se.atg.service.harrykart.exceptions.ParticipantNotFoundException;
import se.atg.service.harrykart.model.*;

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
        PowerUps powerUps = harryKart.getPowerUps()==null? new PowerUps() :harryKart.getPowerUps();
        StartList startList = harryKart.getStartList()==null? new StartList() : harryKart.getStartList();
        return startList.getParticipant().stream()
                .collect(Collectors.toMap(Participant::getName, participant -> calculateLaneRecord(participant, powerUps)));
    }

    private Double calculateLaneRecord(Participant participant, PowerUps powerUps) {
        List<Loop> loops = powerUps.getLoop()==null? new ArrayList<>() :powerUps.getLoop();
        List<Integer> participantPowerUpsByLoop = loops.stream()
                .map(loop -> getParticipantPowerupByLoop(participant, loop)).collect(Collectors.toList());

        return participantPowerUpsByLoop.stream().map(powerUp ->
                calculateParticipantsRecord(participant, powerUp)
        ).collect(Collectors.toList()).stream().reduce(Double::sum).get();
    }

    private Integer getParticipantPowerupByLoop(Participant participant, Loop loop) {
        Lane lanes = loop.getLane().stream().filter(lane -> lane.getNumber().equals(participant.getLane())).findAny().orElse(null);
        if (Objects.isNull(lanes)){
            throw new ParticipantNotFoundException();
        }
        else
        {
            return lanes.getValue();
        }
    }

    private Double calculateParticipantsRecord(Participant participant, Integer powerUp) {
        validateNullValues(participant.getBaseSpeed() , powerUp);
        Integer currentSpeed = participant.getBaseSpeed() + powerUp;
        participant.setBaseSpeed(currentSpeed);
        return currentSpeed > 0?
                LANE_LENGTH / currentSpeed.doubleValue():
                Double.MAX_VALUE;
    }

    private void validateNullValues(Integer ... numericValues) {
        for (Integer numericValue: numericValues) {
            if(Objects.isNull(numericValue))
                throw new InvalidValueException();
        }
    }
}
