package com.chargepoint.FleetSchedulingApplication.service;

import com.chargepoint.FleetSchedulingApplication.beans.Charger;
import com.chargepoint.FleetSchedulingApplication.beans.Truck;
import com.chargepoint.FleetSchedulingApplication.enums.SchedulingStrategy;
import com.chargepoint.FleetSchedulingApplication.repository.ChargerRepository;
import com.chargepoint.FleetSchedulingApplication.repository.TruckRepository;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
class ChargingSchedulerService implements ChargingScheduler {
  private final TruckRepository truckRepository;
  private final ChargerRepository chargerRepository;
  private final Map<SchedulingStrategy, SchedulingAlgorithm> algorithms;
  private int timeAvailable;

  @Autowired
  ChargingSchedulerService(
      TruckRepository truckRepository,
      ChargerRepository chargerRepository,
      ShortestChargingTimeFirstAlgorithm shortestTimeAlgorithm) {
    this.truckRepository = truckRepository;
    this.chargerRepository = chargerRepository;
    this.algorithms = new HashMap<>();
    this.algorithms.put(SchedulingStrategy.SHORTEST_CHARGING_TIME, shortestTimeAlgorithm);
  }

  @Override
  public ChargingScheduleInterface schedule(SchedulingStrategy strategy) {
    SchedulingAlgorithm algorithm = algorithms.get(strategy);
    if (algorithm == null) {
      throw new IllegalArgumentException("Unknown scheduling strategy: " + strategy);
    }
    return schedule(algorithm);
  }

  @Override
  public ChargingScheduleInterface schedule(SchedulingAlgorithm algorithm) {
    if (algorithm == null) {
      throw new IllegalArgumentException("Algorithm cannot be null");
    }

    Collection<Truck> trucks = truckRepository.findAll();
    Collection<Charger> chargers = chargerRepository.findAll();

    if (trucks.isEmpty()) {
      throw new IllegalStateException("No trucks available for scheduling");
    }
    if (chargers.isEmpty()) {
      throw new IllegalStateException("No chargers available for scheduling");
    }

    return algorithm.createSchedule(trucks, chargers, timeAvailable);
  }

  @Override
  public Collection<Truck> getTrucks() {
    return truckRepository.findAll();
  }

  @Override
  public Collection<Charger> getChargers() {
    return chargerRepository.findAll();
  }

  @Override
  public int getTimeAvailable() {
    return timeAvailable;
  }

  @Override
  public void setTrucks(List<Truck> trucks) {
    for (Truck truck : trucks) {
      truckRepository.save(truck);
    }
  }

  @Override
  public void setChargers(List<Charger> chargers) {
    for (Charger charger : chargers) {
      chargerRepository.save(charger);
    }
  }

  @Override
  public void setTimeAvailable(int timeAvailable) {
    this.timeAvailable = timeAvailable;
  }
}
