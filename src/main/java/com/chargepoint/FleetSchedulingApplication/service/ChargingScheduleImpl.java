package com.chargepoint.FleetSchedulingApplication.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;


public class ChargingScheduleImpl implements ChargingScheduleInterface {
  private final Map<Integer, List<Integer>> assignments;
  private final int trucksCharged;

  public ChargingScheduleImpl(Map<Integer, List<Integer>> assignments, int trucksCharged) {
    this.assignments = assignments;
    this.trucksCharged = trucksCharged;
  }

  @Override
  public Map<Integer, List<Integer>> getAssignments() {
    return Collections.unmodifiableMap(assignments);
  }

  @Override
  public int getTrucksCharged() {
    return trucksCharged;
  }

  @Override
  public void printSchedule() {

  }

  @Override
  public String getFormattedSchedule() {
    StringBuilder sb = new StringBuilder();
    List<Integer> chargerIds = new ArrayList<>(assignments.keySet());
    Collections.sort(chargerIds);

    for (int chargerId : chargerIds) {
      List<Integer> truckIds = assignments.get(chargerId);
      sb.append(chargerId).append(": ");

      for (int i = 0; i < truckIds.size(); i++) {
        sb.append(truckIds.get(i));
        if (i < truckIds.size() - 1) {
          sb.append(", ");
        }
      }
      sb.append("\n");
    }
    sb.append("Total trucks charged: ").append(trucksCharged);
    return sb.toString();
  }
}

