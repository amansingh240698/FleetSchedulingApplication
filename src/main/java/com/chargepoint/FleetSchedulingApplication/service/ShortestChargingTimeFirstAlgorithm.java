package com.chargepoint.FleetSchedulingApplication.service;

import com.chargepoint.FleetSchedulingApplication.beans.Charger;
import com.chargepoint.FleetSchedulingApplication.beans.ChargingAssignment;
import com.chargepoint.FleetSchedulingApplication.beans.Truck;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/** Algorithm that prioritizes trucks with shortest charging time */
@Service
class ShortestChargingTimeFirstAlgorithm extends BaseSchedulingAlgorithm {

  @Autowired
  public ShortestChargingTimeFirstAlgorithm(ChargingCalculator calculator) {
    super(calculator);
  }

  @Override
  public ChargingScheduleInterface createSchedule(
      Collection<Truck> trucks, Collection<Charger> chargers, int timeAvailable) {
    Map<Integer, List<Integer>> assignmentMap = new HashMap<>();
    int totalTrucksCharged = 0;
    List<Truck> remainingTrucks = new ArrayList<>(trucks);

    for (Charger charger : chargers) {
      // Calculate charging time for each truck with this charger
      List<ChargingAssignment> assignments =
          remainingTrucks.stream()
              .map(truck -> new ChargingAssignment(truck, charger, calculator))
              .sorted(Comparator.comparingDouble(ChargingAssignment::getChargingTime))
              .toList();

      // Assign trucks to this charger until we run out of time
      double remainingTime = timeAvailable;
      List<Integer> assignedTruckIds = new ArrayList<>();

      for (ChargingAssignment assignment : assignments) {
        double timeNeeded = assignment.getChargingTime();
        if (timeNeeded <= remainingTime) {
          int truckId = assignment.getTruck().getId();
          assignedTruckIds.add(truckId);
          remainingTime -= timeNeeded;
          totalTrucksCharged++;
        }
      }

      // Add these assignments to the schedule
      if (!assignedTruckIds.isEmpty()) {
        assignmentMap.put(charger.getId(), assignedTruckIds);

        // Remove assigned trucks from the remaining trucks
        for (Integer truckId : assignedTruckIds) {
          remainingTrucks.removeIf(t -> Objects.equals(t.getId(), truckId));
        }
      }
    }

    return new ChargingScheduleImpl(assignmentMap, totalTrucksCharged);
  }
}
