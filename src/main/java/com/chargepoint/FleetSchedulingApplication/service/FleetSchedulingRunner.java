package com.chargepoint.FleetSchedulingApplication.service;

import com.chargepoint.FleetSchedulingApplication.beans.Charger;
import com.chargepoint.FleetSchedulingApplication.beans.Truck;
import com.chargepoint.FleetSchedulingApplication.enums.SchedulingStrategy;
import com.chargepoint.FleetSchedulingApplication.utils.FleetSchedulingUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class FleetSchedulingRunner {

  private final ChargingScheduler scheduler;

  public FleetSchedulingRunner(ChargingScheduler scheduler) {
    this.scheduler = scheduler;
  }

  /**
   * Reads inputs from the file and runs scheduling.
   */
  public void runFromFile(String filePath) {
    try {
      List<Truck> trucks = FleetSchedulingUtils.parseTrucksFromFile(filePath);
      List<Charger> chargers = FleetSchedulingUtils.parseChargersFromFile(filePath);
      int timeAvailable = FleetSchedulingUtils.parseTimeAvailable(filePath);
      SchedulingStrategy strategy = FleetSchedulingUtils.parseStrategy(filePath);
      runStrategy(trucks, chargers, timeAvailable, strategy);
    } catch (IOException e) {
      throw new RuntimeException("Error reading input file: " + filePath, e);
    }
  }

  private void runStrategy(List<Truck> trucks, List<Charger> chargers, int timeAvailable, SchedulingStrategy strategy) {
    System.out.println("=== Running Strategy: " + strategy + " ===");
    scheduler.setTrucks(trucks);
    scheduler.setChargers(chargers);
    scheduler.setTimeAvailable(timeAvailable);
    ChargingScheduleInterface schedule = scheduler.schedule(strategy);
    System.out.println(schedule.getFormattedSchedule());
  }
}
