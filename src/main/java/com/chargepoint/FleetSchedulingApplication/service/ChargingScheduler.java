package com.chargepoint.FleetSchedulingApplication.service;

import com.chargepoint.FleetSchedulingApplication.beans.Charger;
import com.chargepoint.FleetSchedulingApplication.beans.Truck;
import com.chargepoint.FleetSchedulingApplication.enums.SchedulingStrategy;
import java.util.Collection;
import java.util.List;

public interface ChargingScheduler {
  ChargingScheduleInterface schedule(SchedulingStrategy strategy);
  ChargingScheduleInterface schedule(SchedulingAlgorithm algorithm);
  Collection<Truck> getTrucks();
  Collection<Charger> getChargers();
  int getTimeAvailable();
  void setTrucks(List<Truck> trucks);
  void setChargers(List<Charger> chargers);
  void setTimeAvailable(int timeAvailable);
}
